package it.polimi.ingsw.cg_10.model.com;



/**
 * @author Manfredi
 *
 */
public class ComServerReply extends ComAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reply;
	private Boolean conferma = true; 
	
	/**Risposta standard del server verso una richiesta pervenuta nel pattern Client/Server
	 * @param reply testo della risposta
	 * @param conferma booleano che rappresenta l'avvenuta risposta
	 */
	public ComServerReply(String reply, Boolean conferma){
		this.setReply(reply);
		this.setConferma(conferma);
		
		
	}
	

	public Boolean getConferma() {
		return conferma;
	}

	public void setConferma(Boolean conferma) {
		this.conferma = conferma;
	}


	public String getReply() {
		return reply;
	}


	public void setReply(String reply) {
		this.reply = reply;
	}



	

}
