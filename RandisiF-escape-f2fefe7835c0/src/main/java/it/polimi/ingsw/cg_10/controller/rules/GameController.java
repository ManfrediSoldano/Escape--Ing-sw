package it.polimi.ingsw.cg_10.controller.rules;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.cg_10.controller.server.ServerComunication;
import it.polimi.ingsw.cg_10.model.com.ComAction;
import it.polimi.ingsw.cg_10.model.com.ComAttack;
import it.polimi.ingsw.cg_10.model.com.ComDrawCard;
import it.polimi.ingsw.cg_10.model.com.ComEndTurn;
import it.polimi.ingsw.cg_10.model.com.ComMove;
import it.polimi.ingsw.cg_10.model.com.ComNoise;
import it.polimi.ingsw.cg_10.model.com.ComUseCard;
import it.polimi.ingsw.cg_10.model.game.AdvancedGame;
import it.polimi.ingsw.cg_10.model.game.Game;
import it.polimi.ingsw.cg_10.model.map.DangerousSector;
import it.polimi.ingsw.cg_10.model.map.EscapeHatchSector;
import it.polimi.ingsw.cg_10.model.map.Sector;
import it.polimi.ingsw.cg_10.model.player.Alien;
import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.model.player.PlayerRecord;

public class GameController implements Observer{

	private PossibiliAzioni possibiliAzioni;
	private static ServerComunication sercommunication;
	private ComAction comAction;
	private static boolean newAction;
	private int backupPhase = 0;
	private static Game game;
	
	public GameController(ServerComunication sercommunication) {
		GameController.sercommunication = sercommunication;
		newAction = false;
		GameController.sercommunication.addObserver(this);
	}

	public Game run(Game match) {

		GameController.game = match;
		boolean objUsed = false;
		boolean phaseFinished = false;
		possibiliAzioni = new PossibiliAzioni();
		int phase = 0;
		while(phase!=99){
			phaseFinished = false;
			possibiliAzioni.phase(phase , objUsed);								
			GameController.game.setPossibiliAzioni (possibiliAzioni);
			sendGameStatus();
			while (!phaseFinished){
				if(newAction){				
					if (comAction instanceof ComUseCard){
						if(!objUsed){
							boolean b=CardController.useObjCard(GameController.game, game.findFromUsername(game.getUserTurno()), ((ComUseCard)comAction).getCardIdx());
							if (b){
								backupPhase = phase;
								phase = 6;
								phaseFinished = true;
							}else
								GameController.game.setMessage("Hai giocato: " +game.findFromUsername(game.getUserTurno()).getObjOwned().getCardList().get(((ComUseCard)comAction).getCardIdx()).getObjType().toString());

							objUsed = true;
						}else{  
							GameController.game.setMessage("Hai gia` giocato una carta oggetto in questo turno");
						}
					}
					switch (phase){
					
						case 0:			//fase movimento
							if(comAction instanceof ComMove){
								if(movePhase(comAction)){
									game.setMessage("Mosso in "+game.findFromUsername(game.getUserTurno()).getMovementRec().getLastPlayerRecord().getPosition());
									phase = sectorEffect();
									phaseFinished = true;
								}else
									game.setMessage("Mossa illegale");
							}
									
							break;

						case 1: //fase carta pericolosa o attacco
						case 2: //fase carta pericolosa
						case 3: //fase carta attacco o fineturno
							if(comAction instanceof ComAttack){
								if(attackPhase()){
									GameController.game.setMessage("Hai attaccato");
									phase = 4;
									phaseFinished = true;	
								}
							}else if (comAction instanceof ComDrawCard){	
								boolean b=CardController.dangerousCard (game.findFromUsername(game.getUserTurno()),GameController.game); //ritorna true se è da chiedere in che settore rumore
								GameController.game.setMessage("Hai pescato una carta settore");
								phase= 4;
								if (b){
									GameController.game.setMessage("Hai pescato una carta rumore in qualche settore, seleziona dove vuoi fare rumore");
									phase = 5;
								}
								phaseFinished = true;
							}else if (comAction instanceof ComEndTurn){	
								endRound();
								GameController.game.setMessage("Fine turno");
								phase=99;
								phaseFinished = true;
							}
							break;
							
						case 4:
							if(comAction instanceof ComEndTurn){
								endRound();
								GameController.game.setMessage("Fine turno");
								phase=99;
								phaseFinished = true;	
							}
							break;
							
						case 5: //aspetto dove fare rumore
							if(comAction instanceof ComNoise){
								GameController.game.clearToPublish();
								GameController.game.setToPublish(game.findFromUsername(game.getUserTurno()).getPlayerName()+": Rumore in settore "+((ComNoise) comAction).getCoordinata());
								phase= 4;
								phaseFinished = true;
							}
							break;
							
						case 6: //aspetto dove fare luce
							if(comAction instanceof ComNoise){
								Sector sector = ((ComNoise) comAction).getSector();
								GameController.game.clearToPublish();
								for (int i = 0; i< GameController.game.getPlayerList().size();i++){
									if(GameController.game.getPlayerList().get(i).getMovementRec().getLastPlayerRecord().getPosition().equals(sector) || 
										sector.getConfini().contains(GameController.game.getPlayerList().get(i).getMovementRec().getLastPlayerRecord().getPosition().getSectorID()))
										GameController.game.setToPublish("Nel settore "+sector.getSectorID()+" si trova "+ GameController.game.getPlayerList().get(i).getPlayerName());
								}
								phase = backupPhase;
								phaseFinished = true;
								
							}
							break;
							
					}
					sendGameStatus();
					newAction = false;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			}
		}
		return game;
	}


	private int sectorEffect() {
		int retValue;
		Sector sec=game.findFromUsername(game.getUserTurno()).getMovementRec().getLastPlayerRecord().getPosition();
		if(sec instanceof DangerousSector){
			if(game.findFromUsername(game.getUserTurno()) instanceof Alien)
				retValue = 1;	//carta o attacco
			else 
				retValue = 2;	//carta

		}else if(game.findFromUsername(game.getUserTurno()) instanceof Alien)
			retValue= 3;	//attacco
		else{
			if (sec instanceof EscapeHatchSector){
				escapeSectorEffect();
			}
			retValue=4;		//fine turno
		}
		return retValue;
	}

	private void escapeSectorEffect() {
		
	}

	private static boolean movePhase(ComAction comaction) {
		boolean retValue = false;
		Movement movement = new Movement(game.getZone());	
		movement.checkMovementPossibili(game.findFromUsername(game.getUserTurno()));		
		if(comaction instanceof ComMove){
			Sector sector = game.getZone().getSectors().get(((ComMove) comaction).getCoordinate().fromCoordToArrayIdx());
			retValue= movement.getMovementPossibiliSector().contains(sector);
			if(retValue){
				game.findFromUsername(game.getUserTurno()).getMovementRec().getMovementList().add(new PlayerRecord(game.findFromUsername(game.getUserTurno()).getMovementRec().getLastPlayerRecord().getRecordID()+1 ,sector));
				game.getPlayerList().get(game.findFromUsername(game.getUserTurno()).getPlayerID()).setMovementRec(game.findFromUsername(game.getUserTurno()).getMovementRec());
			}
		}
		return retValue;
	}	
	
	
	public static boolean attackPhase() {
		if(game.findFromUsername(game.getUserTurno()) instanceof Alien){
			Sector sector = game.findFromUsername(game.getUserTurno()).getMovementRec().getLastPlayerRecord().getPosition();
			game.setToPublish(game.findFromUsername(game.getUserTurno()).getPlayerName()+" attacca "+sector.getSectorID().toString());
			for(int i=0; i<game.getPlayerList().size(); i++){
				if (game.getPlayerList().get(i).getMovementRec().getLastPlayerRecord().getPosition()==sector && game.getPlayerList().get(i)!=game.findFromUsername(game.getUserTurno()) && game.getPlayerList().get(i).isAlive()){
					playerDied(game.getPlayerList().get(i));//player muore
					if(game instanceof AdvancedGame && game.getPlayerList().get(i) instanceof Human){
						((Alien) game.findFromUsername(game.getUserTurno())).setKillHuman(true); 
					}
				}	
			}
			return true;
		}else if (game.findFromUsername(game.getUserTurno()) instanceof Human){
			Sector sector;
			sector = game.findFromUsername(game.getUserTurno()).getMovementRec().getLastPlayerRecord().getPosition();
			for(int i=0; i<game.getPlayerList().size(); i++){
				if (game.getPlayerList().get(i).getMovementRec().getLastPlayerRecord().getPosition()==sector){
					if(game.getPlayerList().get(i)!=game.findFromUsername(game.getUserTurno())){
						playerDied(game.getPlayerList().get(i));//player morto
					}
				}
			}
			return true;
		}
		return false;
	}
	
	private static void playerDied(Player player) {
		if(CardEffect.checkDefenseCard(game, player))
			return;
		
		player.setAlive(false);

		for (int i=player.getObjOwned().getCardList().size(); i>0; --i)
			player.getObjOwned().removeCardFromHand(player.getObjOwned().getCardList().get(i), ((AdvancedGame)game).getObjectDeck());
		
		game.setToPublish(player.getPlayerName().toString()+" e` stato ucciso!");
	}

	private static void endRound() {
		
		if(game.findFromUsername(game.getUserTurno()) instanceof Human){ //annullo gli effetti delle carte settore
			((Human) game.findFromUsername(game.getUserTurno())).setAdrenaline(false);
			((Human) game.findFromUsername(game.getUserTurno())).setSedative(false);
		}
		CardController.checkDecks(game);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		comAction = (ComAction) arg;
		GameController.newAction = true;
	}
	
	
	public static void sendGameStatus() {
		String d = game.serialize();
		sercommunication.publish(d, game.getID());	
		game.clearToPublish();
	}


}
