
package it.polimi.ingsw.cg_10.model.com;

import it.polimi.ingsw.cg_10.model.map.Coordinate;
import it.polimi.ingsw.cg_10.model.map.Sector;


public class ComNoise extends ComAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Coordinate coordinata;
	private Sector sector;
	
	/**Com che per generare un rumore richiesto in un settore
	 * @param coordinata del settore dove è richiesto il rumore
	 * @param Username stringa che rappresenta il richiedente
	 */
	public ComNoise(Coordinate coordinata, String Username){
		this.coordinata=coordinata;
		super.setUsername(Username);
	}
	
	public ComNoise(Sector sector, String Username){
		this.sector=sector;
		this.coordinata = sector.getSectorID();
		super.setUsername(Username);
	}
	

	public ComNoise(Coordinate coordinata) {
		this.coordinata=coordinata;
	}

	public ComNoise(Sector sector){
		this.sector=sector;
		this.coordinata = sector.getSectorID();
	}

	public Coordinate getCoordinata() {
		return coordinata;
	}


	public void setCoordinata(Coordinate coordinata) {
		this.coordinata = coordinata;
	}


	public String getUsername() {
		return super.getUsername();
	}


	public void setUsername(String username) {
		super.setUsername(username);
	}


	public Sector getSector() {
		return sector;
	}


	public void setSector(Sector sector) {
		this.sector = sector;
	}
	

}


