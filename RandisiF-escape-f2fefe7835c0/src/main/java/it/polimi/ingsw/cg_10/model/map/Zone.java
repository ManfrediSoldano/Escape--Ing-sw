package it.polimi.ingsw.cg_10.model.map;

import java.io.Serializable;
import java.util.ArrayList;

public class Zone implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ArrayList<Sector> sectors;
	private String name;

	public Zone (String name){
		this.sectors = new ArrayList<Sector>();
		this.name = name;
	}
	
	public void addSector(Sector settore){
		this.sectors.add(settore);
	}
	
	public ArrayList<Sector> getSectors (){
		return this.sectors;
	}
	
	public String getName(){
		return name;
	}

	//ritorna tutti i settori di un tipo specifico all'interno della zone
	public ArrayList<Sector> getSpecificSector ( Sector sector){
		ArrayList<Sector> secToReturned= new ArrayList<Sector>();
		if(sector instanceof HumanSector){
			for(int i=0; i< sectors.size(); i++)
				if(sectors.get(i) instanceof HumanSector)
					secToReturned.add(sectors.get(i));
			
		}else if(sector instanceof AlienSector){
			for(int i=0; i< sectors.size(); i++)
				if(sectors.get(i) instanceof AlienSector)
					secToReturned.add(sectors.get(i));
			
		}else if(sector instanceof EscapeHatchSector){
			for(int i=0; i< sectors.size(); i++)
				if(sectors.get(i) instanceof EscapeHatchSector)
					secToReturned.add(sectors.get(i));
		}
			
		return secToReturned;
	}
	
	@Override
	public String toString() {

		try{
			return name.toString().toUpperCase()+": \n" + 
				sectors.subList(0, 25) + "\n\r" + sectors.subList(25, 50) + "\n\r" + sectors.subList(50, 75) + "\n\r" + sectors.subList(75, 100) + "\n\r" +
	            sectors.subList(100, 125) + "\n\r" + sectors.subList(125, 150) + "\n\r" + sectors.subList(150, 175) + "\n\r" + sectors.subList(175, 200) + "\n\r" +
	            sectors.subList(200, 225) + "\n\r" + sectors.subList(225, 250) + "\n\r" + sectors.subList(250, 275) + "\n\r" + sectors.subList(275, 300) + "\n\r" +
	            sectors.subList(300, 325) + "\n\r" + sectors.subList(325, 350) + "\n\r" + sectors.subList(350, 375) + "\n\r" + sectors.subList(375, 400) ;
		}catch(IndexOutOfBoundsException e){
			return "Error: Mappa vuota";
		}

	}

	

}
