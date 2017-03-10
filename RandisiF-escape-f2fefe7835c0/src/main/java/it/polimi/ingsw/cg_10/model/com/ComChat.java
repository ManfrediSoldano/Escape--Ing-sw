package it.polimi.ingsw.cg_10.model.com;

/**
 * @author Manfredi
 *
 */
public class ComChat extends ComAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String testo;
	//private String username;

	/**Com per la chat
	 * @param testo testo da poi pubblicare nella chat
	 * @param username stringa che identifica un utente
	 */
	public ComChat(String testo, String username) {
		this.setTesto(testo);
		super.setUsername(username);
	}
	
	/**
	 * @param testo da pubblicare
	 */
	public ComChat(String testo) {
		this.setTesto(testo);
	}

	/**
	 * @return ritorna il testo da pubblicare
	 */
	public String getTesto() {
		return testo;
	}

	/**
	 * @param testo setta il testo
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getUsername() {
		//System.out.println(super.getUsername());
		return super.getUsername();
	}

	public void setUsername(String username) {
		super.setUsername( username);
	}

}
