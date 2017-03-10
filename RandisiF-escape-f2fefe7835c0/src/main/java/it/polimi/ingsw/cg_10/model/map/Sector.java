package it.polimi.ingsw.cg_10.model.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Sector implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Coordinate sectorID;
	private final Map<SectorSide, Coordinate> confini;
	
	public Sector(Coordinate sectorID){
		this.sectorID = sectorID;
		this.confini = new HashMap<SectorSide, Coordinate>(6);
	}
	
	public Sector(){
		this.sectorID = new Coordinate();
		this.confini = new HashMap<SectorSide, Coordinate>(6);
	};
	
	public Coordinate getSectorID() {
		return sectorID;
	}
	
	public void setConfini (SectorSide sectorSide, Coordinate coordinate){
		this.confini.put(sectorSide, coordinate);
	}
	
	public ArrayList<Coordinate> getConfini(){
		return new ArrayList<Coordinate>(confini.values());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sector){
			if(	this.getSectorID().getCoordX() == ((Sector) obj).getSectorID().getCoordX() &&
				this.getSectorID().getCoordY() == ((Sector) obj).getSectorID().getCoordY())
					return true;
		}
		return false;
	}

	
}
