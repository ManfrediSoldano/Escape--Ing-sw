package it.polimi.ingsw.cg_10.model.map;

public class HumanSector extends Sector {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HumanSector(Coordinate sectorID) {
		super(sectorID);
	}
	
	public HumanSector() {
	}

	@Override
	public String toString() {
		return "H"+ getSectorID().toString();
	}
	
}
