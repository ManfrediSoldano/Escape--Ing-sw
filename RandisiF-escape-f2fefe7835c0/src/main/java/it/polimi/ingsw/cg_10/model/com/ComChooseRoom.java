package it.polimi.ingsw.cg_10.model.com;



/**
 * @author Manfredi
 *
 */
public class ComChooseRoom extends ComAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int room;
	//private String username;
	private Boolean newRoom = false;
	private Boolean advancedGame=false;
	private String mappa = "";
	
	/**Com per la scelt della stanza
	 * @param room intero che identificca la stanza
	 * @param username stringa che identifica l'utente
	 */
	public ComChooseRoom(int room, String username){
	super.setUsername(username);
	this.setRoom(room);
		
	}
	
	/**Com per la scelt della stanza
	 * @param room int che identifica la stanza
	 * @param username stringa che identifica l'utente
	 * @param newRoom Boolena che identifica la richiesta di una nuova stanza /#non più utilizzato#/
	 * @param advancedgame Richiesta di un game avanzato	
	 * @param mappa Stringa della mappa
	 */
	public ComChooseRoom(int room, String username, Boolean newRoom, Boolean advancedgame, String mappa){
		super.setUsername(username);
		this.setRoom(room);
		this.newRoom=newRoom;
		this.setAdvancedGame(advancedgame);
		this.setMappa(mappa);
			
		}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getUsername() {
		return super.getUsername();
	}
	public void setUsername(String username) {
		
		super.setUsername(username);
	}
	public Boolean getNewRoom() {
		return newRoom;
	}
	public void setNewRoom(Boolean newRoom) {
		this.newRoom = newRoom;
	}
	public Boolean getAdvancedGame() {
		return advancedGame;
	}
	public void setAdvancedGame(Boolean advancedGame) {
		this.advancedGame = advancedGame;
	}
	public String getMappa() {
		return mappa;
	}
	public void setMappa(String mappa) {
		this.mappa = mappa;
	}
	

	

}
