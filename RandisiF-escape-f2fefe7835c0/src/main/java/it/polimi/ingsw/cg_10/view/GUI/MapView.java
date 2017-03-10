/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.controller.client.ClientMain;
import it.polimi.ingsw.cg_10.model.com.ComMove;
import it.polimi.ingsw.cg_10.model.com.ComNoise;
import it.polimi.ingsw.cg_10.model.map.Sector;
import it.polimi.ingsw.cg_10.model.player.Alien;
import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Francesco
 *
 */
public class MapView extends JPanel {

	/**
	 * 
	 */
	
	private int nSettHor; 
	private int nSettVer; 
	private double resizePropVer;
	private double resizePropHor;
	private Point[] centroSettori;
	private double latoSettore=0;
	private static SectorView [] sectorViews;
	private static boolean clickable = false;
	private static boolean moving= false;
	private static boolean selNoise= false;
	private static boolean reqLight = false;
	private JPanel p;


	private static final long serialVersionUID = 1L;

	public MapView (int x, int y, int altezza, int nSettVer, int nSettHor){
		super();
		this.nSettHor = nSettHor;
		this.nSettVer = nSettVer;
		this.centroSettori = new Point[nSettHor*nSettVer];
		sectorViews = new SectorView[nSettHor*nSettVer];
		ridimensiona(altezza);
		this.setBackground(Color.CYAN);
		
		this.addMouseListener(new MouseListener() {
			

			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(clickable){
					if(moving){
						Sector sector = fromPointToSector(e.getPoint());
						ClientMain.ackSend(new ComMove(sector.getSectorID()));
						setMoving(false);
					}
					if(selNoise){
						Sector sector = fromPointToSector(e.getPoint());
						ClientMain.ackSend(new ComNoise(sector));
						setSelNoise(false);
					}
					if(reqLight){
						Sector sector = fromPointToSector(e.getPoint());
						ClientMain.ackSend(new ComNoise(sector));
						setReqLight(false);
					}
					clickable = false;
				}	
			}	
		});	
	}
	
	public void calcolaLayoutSettori(){
		
		int pointIndex = 0;

		for(int i=1; i<=nSettVer;i++){
			for(int j=1; j<=nSettHor;j++, pointIndex++){
				if(j%2 == 0)
					centroSettori[pointIndex] = new Point((int)((resizePropHor*j)-(resizePropHor*0.5)),(int)((resizePropVer*i*2)-(resizePropVer*2))); 		//risoluzione terza cifra decimale
				else
					centroSettori[pointIndex] = new Point((int)((resizePropHor*j)-(resizePropHor*0.5)),(int)((resizePropVer*(0.5+i)*2)-(resizePropVer*2)));
			}
		}
		
	}

	public void ridimensiona(int altezza){
		resizePropVer= altezza/(nSettVer*2);
		resizePropHor= resizePropVer*Math.tan(Math.PI/3);
		this.setBounds(this.getLocation().x, this.getLocation().y, 0, altezza);
		
		latoSettore = resizePropVer/Math.sin(Math.PI/3); 
		calcolaLayoutSettori();
	}
	@Override
	public void setBounds (int x, int y, int larghezza, int altezza){
		int larg = (int) (this.resizePropHor*this.nSettHor);
		super.setBounds(x, y, larg, altezza);
		
	}
	

	
	public void drawSector (final SectorView[] secViews) {
		
		final Dimension dimension = this.getSize();
		p = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {   
                super.paint(g);
                setBackground(Color.DARK_GRAY);
                for (int i = 0; i<secViews.length;i++) {
                    g.setColor(secViews[i].getBackGroundColor());
                    g.fillPolygon(secViews[i].getPoli());
                    g.setColor(Color.DARK_GRAY);
                    g.drawPolygon(secViews[i].getPoli());
                    
                    if(secViews[i].getImage() != null)
            			g.drawImage(secViews[i].getImage(), (int)secViews[i].getEsagono()[0].x-20, (int)secViews[i].getEsagono()[0].y-20,40,40, null);
            		else{
            			if(secViews[i].getBackGroundColor() == Color.RED)
            				g.setColor(Color.RED);
            			else if(secViews[i].getBackGroundColor() == Color.WHITE)
            				g.setColor(Color.BLUE);
            			else
            				g.setColor(Color.CYAN);
            			g.drawString(secViews[i].getCoordinate(), (int)secViews[i].getEsagono()[0].x-10, (int)secViews[i].getEsagono()[0].y+5);   
            		}
				}

            }
			
			@Override
			public Dimension getPreferredSize() { 
				return dimension;
			}
			
			@Override
			public Point getLocation() { 
				return new Point(0,0);
			}
        };
        this.add(p);
        this.setVisible(true);

	}
	
	public Point[] getCentroSettori() {
		return centroSettori;
	}

	public void updateMap(ArrayList<Sector> sectors){

		int index = 0;
		for (Sector sector : sectors) {
			sectorViews [index] = new SectorView(centroSettori[index], sector, latoSettore);
			sectorViews [index].creaPolygon();	
			index++;
		}
		drawSector(sectorViews);
	}
	public void updatePlayerPosition(Player player){
		String imageUrl = "";
		for (int i=0; i<sectorViews.length;i++)
			if(sectorViews[i].getSector().equals(player.getMovementRec().getLastPlayerRecord().getPosition())){
				SectorView sec=sectorViews[i];
				if(player instanceof Alien)
					imageUrl = "./image/alPos.png";
				else if(player instanceof Human)
					imageUrl = "./image/huPos.png";
				
				JLabel lblImg=new JLabel();
				try {
					lblImg=new JLabel(new ImageIcon(ImageIO.read(new File(imageUrl))));
				} catch (IOException e) {
					System.out.println("Non sono riuscito a caricare l'immagine "+imageUrl);
				}
				lblImg.setVisible(true);
				p.add(lblImg,sec.getEsagono()[0]);
			}
	}


	private static Sector fromPointToSector(Point point) {
		for (int i=0; i<sectorViews.length;i++)
			if(sectorViews[i].getPoli().contains(point))
				return sectorViews[i].getSector();
		return null;
	}

	public boolean isMoving() {
		return moving;
	}

	public static void setMoving(boolean moving) {
		MapView.moving = moving;
	}

	public static void setClickable(boolean b) {
		MapView.clickable = b;
		
	}	
	
	public static boolean isSelNoise() {
		return selNoise;
	}

	public static void setSelNoise(boolean selNoise) {
		MapView.selNoise = selNoise;
	}
	
	public static boolean isReqLight() {
		return reqLight;
	}

	public static void setReqLight(boolean reqLight) {
		MapView.reqLight = reqLight;
	}
	
}
