package it.polimi.ingsw.cg_10.controller.server;



import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;




import java.util.Observable;

import it.polimi.ingsw.cg_10.controller.rmi.RMIBroker;
import it.polimi.ingsw.cg_10.controller.rmi.Rserver;
import it.polimi.ingsw.cg_10.controller.socket.Broker;
import it.polimi.ingsw.cg_10.controller.socket.Server;
import it.polimi.ingsw.cg_10.model.com.*;
/**
 * @author Manfredi
 *
 */
public class ServerComunication extends Observable{

	
	private Server server;
	private ServerGameCentral sgc;
	private Rserver rs;
	private Broker brokerSK;
	private RMIBroker brokerRMI;
	public ServerComunication(ServerGameCentral sgc) {
	
		this.sgc = sgc;
		
	}

	public void getConnection()
	{		System.out.println("Creazione server socket");
			server = new Server(1337, this);
		    server.start();
		    
		    brokerSK=new Broker("1",sgc);	
		    brokerSK.start();
		    brokerRMI = new RMIBroker(sgc);
		    brokerRMI.startConnection();
		    
		    System.out.println("Server socket avviato");
		    System.out.println("Creazione server RMI");
		    try {
		    	
				rs= new Rserver(this);
				rs.start();
			} catch (RemoteException | AlreadyBoundException e) {
				
				throw new AssertionError("Errore #5: Errore RMI: "+ e);

			}
		    System.out.println("Server RMI e Socket avviato");
		    sgc.setCommunication(this);
	}
	
	public void publish(String testo, int i){
		System.out.println("Pubblicazione............");
		brokerSK.publish(testo, i);
		try {
			System.out.println("\n Provo a pubblicare in:"+Integer.toString(i)+"\nssa");
			brokerRMI.publish(testo, i);
		} catch (RemoteException e) {
			throw new AssertionError("Errore #6: Errore Publisher Subscribe RMI: "+ e);
		}
	}

	
	public ComAction setCommand (ComAction command){
		if(command instanceof ComUseCard || command instanceof ComDrawCard || command instanceof ComMove ||
			command instanceof ComAttack || command instanceof ComEndTurn || command instanceof ComNoise ){
			setChanged();
			notifyObservers(command);
			
			return new ComServerReply("",true);
		}
		return sgc.receivedMessage(command,this);
	
	}	
	
}
