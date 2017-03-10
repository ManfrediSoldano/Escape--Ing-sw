package it.polimi.ingsw.cg_10.model.map;

import java.io.Serializable;

public class Coordinate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int coordX;
	private int coordY;

	public Coordinate(int coordX, int coordY){
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Coordinate() {
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public int fromCoordToArrayIdx (){ 
		return ((coordY*25) + coordX);
	}
	
	@Override
	public String toString() {
		return ""+(char)(coordX+64)+String.format("%02d",coordY)+"";
	}

	public static Coordinate fromStringToCoordinate(String param) {
		param = param.toUpperCase();
		int x=param.charAt(0);
		int y=Character.getNumericValue(param.charAt(1))*10 + Character.getNumericValue(param.charAt(2));
		Coordinate coo = new Coordinate(x-64,y);
		return coo;
	}
}
