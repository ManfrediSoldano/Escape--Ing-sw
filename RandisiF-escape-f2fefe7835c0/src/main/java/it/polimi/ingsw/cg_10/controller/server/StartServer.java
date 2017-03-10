package it.polimi.ingsw.cg_10.controller.server;







/**
 * @author Manfredi
 *
 */
public class StartServer {

private static ServerComunication sercommunication;
private static ServerGameCentral sgc;


	public static void main(String[] args) {
		sgc = new ServerGameCentral();
		//Avvio del server in corso
		sercommunication = new ServerComunication (sgc);
		sercommunication.getConnection();
		
		
	}
	
	
	
	
	
	
	
	
}
