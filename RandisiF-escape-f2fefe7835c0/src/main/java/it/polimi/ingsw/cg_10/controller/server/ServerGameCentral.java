package it.polimi.ingsw.cg_10.controller.server;

import java.util.ArrayList;

import it.polimi.ingsw.cg_10.controller.logic.MatchLogic;
import it.polimi.ingsw.cg_10.model.com.ComAction;
import it.polimi.ingsw.cg_10.model.com.ComChat;
import it.polimi.ingsw.cg_10.model.com.ComChooseRoom;
import it.polimi.ingsw.cg_10.model.com.ComFirstConnection;
import it.polimi.ingsw.cg_10.model.com.ComServerReply;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.model.player.Room;

/**
 * @author Manfredi
 *
 */
public class ServerGameCentral{
	private	ArrayList<Player> playerlist = new ArrayList<Player>();
	private	ArrayList<Room> rm = new ArrayList<Room>();
	private static ServerComunication sercommunication;
	private Integer room_index=-1;
	private ArrayList<MatchLogic> sm=new ArrayList<MatchLogic>();
	
	public ServerGameCentral() {
	
	}
	
	public ComAction receivedMessage(ComAction comaction,ServerComunication sc){
		sercommunication=sc;
		ComAction returnCom = null;
		if(comaction instanceof ComFirstConnection)
		{
			returnCom = firstConnection(((ComFirstConnection) comaction).getUser());
		}
		else if(comaction instanceof ComChooseRoom){
	
			returnCom = comchooseroom(((ComChooseRoom) comaction));
		}		
		else if(comaction instanceof ComChat){
			returnCom = newChat((ComChat)comaction);
		}
		return returnCom;
		
		
	}
	
	private ComAction newChat(ComChat comaction) {
		
		for(Room room: rm){
			ArrayList<Player> pl= room.getArrayList();
			for(Player player: pl){
			
				if(player.getPlayerName().equals(comaction.getUsername())){
					sercommunication.publish(comaction.getUsername()+ ": " + comaction.getTesto(), room.getID());
					return new ComServerReply("Messaggio inviato", true);

				}
			}
		}
		return new ComServerReply("Impossibile inviare il messaggio", false);
	}

	private ComAction comchooseroom(ComChooseRoom comChooseRoom) {
		ComAction comris = null;
		// Boolean token=false;
		if(playerAlreadyInARoom(comChooseRoom.getUsername())){
			return new ComServerReply("Rinserito nella partita.",true);
		}
		
		
		for (Player player : playerlist) {
			if (player.getPlayerName().equals(comChooseRoom.getUsername())) {
				
				comris = checkRoom(player, comChooseRoom.getAdvancedGame());
				if (comris instanceof ComServerReply) {
					{
						
						if(!((ComServerReply) comris).getConferma()){

							//System.out.println("Richiesta nuova partita");
							int rmid = addRm();
							Room room = rm.get(rmid);
							room.setAdvanced(comChooseRoom.getAdvancedGame());
							room.setMappa(comChooseRoom.getMappa());
							room.addPlayerToRoom(player);
							
							rm.set(rmid, room);
							// Timer attesa
							startCounter(rmid);
	
							comris = new ComServerReply(Integer.toString(rmid),true);
							//sc.publish("In attesa di altri giocatori", rmid);
							return comris;

						}
					}
					
				}
			}
		}

		//comris = new ComServerReply("Non è stato possibile inserirti nella partita, riprova.",
		//		false);
		return comris;
	}
	//Controllo la stanza
	private boolean playerAlreadyInARoom(String resource) {
		for(Room room: rm){
			if(room.findFromUsername(resource)!=null && room.getActive()){
					System.out.println("Giocatore presente in una stanza arriva");
				//	comaction = new ComServerReply("Giocatore già presente, se eri già presente in una partita sarai reinserito.", false);
					return true;
			}
		}	
			return false;	
	}


	private void startCounter(int ID) {
		Counter counter = new Counter(20,ID,this);

		counter.start();
	}
	
	public void stopCounter(int ID){
		Room room = rm.get(ID);
		if(room.getArrayList().size()<2){
			System.out.println("Per mancanza di giocatori non è iniziata la partita "+Integer.toString(ID));
			startCounter(ID);
		}
		else{
			room.setActive(false);
			sm.add(new MatchLogic(room,room.getID(),sercommunication));
		}
	}

	public ArrayList<Room> getRm() {
		return rm;
		
	}

	public void setRm(ArrayList<Room> rm) {
		this.rm = rm;



	}
	
	public int addRm(){
		room_index = room_index+1;
		Room room = new Room(room_index);
		room.setActive(true);
		rm.add(room);
		return room_index;
	}
	


	private ComAction firstConnection(String resource) {
		ComServerReply comaction ;
		System.out.println("Connesso un nuovo giocatore con il nome di" + resource);
		//Se giocatore già presente in una partita viene rinserito
		for (Player player:playerlist){
			if( player.getPlayerName().equals(resource)){
				for(Room room: rm){
					if(room.findFromUsername(resource)!=null && room.getActive()){
							System.out.println("Giocatore presente");
							comaction = new ComServerReply("Giocatore già presente, se eri già presente in una partita sarai reinserito.", false);
							return comaction;
					}
				}
			}
		}
		
		//else
		
		Player giocatore = new Player(1);
		giocatore.setPlayerName(resource);
		playerlist.add(giocatore);
		
		comaction= new ComServerReply("Giocatore inserito",true) ;
		
		return comaction;
		
	}


	private ComAction checkRoom(Player giocatore, boolean advanced) {
		ComAction retur = new ComAction();
		for(Room room: rm){
			if(room.getActive()&&room.getArrayList().size()<8&&room.getAdvanced()==advanced){
				room.addPlayerToRoom(giocatore);
				retur= new ComServerReply("Aggiunto alla partita:"+room.getID(),true);
				return retur;
			}
		}
		
		retur = new ComServerReply("NuovaPartita", false);
		return retur;
	}

	

	public static ServerComunication getSercommunication() {
		return sercommunication;
	}

	public void setCommunication(ServerComunication serverComunication) {
		ServerGameCentral.sercommunication= serverComunication;
		
	}

	
	}


