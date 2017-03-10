package it.polimi.ingsw.cg_10.controller.socket;


import it.polimi.ingsw.cg_10.controller.server.ServerGameCentral;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * @author Manfredi
 *
 */
public class Broker extends Thread {
	private final int portNumber = 1200;

	private boolean listening = true;
	private ArrayList<BrokerThread> subscribers = new ArrayList<BrokerThread>();
	private String topic;
	private ServerGameCentral sgc;
	
	public Broker(String topic, ServerGameCentral sgc){
		this.setTopic(topic);
		this.sgc = sgc;
	
		
	}
	
	
	
	/**
	 * 1)
	 * Vogliamo creare un servizio Broker che rimanga in ascolto per eventuali sottoscrizioni.
	 * Quindi creaiamo una ServerSocket e, per accettare sottoscrizioni multiple, creiamo un loop.
	 * 	Quindi ci mettiamo in attesa che un client esterno si sottoscriva (brokerSocket.accept, 
	 * 	The method blocks until a connection is made. A new Socket is created); 
	 * 	quando ció avviene viene creato un nuovo thread, brokerThread, che rappresenterá la specifica connessione
	 *  allo specifico client/subscriber. 
	 *  Il brokerThread viene avviato e salvato nella lista che raggruppa i subscribers.
	 *  Quindi la ServerSocket torna in ascolto di altre connessioni.
	 */
	@Override
	public void run() {
		try(ServerSocket brokerSocket = new ServerSocket(portNumber)){
			while(listening){
			
				BrokerThread brokerThread = new BrokerThread(brokerSocket.accept(),sgc.getRm());
				//System.out.println("richiesta iscrizione");
				
				brokerThread.start();
					
				subscribers.add(brokerThread);

			}
		}catch(IOException e){
			System.err.println("Cannot listen on port: "+portNumber);
			System.exit(-1);
		}
	}
	

	/**
	 * 2)
	 * Questo metodo manda un messaggio a tutti i subscriber presenti nella lista.
	 * Di fatto la publish si riduce ad iterare sulla lista subscriber ed a chiamare
	 * un metodo interno a ciascun subscriber, il quale a sua volta gestirá l'invio del messaggio.
	 * @param msg Il messaggio da mandare.
	 */
	public void publish(String msg, int roomID) {
	
		msg = "START##" + msg + "##END##";
		if(msg.contains("\n")){
			msg = converter(msg);
		}

		if (!subscribers.isEmpty()) {
			//System.out.println(msg);

			for (BrokerThread sub : subscribers) {
			//	System.out.println(Integer.toString(sub.getRoomID()));
				if (sub.getRoomID() == roomID) {

							sub.dispatchMessage(msg);


				}
			}
			
		} else {
			System.err.println("No subscribers!");
		}
	}



	private String converter(String msg) {
		String temp="";
		String temp2="";
		boolean first=true;
		String[] parts = msg.split("\n");
		for(String part:parts){
			if(first){
				temp=part;
				first=false;
			}
			else{
				temp=temp+ "##CAPO##" + part;
			}
		}
		first=true;
		String[] parts2 = temp.split("\r");
		for(String part:parts2){
			if(first){
				temp2=part;
				first=false;
			}
			else{
				temp2=temp2+ "##R##" + part;
			}
		}
		
		return temp2;
	}



	public String getTopic() {
		return topic;
	}



	public void setTopic(String topic) {
		this.topic = topic;
	}
}
