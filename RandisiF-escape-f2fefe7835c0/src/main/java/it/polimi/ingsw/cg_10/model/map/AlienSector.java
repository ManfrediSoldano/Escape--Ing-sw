package it.polimi.ingsw.cg_10.model.map;

public class AlienSector extends Sector {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlienSector(Coordinate sectorID) {
		super(sectorID);
	}
	
	public AlienSector() {
	}
	
	@Override
	public String toString() {
		return "A"+ getSectorID().toString();
	}
}
