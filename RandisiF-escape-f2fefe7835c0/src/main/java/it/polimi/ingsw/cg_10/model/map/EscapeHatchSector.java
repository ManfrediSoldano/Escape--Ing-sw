package it.polimi.ingsw.cg_10.model.map;

public class EscapeHatchSector extends Sector {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean open;
	private int num;

	public EscapeHatchSector(Coordinate sectorID, int num) {
		super(sectorID);
		open = true;
		this.num = num;
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "E"+ getSectorID().toString();
	}
}
