package it.polimi.ingsw.cg_10.model.com;

import it.polimi.ingsw.cg_10.model.map.Coordinate;



/**
 * @author Manfredi
 *
 */
public class ComMove extends ComAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Coordinate coordinate;
	private Integer x;
	private Integer y;
	private String xy;
	
	/**Questa com serve per l'azione movimento
	 * @param coordinate cooridnata di destinazione
	 * @param username stringa che rappresenta l'utente
	 */
	public ComMove(Coordinate coordinate, String username){
	this.setCoordinate(coordinate);
	super.setUsername(username);
	}
	public ComMove(Coordinate coordinate) {
		this.coordinate=coordinate;
		setX(coordinate.getCoordX());
		setY(coordinate.getCoordY());
		setXy(x+"//"+y);
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public String getUsername() {
		return super.getUsername();
	}
	public void setUsername(String username) {
		super.setUsername(username);
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public String getXy() {
		return xy;
	}
	public void setXy(String xy) {
		this.xy = xy;
	}
	

	

}
