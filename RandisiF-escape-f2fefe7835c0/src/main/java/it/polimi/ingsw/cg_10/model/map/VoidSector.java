package it.polimi.ingsw.cg_10.model.map;

public class VoidSector extends Sector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VoidSector(Coordinate sectorID) {
		super(sectorID);
	}
	
	@Override
	public String toString() {
		return "V"+ getSectorID().toString();
	}

}
