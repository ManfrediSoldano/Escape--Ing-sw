package it.polimi.ingsw.cg_10.controller.socket;

import it.polimi.ingsw.cg_10.controller.client.Communication;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Manfredi
 *
 */
public class SubscriberThread extends Thread {
	private Socket subSocket;
	private BufferedReader in;
	private final String address = "localhost";
	private final int port = 1200;
	private PrintWriter out;
	private String username;
	private Communication communication;
	private boolean complete=false;
	private String totalmex="";
	
	/**
	 * Non appena il thread viene instanziato, ci si sottoscrive al broker.
	 * NB. Non é stato implementato il concetto di topic; questo viene lasciato come 
	 * compito agli studenti.
	 * @param communication 
	 * @param string L'id assegnato manualmente al thread.
	 */
	public SubscriberThread(String username, Communication communication){
		try {
			this.username=username;
			this.communication = communication;
			subscribe();
			
		} catch (IOException e) {}
	}
	
	public SubscriberThread(String username){
		
		try {
			this.username=username;
			subscribe();
			
		} catch (IOException e) {}
	}
	
	/**
	 * Dopo aver effettuato la sottoscrizione, questo metodo
	 * rimane in ascolto di messaggi da parte del publisher.
	 */
	@Override
	public void run() {

		while (true) {
		
				receive();
				if(complete){

				
				communication.receivedFromPublisher(totalmex);
				complete=false;
				totalmex="";

				}
				
			try {
				// aspetta 5ms per ridurre i cicli di clock
				// soprattutto nel caso in cui il publisher vada in crash
				Thread.sleep(5);
			} catch (InterruptedException e) {}

		}
	}

	/**
	 * Metodo che riceve eventuali messaggi di testo dal publisher
	 * @return
	 */
	private String receive() {

	try {
			String received=in.readLine();
			if(received.contains("##CAPO##")){
				System.out.println("Converitito");
				received = converti(received);
			}
			
			
			if (received.contains("START##")&& !received.contains("##END##")) {
				String[] parts = received.split("START##");
				String part2 = parts[1]; 
				totalmex=part2;
				System.out.println("Inizio");
				
			} else if (!received.contains("START##")&& received.contains("##END##")) {
					String[] parts = received.split("##END##");
					String part0 = parts[0]; 
					totalmex=totalmex+part0;
			System.out.println("Fine");
					complete=true;
					
			}else if(received.contains("START##")&& received.contains("##END##")){
				String[] parts = received.split("START##");
				String[] parts2 = parts[1].split("##END##");
				String part0 = parts2[0]; 
				totalmex=totalmex+part0;
				System.out.println("Solo una riga");
				complete=true;
			} 	
			else if(!received.equals("")&& received!=""){
				
				totalmex=totalmex+received;
			}
			else{
				System.out.println("ERRORE DI CONNESSIONE");
			}
			
			return in.readLine();
		
		} catch (IOException e) {
		
			return null;
		}
	}
	
	private String converti(String received) {
		String temp="";
		String temp2="";
		boolean first=true;
		String[] parts = received.split("##CAPO##");
		for(String part:parts){
			if(first){
				temp=part;
				first=false;
			}
			else{
				temp=temp+ "\n" + part;
			}
		}
		
		first= true;
		String[] parts2 = temp.split("##R##");
		
		for(String part:parts2){
			if(first){
				temp2=part;
				first=false;
			}
			else{
				temp2=temp2+ "\r" + part;
			}
		}
		return temp2;
	}

	/**
	 * Effettua la sottoscrizione al solo ed unico topic, 
	 * i.e., crea la socket verso il subscriber e apre uno stream in ingresso per ricevere
	 * i messaggi del publisher.
	 * NB. Non é necessario creare uno stream in uscita, in ottemperanza al pattern.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private void subscribe() throws UnknownHostException, IOException{
		subSocket = new Socket(address, port);
		
	    in = new BufferedReader(
	        new InputStreamReader(subSocket.getInputStream()));
	    
	  out = new PrintWriter(subSocket.getOutputStream());
	  		out.println(username);
	  		out.flush(); 
	  		subSocket.shutdownOutput();
	  		
	}
	
	public void close() {
		try {
			subSocket.close();
		} catch (Exception e) {
		} finally {
			in = null;
			subSocket = null;
			System.gc();
		}

	}
}
