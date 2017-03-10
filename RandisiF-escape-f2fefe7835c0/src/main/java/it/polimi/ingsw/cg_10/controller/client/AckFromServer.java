/**
 * 
 */
package it.polimi.ingsw.cg_10.controller.client;

/**
 * @author Francesco
 *
 */
public class AckFromServer {

	private boolean error;
	private boolean stat;
	private String message= "";
	
	
	public  AckFromServer(boolean error, boolean stat, String message) {
		this.error=error;
		this.stat=stat;
		this.message=message;
	}
	
	public boolean isError() {
		return error;
	}
	
	public String getMessage() {
		return message;
	}	
	
	public boolean isStat() {
		return stat;
	}
}
