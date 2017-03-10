package it.polimi.ingsw.cg_10.model.map;

public class SecureSector extends Sector {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SecureSector(Coordinate sectorID) {
		super(sectorID);
		
	}
	
	@Override
	public String toString() {
		return "S"+ getSectorID().toString();
	}
}
