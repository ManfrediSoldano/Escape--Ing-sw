package it.polimi.ingsw.cg_10.controller.rules;

import java.util.ArrayList;
import it.polimi.ingsw.cg_10.model.map.Coordinate;
import it.polimi.ingsw.cg_10.model.map.DangerousSector;
import it.polimi.ingsw.cg_10.model.map.EscapeHatchSector;
import it.polimi.ingsw.cg_10.model.map.Sector;
import it.polimi.ingsw.cg_10.model.map.SecureSector;
import it.polimi.ingsw.cg_10.model.map.Zone;
import it.polimi.ingsw.cg_10.model.player.Alien;
import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.Player;

public class Movement {

	private ArrayList<Coordinate> movementPossibiliCoord = new ArrayList<Coordinate>();
	private ArrayList<Sector> movementPossibiliSector = new ArrayList<Sector>();
	private Zone zone;
	
	public Movement (Zone zone){
		this.zone = zone;
	}
	
	public void movePlayer (Player player, Sector endSector, Zone zone){

			

	}
	


	public void checkMovementPossibili(Player player){
		Sector actualSector = player.getMovementRec().getLastPlayerRecord().getPosition(); 	//muovi 1 livello
		Sector sectorToCheck = actualSector;
		movementPossibiliCoord.clear(); //per sicurezza
		addPossibiliCoord(sectorToCheck);
		movementFromCoordToSector();
		escludiSettoriNonCompatibili(player);
		
		if ((player instanceof Alien) || (player instanceof Human && ((Human)player).isAdrenaline())){
			for (int i=0; i<movementPossibiliSector.size();i++){				
				sectorToCheck = movementPossibiliSector.get(i);								//muovi 2 livello
				addPossibiliCoord(sectorToCheck);
			}
			movementPossibiliCoord.remove(actualSector.getSectorID());
			movementFromCoordToSector();
			escludiSettoriNonCompatibili(player);
			
			if (player instanceof Alien){
				if(((Alien) player).getKillHuman()){
					for (int i=0; i<movementPossibiliSector.size();i++){				
						sectorToCheck = movementPossibiliSector.get(i);								//muovi 3 livello
						addPossibiliCoord(sectorToCheck);
					}
					movementPossibiliCoord.remove(actualSector.getSectorID());
					movementFromCoordToSector();
					escludiSettoriNonCompatibili(player);
				}
			}
		}
	}
	
	public ArrayList<Sector> getMovementPossibiliSector() {
		return movementPossibiliSector;
	}

	public void dovePossoSpostarmi (Player player, Zone zone){
		Movement movement = new Movement(zone);
		movement.checkMovementPossibili(player);
		System.out.println("Puoi spostarti in" + movementPossibiliSector.toString());

	}
	
	private void escludiSettoriNonCompatibili(Player player) {
		for (int i=0; i<movementPossibiliSector.size();i++){
			Sector sector = movementPossibiliSector.get(i);
			
			if (!(sector instanceof SecureSector || sector instanceof DangerousSector) || (sector instanceof EscapeHatchSector && !(player instanceof Human)))
				movementPossibiliSector.remove(sector);	
			
		}
	}

	public void movementFromCoordToSector(){
		for(int idx =0; idx < movementPossibiliCoord.size(); idx++){
			Sector sector = zone.getSectors().get((movementPossibiliCoord.get(idx).fromCoordToArrayIdx()));		//per evitare di ciclare sull'array, funziona solo se le righe del tabellone sono 25
			if(!movementPossibiliSector.contains(sector))
				movementPossibiliSector.add(sector);	
		}
		movementPossibiliCoord.clear();
	}
	
	public void addPossibiliCoord (Sector sector){
		for(int j=0;j<sector.getConfini().size();j++){
			if (!movementPossibiliCoord.contains(sector.getConfini().get(j)))
				movementPossibiliCoord.add(sector.getConfini().get(j));   
		}
	}
}
