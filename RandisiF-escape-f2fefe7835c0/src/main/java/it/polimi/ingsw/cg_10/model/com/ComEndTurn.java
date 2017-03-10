package it.polimi.ingsw.cg_10.model.com;

/**
 * @author Manfredi
 *
 */
public class ComEndTurn extends ComAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	


	/**Questa com serve per garantire la fine del turno all'utente
	 * @param username stirnga che rappresenta l'utente
	 */
	public ComEndTurn(String username) {
		
		super.setUsername(username);
	}

	
	public ComEndTurn() {

	}


	public String getUsername() {
		return super.getUsername();
	}

	public void setUsername(String username) {
		super.setUsername(username);
	}

}
