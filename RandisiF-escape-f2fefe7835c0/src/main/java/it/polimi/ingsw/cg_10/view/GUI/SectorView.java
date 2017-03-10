/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.model.map.AlienSector;
import it.polimi.ingsw.cg_10.model.map.DangerousSector;
import it.polimi.ingsw.cg_10.model.map.EscapeHatchSector;
import it.polimi.ingsw.cg_10.model.map.HumanSector;
import it.polimi.ingsw.cg_10.model.map.Sector;
import it.polimi.ingsw.cg_10.model.map.SecureSector;
import it.polimi.ingsw.cg_10.model.map.VoidSector;


import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;



/**
 * @author Francesco
 *
 */
public class SectorView extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Point[] esagono = new Point[7];
	
	private Image image;
	private Color backGroundColor;
	private String coordinate = "";
	private Sector sector;
	private double latoSettore;
	private Polygon poli;
	
	/**
	 * @param latoSettore 
	 * 
	 */
	public SectorView (Point pos, Sector sector, double latoSettore) {
		this.setSector(sector);
		image = null;
		backGroundColor = Color.WHITE;
		this.latoSettore = latoSettore;
		if(!(sector instanceof VoidSector))
			coordinate = sector.getSectorID().toString().toUpperCase();
		calcolaVerticiEsagono(new Point (pos.x, pos.y));
		riempiEsagono (sector);
	}
	
	public Point[] calcolaVerticiEsagono(Point pos){
		
		esagono[0] = pos;
		esagono[1] = new Point((int)(esagono[0].getX()+latoSettore), (int)esagono[0].getY()); 
		esagono[2] = new Point((int)(esagono[0].getX()+(0.5*latoSettore)), (int)(esagono[0].getY()+(Math.sin(Math.PI/3)*latoSettore)));
		esagono[3] = new Point((int)(esagono[0].getX()-(0.5*latoSettore)), (int)(esagono[0].getY()+(Math.sin(Math.PI/3)*latoSettore)));
		esagono[4] = new Point((int)(esagono[0].getX()-latoSettore), (int)esagono[0].getY());
		esagono[5] = new Point((int)(esagono[0].getX()-(0.5*latoSettore)), (int)(esagono[0].getY()-(Math.sin(Math.PI/3)*latoSettore)));
		esagono[6] = new Point((int)(esagono[0].getX()+(0.5*latoSettore)), (int)(esagono[0].getY()-(Math.sin(Math.PI/3)*latoSettore)));
		return esagono;
	}
	
	private void riempiEsagono(Sector sector) {
		
		
		String URLimage = "";
		
		if(sector instanceof VoidSector){
			this.backGroundColor = Color.DARK_GRAY;
		}else if (sector instanceof SecureSector){
			this.backGroundColor = Color.WHITE;
		}else if (sector instanceof DangerousSector){
			this.backGroundColor = Color.GRAY;
		}else if (sector instanceof AlienSector){
			this.backGroundColor = Color.BLACK;
			URLimage = "./image/StartAlien.png";
		}else if (sector instanceof HumanSector){
			this.backGroundColor = Color.BLACK;
			URLimage = "./image/StartHuman.png";
		}else if (sector instanceof EscapeHatchSector){
			this.backGroundColor = Color.BLACK;
			
			if(!((EscapeHatchSector) sector).isOpen())
				this.setBackGroundColor(Color.RED);
			else{
				switch (((EscapeHatchSector) sector).getNum()) {
				case 1:
					URLimage = "./image/1.png";
				break;
					
				case 2:
					URLimage = "./image/2.png";
				break;
					
				case 3:
					URLimage = "./image/3.png";
				break;
					
				case 4:
					URLimage = "./image/4.png";
				break;
				}	
			}

		}
		
		if (!URLimage.equals("")){
			try {
				this.image=	ImageIO.read(new File(URLimage));
			} catch (IOException e) {
				System.out.println("Non sono riuscito a caricare l'immagine "+URLimage);
			}
		}
	}
	
	public void creaPolygon (){
		
		int[] coordx= { (int)getEsagono()[1].getX(),
				(int)getEsagono()[2].getX(),
				(int)getEsagono()[3].getX(),
				(int)getEsagono()[4].getX(),
				(int)getEsagono()[5].getX(),
				(int)getEsagono()[6].getX()
			  };

		int[] coordy= { (int)getEsagono()[1].getY(),
				(int)getEsagono()[2].getY(),
				(int)getEsagono()[3].getY(),
				(int)getEsagono()[4].getY(),
				(int)getEsagono()[5].getY(),
				(int)getEsagono()[6].getY()
			  };

		poli =new Polygon(coordx, coordy, 6); 
	}
	


	public Polygon getPoli() {
		return poli;
	}

	public void setPoli(Polygon poli) {
		this.poli = poli;
	}

	public Point[] getEsagono() {
		return esagono;
	}


	public void setEsagono(Point[] esagono) {
		this.esagono = esagono;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public Color getBackGroundColor() {
		return backGroundColor;
	}


	public void setBackGroundColor(Color backGroundColor) {
		this.backGroundColor = backGroundColor;
	}	

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
}
