package it.polimi.ingsw.cg_10.controller.logic;

import java.util.ArrayList;

import it.polimi.ingsw.cg_10.model.map.AlienSector;
import it.polimi.ingsw.cg_10.model.map.Coordinate;
import it.polimi.ingsw.cg_10.model.map.DangerousSector;
import it.polimi.ingsw.cg_10.model.map.EscapeHatchSector;
import it.polimi.ingsw.cg_10.model.map.HumanSector;
import it.polimi.ingsw.cg_10.model.map.Sector;
import it.polimi.ingsw.cg_10.model.map.SectorSide;
import it.polimi.ingsw.cg_10.model.map.SecureSector;
import it.polimi.ingsw.cg_10.model.map.VoidSector;
import it.polimi.ingsw.cg_10.model.map.Zone;

public class ZoneCreator {

	public Zone zoneCreator(String name){
		Zone zone = new Zone(name);
		if(name.equals("Galilei") || name.equals("galileo") || name.equals("gal") ){
			name="galilei";
		}
		ZoneFileReader zonefr = new ZoneFileReader(name+".txt");
		zonefr.loadMapFile();
		ArrayList<String> zoneString = new ArrayList<String>();
		zoneString.addAll(zonefr.getFileStrings());
		char c=0;
		
		for(int y=0; y < zoneString.size(); y++){
			for (int x=0; x < zoneString.get(y).length(); x++){
				c = zoneString.get(y).charAt(x);
				switch (c){
					case '0':
						VoidSector vs =new VoidSector(new Coordinate(x, y));						
						setConfiniSector(vs, x, y);					
						zone.addSector(vs);
						
					break;
					
					case '1':		
						SecureSector ss =new SecureSector(new Coordinate(x, y));
						setConfiniSector(ss, x, y);
						zone.addSector(ss);
					break;
					
					case '2':
						DangerousSector ds =new DangerousSector(new Coordinate(x, y));
						setConfiniSector(ds, x, y);
						zone.addSector(ds);
					break;
					
					case '3':
						HumanSector hs =new HumanSector(new Coordinate(x, y));
						setConfiniSector(hs, x, y);
						zone.addSector(hs);
					break;
					
					case '4':
						AlienSector as =new AlienSector(new Coordinate(x, y));
						setConfiniSector(as, x, y);
						zone.addSector(as);
					break;
					
					case '5':
						EscapeHatchSector ehs1 =new EscapeHatchSector(new Coordinate(x, y),1);
						setConfiniSector(ehs1, x, y);
						zone.addSector(ehs1);
					break;
					
					case '6':
						EscapeHatchSector ehs2 =new EscapeHatchSector(new Coordinate(x, y),2);
						setConfiniSector(ehs2, x, y);
						zone.addSector(ehs2);
					break;
					
					case '7':
						EscapeHatchSector ehs3 =new EscapeHatchSector(new Coordinate(x, y),3);
						setConfiniSector(ehs3, x, y);
						zone.addSector(ehs3);
					break;
					
					case '8':
						EscapeHatchSector ehs4 =new EscapeHatchSector(new Coordinate(x, y),4);
						setConfiniSector(ehs4, x, y);
						zone.addSector(ehs4);
					break;
				}
			}
		}	
		return zone;
	}
	
	
	public void setConfiniSector (Sector s , int x, int y){
 
			if(y>0)
				s.setConfini(SectorSide.NORD, new Coordinate(x, y-1));
			else
				s.setConfini(SectorSide.NORD, null);
			
			s.setConfini(SectorSide.SUD, new Coordinate(x, y+1));
			
			if(x%2 == 0)	//se x pari sfaso la y di 1 poiche` sono esagonali
				y+=1;
			
		 	if(y>0){
				s.setConfini(SectorSide.NORDEST, new Coordinate(x+1, y-1));	
		 	}
		 	else{
				s.setConfini(SectorSide.NORDEST, null);		
		 	}
		 	
			s.setConfini(SectorSide.SUDEST, new Coordinate(x+1, y));
			
			if(x>0)
				s.setConfini(SectorSide.SUDOVEST, new Coordinate(x-1, y));
			else
				s.setConfini(SectorSide.SUDOVEST, null);

			if(x>0 && y>0)
				s.setConfini(SectorSide.NORDOVEST, new Coordinate(x-1, y-1));
			else
				s.setConfini(SectorSide.NORDOVEST, null);
	 
	}
	

}
