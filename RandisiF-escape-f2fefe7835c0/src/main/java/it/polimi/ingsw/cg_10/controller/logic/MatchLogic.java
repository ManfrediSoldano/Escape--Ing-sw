package it.polimi.ingsw.cg_10.controller.logic;



import java.util.ArrayList;

import it.polimi.ingsw.cg_10.controller.rules.GameController;
import it.polimi.ingsw.cg_10.controller.server.ServerComunication;
import it.polimi.ingsw.cg_10.model.game.AdvancedGame;
import it.polimi.ingsw.cg_10.model.game.Game;
import it.polimi.ingsw.cg_10.model.map.AlienSector;
import it.polimi.ingsw.cg_10.model.map.HumanSector;
import it.polimi.ingsw.cg_10.model.map.Zone;
import it.polimi.ingsw.cg_10.model.player.Alien;
import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.model.player.PlayerRecord;
import it.polimi.ingsw.cg_10.model.player.Room;

public class MatchLogic extends Thread{

	private final static int TOT_NUM_TURNI = 39;
	private GameController gamecontroller;
	private Counter counter;
	private static Game match;
	private static ServerComunication sercommunication;
	private static int ID;
	
	public MatchLogic (Room room, int ID, ServerComunication sercommunication){
		gamecontroller = new GameController(sercommunication);
		counter = new Counter();
		setID(ID);
		setSercommunication(sercommunication);
		
		if(room.getAdvanced())
			match = new AdvancedGame();
		else
			match = new Game();
		match.setPlayerList(getPlayerType(room.getArrayList()));
		ZoneCreator zoneCreator = new ZoneCreator();

		Zone zone;
		zone = zoneCreator.zoneCreator(room.getMappa());
		match.setZone(zone);
		match.setID(ID);
		setPlayerOnStartPosition(match);	
		run();
	}

	
	public ServerComunication getSercommunication() {
		return sercommunication;
	}

	public void setSercommunication(ServerComunication sercommunication) {
		MatchLogic.sercommunication = sercommunication;
	}

	public static boolean checkFinish(Game matc) {

		int humansOnGame = 0;
		int numTurni = TOT_NUM_TURNI;
		Player player;
		int playerTurno;
		
		for (int i=0; i<matc.getPlayerList().size(); i++){
			player = matc.getPlayerList().get(i);
			if(player instanceof Human){
				if(matc instanceof AdvancedGame){			//gioco modalita avanzata
					if(player.isAlive() || !((Human) player).isSave())
						humansOnGame++;
				}else{
					if(((Human) player).isSave()&& !(match instanceof AdvancedGame)){
						sercommunication.publish("[SYSTEM] ha vinto il giocatore: "+player.getPlayerName()+", complimenti!", ID);
						return true;
						 
					}
					else if (((Human) player).isSave()&& (match instanceof AdvancedGame)){
						sercommunication.publish("[SYSTEM]il giocatore : "+player.getPlayerName()+", si 1e salvato ed è entrato nella schiera dei vincenti!", ID);
					}
						//se un umano è arrivato nel settore scialuppa
					if(player.isAlive())
						humansOnGame++;	// conto quanti umani sono ancora vivi
				}
			}
			playerTurno = player.getMovementRec().getLastPlayerRecord().getRecordID();	
			if (playerTurno < numTurni){
				numTurni = playerTurno;	
					
			}
	
		}	
		
		if(humansOnGame == 0 && !(match instanceof AdvancedGame)){
			sercommunication.publish("[SYSTEM] Hanno vinto gli alieni! Tutti gli umani sono morti!", ID);
			return true;
			 
		}
		if(humansOnGame == 0 && (match instanceof AdvancedGame)){
			sercommunication.publish("[SYSTEM] Gli alieni e gli umani sopravvissuti hanno vinto, non ci sono più umani in gioco!", ID);
			return true;
			 
		}
		else if(numTurni == TOT_NUM_TURNI){
			sercommunication.publish("[SYSTEM] Hanno vinto gli alieni! Turni finiti, gli umani non sono risuciti a scappare!", ID);
			return true;
			//se non ci sono piu umani in gioco
		}
			
		
		return false;
	}
	
	public static void endMatch(Game match) {
		System.out.println("Match quit, press a key to create new match");
	}
	
	public void setPlayerOnStartPosition(Game game) {
		Player player;
		
		for (int i=0; i<game.getPlayerList().size(); i++){
			player =game.getPlayerList().get(i);
			if( player instanceof Human)
				player.getMovementRec().getMovementList().add(new PlayerRecord(0, game.getZone().getSpecificSector(new HumanSector()).get(0)));
			else if( player instanceof Alien)
				player.getMovementRec().getMovementList().add(new PlayerRecord(0, game.getZone().getSpecificSector(new AlienSector()).get(0)));
		}	
	}


	public ArrayList<Player> getPlayerType(ArrayList<Player> arrayList) {
		int count=0;
		ArrayList<Player> temp = new ArrayList<Player>();
		int humans = 0;
		int aliens = 0;
		
		for(Player player: arrayList){
			if(humans>=aliens){
				System.out.println("Nuovo alieno");
				player.setPlayerID(count);
				String username = player.getPlayerName();
				player = new Alien(player.getPlayerID());
				player.setPlayerName(username);
				temp.add(player);
				aliens++;
			}
			else if(humans<aliens){
				System.out.println("Nuovo umano");
				player.setPlayerID(count);
				String username = player.getPlayerName();
				player = new Human(player.getPlayerID());
				player.setPlayerName(username);
				temp.add(player);
				humans++;
			}
			count++;
		}
		
		
		return temp;
		
		
	}

	public void endTimeTurn(String username, Game matc) {
		
		for(Player player:matc.getPlayerList()){
			if(player.getPlayerName().equals(username)){
			player.setActive(false);	
			matc.getPlayerList().add(player.getPlayerID(), player);
			match.setToPublish(match.getToPublish()+ " Il giocatore " + player.getPlayerName()+ " è stato disattivato per via del timeout.");
			}
		}
	
		match=matc;
		counter.start();		
	}


	@Override
	public void run() {
		boolean isFinished = false;
		while (!isFinished){
			for (Player p : match.getPlayerList()) {
				//gioca
				if(p.isAlive()){
					match.setUserTurno(p.getPlayerName());
					match= gamecontroller.run(match);
				}
				isFinished=checkFinish(match);
				if(isFinished)
					break;
			}
		}			
		endMatch(match);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	

}
