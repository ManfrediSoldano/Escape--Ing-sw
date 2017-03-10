package it.polimi.ingsw.cg_10.controller.client;

import java.util.Scanner;



import it.polimi.ingsw.cg_10.model.com.*;

public class StartGame_test {
	private static ComAction comaction;
	private static Communication communication;
	private static Scanner stdin;
	private static boolean token = true;
	private static ComAction response;
	private static String username="";

	public static void main(String[] args) {
		stdin = new Scanner(System.in);
		connect();
		
		comaction = new ComAction();
		
		
		askusername();	
		token = true;
		while(token){
				print("Se esiste una partita non ancora avviata verrai inserito nella partita altrimenti verrà creata una partita con le tue richieste.");
				
				boolean advance;
				if (askUser("Advanced game? (s o lascia vuoto)").equals("s"))	
					advance = true;
				else advance = false;
				comaction = new ComChooseRoom(0, username, true,advance,"galilei");
				response = send();
				
				if(((ComServerReply) response).getConferma()){
					print(((ComServerReply) response).getReply());
					communication.subscribe(username);
					token =false;
				}
				else{
					print(((ComServerReply)response).getReply());
					token =true;
				}
	
			
		}
		
	
		
		while(true){
			String chat= askUser("Scrivi qualcosa da mandare in chat");
			if(chat.equals("chiudi")){
				System.out.println("Chiusura connessione");
				communication.close();
			}
			ComChat asd= new ComChat(chat, username);
			ComAction as= communication.sendMessage(asd);
			if(as!=null){
				
				if(((ComServerReply) as).getConferma()){
				print(((ComServerReply) response).getReply());
			
			}
			else{
				print(((ComServerReply)as).getReply());
			}
			}else{
				print("Ma che cazzo");
			}
			
		}
			

	}

	private static void askusername() {
		
		token=true;
		print("Connesso");
		while (token) {
			username = askUser("Scrivi il tuo username per iniziare:");

			comaction = new ComFirstConnection(username);
			
			response = send();
		
			if (response instanceof ComServerReply) {
				
				if(((ComServerReply) response).getConferma()){
					print("Benvenuto "+ username+ "!" );
					//print(((ComServerReply) response).getReply());
					token = false;
				}
				else if(!((ComServerReply) response).getConferma()){
					print(((ComServerReply) response).getReply());
					token = true;
				}
			} else {
				throw new AssertionError("Errore");
			}
			
			
			
			
			
			
			
			

		}
		
	}

	private static void connect() {
		print("Benvenuto!");
		
		//while (token) {
			//String risposta = askUser("Scegli la connessione: Socket o RMI?");
			//if(risposta.equals("Socket") || risposta.equals("SOCKET") || risposta.equals("socket")){
			//	token=false;
			communication = new Communication("Socket");
			//}
			//else if(risposta.equals("RMI") || risposta.equals("rmi") || risposta.equals("Rmi")){
			//	token=false;
		 //  communication = new Communication("RMI");
			//}
			//else{
			//	print("Attenzione hai inserito un tipo di connessione non valida. Riprova.");
			//}
	//}
		
		print("Connessione in corso.");
		communication.getConnection();
		
	}

	public static void print(String testo) {
		System.out.println(testo);

	}

	public static String askUser(String richiesta) {
		print(richiesta);
		String risposta = stdin.nextLine();
		return risposta;
	}

	private static ComAction send() {
		// print(comaction.serialize());
		return communication.sendMessage(comaction);

	}



}