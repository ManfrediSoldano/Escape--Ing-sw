package it.polimi.ingsw.cg_10.controller.socket;

import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.model.player.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Manfredi
 *
 */
public class BrokerThread extends Thread {
	/*La nuova socket, verso uno specifico subscriber, creata dalla ServerSocket*/
	private Socket socket;
	/* Abbiamo soltanto bisogno di recapitare il messaggio. 
	 * Il pattern non prevede la ricezione, da parte del publisher, di alcun messaggio (
	 * se non la richiesta di sottoscrizione che tuttavia viene catturata dalla accept nella ServerSocket)*/
	private PrintWriter out;
	private BufferedReader in;
	private int roomID;
	
	//Una coda che contiene i messaggi, specifici per ciascun subscriber
	private ConcurrentLinkedQueue<String> buffer;
	
	/**
	 * Quando un client esterno si sottoscrive viene creato un nuovo thread
	 * che rappresenterá la specifica connessione allo specifico client/subscriber. 
	 * @param socket La nuova socket, verso uno specifico subscriber, creata dalla ServerSocket
	 * @param arrayList 
	 */
	public BrokerThread(Socket socket, ArrayList<Room> arrayList) {
		this.socket = socket;
		buffer = new ConcurrentLinkedQueue<String>();
		
		try{
			this.out = new PrintWriter(socket.getOutputStream());
			this.in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String username = in.readLine();
			
			
			for(Room room: arrayList) {
		      ArrayList<Player> ap = room.getArrayList();
		      for (Player player: ap){
		    	  if (player.getPlayerName().equals(username)){
		    		  this.setRoomID(room.getID());
		    	  }
		      }
			}
			socket.shutdownInput();
			
		}catch(IOException e){}
	}
	
	/**
	 * Questo metodo contiene, di fatto, la logica della comunicazione dal publisher
	 * allo specifico subscriber. 
	 */
	@Override
	public void run() {
		while (true) {
			// Si prova ad estrarre un messaggio dalla coda...
			String msg = buffer.poll();
			// ... se c'é lo si invia
			if (msg != null)
				send(msg);
			else {
				// ... altrimenti, per evitare cicli inutili di CPU
				// che possono portare ad utilizzarla inutilmente...
				try {
					// ... si aspetta fin quando la coda non conterrá qualcosa
					// é necessario sincronizzarsi sull'oggetto monitorato, in
					// modo tale
					// che il thread corrente possieda il monitor sull'oggetto.
					synchronized (buffer) {
						buffer.wait();
					}
				} catch (InterruptedException e) {}
			}
		}
	}
	
	/**
	 * Questo metodo inserisce un messaggio nella coda
	 * e notifica ai thread in attesa (in questo caso a se stesso) la presenza di un messaggio.
	 * @param msg Il messaggio da inserire.
	 */
	public void dispatchMessage(String msg){
		
		
		buffer.add(msg);
		buffer.add("");

		//é necessario sincronizzarsi sull'oggetto monitorato
		synchronized(buffer){
			buffer.notify();
		}
	}
	
	public void dispatchBigMessage(String[] msg){

		for (String message : msg) {
			buffer.add(message);
			synchronized (buffer) {
				buffer.notify();
			}
		}
	}
	
	/**
	 * Questo metodo invia il messaggio al subscriber tramite la rete
	 * @param msg
	 */
	private void send(String msg){
		out.println(msg);
		out.flush();
	}
	
	public void close(){
		try {
			socket.close();
		} catch (IOException e) {
		} finally {
			out = null;
			socket = null;
			System.gc();
		}
	}


	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

}
