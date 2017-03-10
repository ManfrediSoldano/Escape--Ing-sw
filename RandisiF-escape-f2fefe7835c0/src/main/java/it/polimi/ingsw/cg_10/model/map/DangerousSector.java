package it.polimi.ingsw.cg_10.model.map;

public class DangerousSector extends Sector {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DangerousSector(Coordinate sectorID) {
		super(sectorID);
	}

	@Override
	public String toString() {
		return "D"+ getSectorID().toString();
	}
	
}
