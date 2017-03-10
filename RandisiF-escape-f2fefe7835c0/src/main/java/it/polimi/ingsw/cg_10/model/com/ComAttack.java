package it.polimi.ingsw.cg_10.model.com;

import it.polimi.ingsw.cg_10.model.map.Coordinate;



/**
 * @author Manfredi
 *
 */
/**
 * @author Manfredi
 *
 */
public class ComAttack extends ComAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Coordinate coordinata;
	
	/** Com per l'attacco
	 * @param coordinata setta la coordinata
	 * @param Username passa l'username alla superclasse
	 */
	public ComAttack(Coordinate coordinata, String Username){
		this.coordinata=coordinata;
		super.setUsername(Username);
	}
	

	/**
	 * @param genera un nuoco comnattack
	 */
	public ComAttack(Coordinate coordinata) {
		this.coordinata=coordinata;
	}


	/**
	 * @return ritorna la coordinata
	 */
	public Coordinate getCoordinata() {
		return coordinata;
	}


	/**
	 * @param setta la coordinata
	 */
	public void setCoordinata(Coordinate coordinata) {
		this.coordinata = coordinata;
	}


	public String getUsername() {
		return super.getUsername();
	}


	public void setUsername(String username) {
		super.setUsername(username);
	}
	

}
