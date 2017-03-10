package it.polimi.ingsw.cg_10.model.com;



/**
 * @author Manfredi
 *
 */
public class ComFirstConnection extends ComAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String user;
	
	/**Questa com serve per garantire la prmia connessione per l'utente
	 * @param user stringa che rappresenta l'utente
	 * 
	 */
	public ComFirstConnection(String user){
		super.setUsername(user);
		
		
	}
	
	public String getUser(){
		return super.getUsername();
		
	}
	

}
