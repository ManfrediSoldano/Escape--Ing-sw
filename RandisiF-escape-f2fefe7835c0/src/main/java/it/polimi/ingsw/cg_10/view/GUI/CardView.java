/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author Francesco
 *
 */
public class CardView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean coperta;
	private boolean clickable;

	private JLabel fronte = new JLabel();
	private JLabel retro = new JLabel();
	private JLabel imgFronte = new JLabel();
	private JLabel imgRetro = new JLabel();
	private JLabel imgObj = new JLabel();
	private JLabel typeLabel = new JLabel();
	private JLabel cardLabel = new JLabel();
	
	

	public CardView(int larghezza, int altezza){
		
		super();
		
		setBounds(new Rectangle(0, 0, larghezza, altezza));
		setBackground(Color.CYAN);
		setCoperta(true);
		setLayout(null);
		setClickable(false);
		
		fronte.setBackground(Color.WHITE);
		fronte.setVisible(false);
		fronte.setLayout(null);
		fronte.setOpaque(true);
		imgObj.setSize( 40, 40);
		imgObj.setOpaque(true);
		imgObj.setVisible(true);

		imgFronte.setSize( 80, 80);
		imgFronte.setOpaque(true);
		imgFronte.setVisible(true);

		add(fronte);
		
		retro.setBackground(Color.BLACK);
		retro.setVisible(true);
		retro.setLayout(null);
		retro.setOpaque(true);
		imgRetro.setSize( 80, 80);
		imgRetro.setOpaque(true);
		imgRetro.setVisible(true);

		add(retro);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(clickable){
					fronte.setBorder(new LineBorder(Color.BLUE, 1));
					retro.setBorder(new LineBorder(Color.BLUE, 1));
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				fronte.setBorder(null);
				retro.setBorder(null);
			}
		});
	}
	
	public CardView(int larghezza, int altezza, String backLbl, String backImgPath, boolean icon, String frontLbl, String frontImgPath , boolean coperta){
		
		this(larghezza, altezza);
		
		setImgFronte(frontImgPath, frontLbl);
		setImgRetro(backImgPath, backLbl);
		if(icon)
			setImgObj("./image/objDraw.png");
		
		setCoperta(coperta);
		
	}
	
	@Override
	public void setBounds (int x, int y, int larghezza,int altezza){
		super.setBounds(x, y, larghezza, altezza);
		getFronte().setBounds(0, 0, this.getWidth(), this.getHeight());
		getRetro().setBounds(0, 0, this.getWidth(), this.getHeight());
	}
	

	public JLabel getFronte() {
		return fronte;
	}

	public void setFronte(JLabel fronte) {
		this.fronte = fronte;
	}
	
	public boolean isCoperta() {
		return coperta;
	}

	public void setCoperta(boolean coperta) {
		this.coperta = coperta;
		if(coperta){
			getRetro().setVisible(true);
			getFronte().setVisible(false);
		}else{
			getRetro().setVisible(false);
			getFronte().setVisible(true);
		}
	}
	
	public JLabel getRetro() {
		return retro;
	}

	public void setRetro(JLabel retro) {
		this.retro = retro;
	}

	public void setImgRetro(String path, String backLbl) {
		try {
			this.imgRetro=	new JLabel(new ImageIcon(ImageIO.read(new File(path)).getScaledInstance(retro.getWidth()/3*2, retro.getWidth()/3*2, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			System.out.println("Non sono riuscito a caricare l'immagine "+path);
		}
		imgRetro.setSize(retro.getWidth()/3*2, retro.getWidth()/3*2);
		imgRetro.setLocation(retro.getWidth()/2-imgRetro.getWidth()/2, retro.getHeight()/2-imgRetro.getHeight()/2);
		retro.add(imgRetro);
		
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardLabel.setFont(new Font("Tahoma", Font.BOLD, imgRetro.getWidth()/6));
		cardLabel.setForeground(Color.WHITE);;
		cardLabel.setText(backLbl);
		cardLabel.setBounds(0, 0, fronte.getWidth(), 30);
		retro.add(cardLabel);
		
	}

	public void setImgFronte(String path, String type) {
		try {
			this.imgFronte=	new JLabel(new ImageIcon(ImageIO.read(new File(path)).getScaledInstance(fronte.getWidth()/3*2, fronte.getWidth()/3*2, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			System.out.println("Non sono riuscito a caricare l'immagine "+path);
		}
		imgFronte.setSize(fronte.getWidth()/3*2, fronte.getWidth()/3*2);
		imgFronte.setLocation(fronte.getWidth()/2-imgFronte.getWidth()/2, fronte.getHeight()/2-imgFronte.getHeight()/2);
		fronte.add(imgFronte);
		
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setFont(new Font("Tahoma", Font.BOLD, imgFronte.getWidth()/6));
		typeLabel.setText(type);
		typeLabel.setBounds(0, fronte.getHeight()-30, fronte.getWidth(), 30);
		fronte.add(typeLabel);
	}

	public void setImgObj(String path) {
		try {
			this.imgObj=	new JLabel((new ImageIcon(ImageIO.read(new File(path)).getScaledInstance(fronte.getWidth()/6*2, fronte.getWidth()/6*2, Image.SCALE_AREA_AVERAGING))));
		} catch (IOException e) {
			System.out.println("Non sono riuscito a caricare l'immagine "+path);
		}
		imgObj.setSize(fronte.getWidth()/6*2, fronte.getWidth()/6*2);
		imgObj.setLocation(0, 0);
		fronte.add(imgObj);
	}

	public boolean isClickable() {
		return clickable;
	}

	public void setClickable(boolean clickable) {
		this.clickable = clickable;
	}
}
