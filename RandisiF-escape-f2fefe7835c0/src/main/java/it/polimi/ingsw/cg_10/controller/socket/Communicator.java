package it.polimi.ingsw.cg_10.controller.socket;



/**
 * @author Manfredi
 *
 */
public interface Communicator {

	String receive();
	void close();

	void send(String command);
	
}
