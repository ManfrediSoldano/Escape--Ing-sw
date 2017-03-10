/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.controller.client.ClientMain;
import it.polimi.ingsw.cg_10.controller.rules.PossibiliAzioni;
import it.polimi.ingsw.cg_10.model.com.ComAttack;
import it.polimi.ingsw.cg_10.model.com.ComEndTurn;
import it.polimi.ingsw.cg_10.model.com.ComUseCard;
import it.polimi.ingsw.cg_10.model.game.AdvancedGame;
import it.polimi.ingsw.cg_10.model.player.Alien;
import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.view.common.View;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/**
 * @author Francesco
 *
 */
public class PlayerPane extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String mouseOverText = "Only advanced mode";
	private Player player = new Player();
	private JLabel lblPlayerCharacter;
	private JLabel lblPlayerName;
	private JLabel label;
	private JButton btnMove;

	private JLabel lblf;
	private JButton btnAttack;
	private	JButton btnEndRound;
	private	CardView cardView1;
	private	CardView cardView2;
	private	CardView cardView3;
		
	
	public PlayerPane(boolean objDeckEnabled){
		
		super();
		setPreferredSize(new Dimension(200, 400));
		setMinimumSize(new Dimension(200, 400));
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 60, 60, 60, 10, 0};
		gridBagLayout.rowHeights = new int[]{35, 35, 0, 35, 5, 40, 5, 40, 5, 40, 10, 35, 85, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblPlayerCharacter = new JLabel();
		lblPlayerCharacter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlayerCharacter.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblPlayerCharacter = new GridBagConstraints();
		gbc_lblPlayerCharacter.gridwidth = 3;
		gbc_lblPlayerCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerCharacter.gridx = 1;
		gbc_lblPlayerCharacter.gridy = 0;
		add(lblPlayerCharacter, gbc_lblPlayerCharacter);
		
		lblPlayerName = new JLabel();
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPlayerName.setForeground(Color.CYAN);
		GridBagConstraints gbc_lblPlayerName = new GridBagConstraints();
		gbc_lblPlayerName.anchor = GridBagConstraints.SOUTH;
		gbc_lblPlayerName.gridwidth = 3;
		gbc_lblPlayerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerName.gridx = 1;
		gbc_lblPlayerName.gridy = 1;
		add(lblPlayerName, gbc_lblPlayerName);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 19));
		label.setForeground(Color.CYAN);
		label.setAlignmentY(0.0f);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		add(label, gbc_label);
		
		btnMove = new JButton("Move");
		btnMove.setEnabled(false);
		btnMove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMove.setForeground(Color.WHITE);
		btnMove.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnMove = new GridBagConstraints();
		gbc_btnMove.fill = GridBagConstraints.BOTH;
		gbc_btnMove.gridwidth = 2;
		gbc_btnMove.insets = new Insets(0, 0, 5, 5);
		gbc_btnMove.gridx = 1;
		gbc_btnMove.gridy = 5;
		add(btnMove, gbc_btnMove);
		
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Select destination");
				MapView.setMoving(true);
				MapView.setClickable(true);
			}
		});	
		
		lblf = new JLabel();
		lblf.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblf.setForeground(Color.CYAN);
		GridBagConstraints gbc_lblf = new GridBagConstraints();
		gbc_lblf.insets = new Insets(0, 0, 5, 5);
		gbc_lblf.gridx = 3;
		gbc_lblf.gridy = 5;
		add(lblf, gbc_lblf);
		
		btnAttack = new JButton("Attack");
		btnAttack.setEnabled(false);
		btnAttack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAttack.setForeground(Color.WHITE);
		btnAttack.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.fill = GridBagConstraints.BOTH;
		gbc_btnAttack.gridwidth = 2;
		gbc_btnAttack.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack.gridx = 1;
		gbc_btnAttack.gridy = 7;
		add(btnAttack, gbc_btnAttack);
		
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientMain.ackSend(new ComAttack(player.getMovementRec().getLastPlayerRecord().getPosition().getSectorID()));	
			}
		});	
	
		btnEndRound = new JButton("End turn");
		btnEndRound.setEnabled(false);
		btnEndRound.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEndRound.setForeground(Color.WHITE);
		btnEndRound.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnEndRound = new GridBagConstraints();
		gbc_btnEndRound.fill = GridBagConstraints.BOTH;
		gbc_btnEndRound.gridwidth = 2;
		gbc_btnEndRound.insets = new Insets(0, 0, 5, 5);
		gbc_btnEndRound.gridx = 1;
		gbc_btnEndRound.gridy = 9;
		add(btnEndRound, gbc_btnEndRound);
		
		btnEndRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientMain.ackSend(new ComEndTurn());			
			}
		});	
		
		final JLabel lblNewLabel = new JLabel("Object Card");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.CYAN);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 11;
		add(lblNewLabel, gbc_lblNewLabel);
		
		if (objDeckEnabled){
			cardView1 = new CardView(60, 85, "OBJECT CARD","./image/objCard.png", false, "", "./image/objCard.png",true);
			cardView2 = new CardView(60, 85, "OBJECT CARD","./image/objCard.png", false, "", "./image/objCard.png",true);
			cardView3 = new CardView(60, 85, "OBJECT CARD","./image/objCard.png", false, "", "./image/objCard.png",true);
		}else{
			cardView1 = new CardView(60, 85, "","./image/objDis.png", false, "", "./image/objDis.png",true);
			cardView2 = new CardView(60, 85, "","./image/objDis.png", false, "", "./image/objDis.png",true);
			cardView3 = new CardView(60, 85, "","./image/objDis.png", false, "", "./image/objDis.png",true);
			
			cardView1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel.setText(mouseOverText);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel.setText("Object Card");
				}
			});
			
			cardView2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel.setText(mouseOverText);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel.setText("Object Card");
				}
			});
			
			cardView3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel.setText(mouseOverText);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel.setText("Object Card");
				}
			});
		}
		
		GridBagConstraints gbc_cardView1 = new GridBagConstraints();
		gbc_cardView1.fill = GridBagConstraints.BOTH;
		gbc_cardView1.insets = new Insets(0, 0, 5, 5);
		gbc_cardView1.gridx = 1;
		gbc_cardView1.gridy = 12;
		add(cardView1, gbc_cardView1);
		
		GridBagConstraints gbc_cardView2 = new GridBagConstraints();
		gbc_cardView2.fill = GridBagConstraints.BOTH;
		gbc_cardView2.insets = new Insets(0, 0, 5, 5);
		gbc_cardView2.gridx = 2;
		gbc_cardView2.gridy = 12;
		add(cardView2, gbc_cardView2);
		
		GridBagConstraints gbc_cardView3 = new GridBagConstraints();
		gbc_cardView3.insets = new Insets(0, 0, 5, 5);
		gbc_cardView3.fill = GridBagConstraints.BOTH;
		gbc_cardView3.gridx = 3;
		gbc_cardView3.gridy = 12;
		add(cardView3, gbc_cardView3);
		
		cardView1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(cardView1.isClickable()){
					ClientMain.ackSend(new ComUseCard(0));
					cardView2.setCoperta(true);
					cardView2.setClickable(false);
				}
			}
		});
		
		cardView2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(cardView2.isClickable()){
					ClientMain.ackSend(new ComUseCard(1));
						cardView2.setCoperta(true);
						cardView2.setClickable(false);
				}
			}
		});
		
		cardView3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(cardView3.isClickable()){
					ClientMain.ackSend(new ComUseCard(2));
						cardView3.setCoperta(true);
						cardView3.setClickable(false);
				}
			}
		});

	}

	public void updatePlayerPane(Player player) {
		
		setPlayer(player);
		if (player instanceof Alien){
			lblPlayerCharacter.setText("Alien");
			lblPlayerCharacter.setForeground(Color.MAGENTA);
		}else if (player instanceof Human){
			lblPlayerCharacter.setText("Human");
			lblPlayerCharacter.setForeground(Color.BLUE);
		}else
			lblPlayerCharacter.setText("Player");
			
		lblPlayerName.setText(player.getPlayerName());
		
		lblf.setText(player.getMovementRec().getLastPlayerRecord().getPosition().getSectorID().toString());
		
		label.setText("ROUND "+(player.getMovementRec().getMovementList().size()-1));
		
		switch(player.getObjOwned().getCardList().size())
		{
			case 1:
				cardView1.setImgFronte("./image/"+player.getObjOwned().getCardList().get(0).getObjType()+".png", player.getObjOwned().getCardList().get(0).getObjType().toString());
				cardView1.setCoperta(false);
				cardView2.setCoperta(true);
				cardView3.setCoperta(true);
				break;
				
			case 2:
				cardView1.setImgFronte("./image/"+player.getObjOwned().getCardList().get(0).getObjType()+".png", player.getObjOwned().getCardList().get(0).getObjType().toString());
				cardView2.setImgFronte("./image/"+player.getObjOwned().getCardList().get(1).getObjType()+".png", player.getObjOwned().getCardList().get(1).getObjType().toString());
				cardView1.setCoperta(false);
				cardView2.setCoperta(false);
				cardView3.setCoperta(true);
				break;
				
			case 3:
				cardView1.setImgFronte("./image/"+player.getObjOwned().getCardList().get(0).getObjType()+".png", player.getObjOwned().getCardList().get(0).getObjType().toString());
				cardView2.setImgFronte("./image/"+player.getObjOwned().getCardList().get(1).getObjType()+".png", player.getObjOwned().getCardList().get(1).getObjType().toString());
				cardView3.setImgFronte("./image/"+player.getObjOwned().getCardList().get(2).getObjType()+".png", player.getObjOwned().getCardList().get(2).getObjType().toString());
				cardView1.setCoperta(false);
				cardView2.setCoperta(false);
				cardView3.setCoperta(false);
				break;
				
			default:
				cardView1.setCoperta(true);
				cardView2.setCoperta(true);
				cardView3.setCoperta(true);
				break;
		
		}
			
	}
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}


	public void updateButton(Player player) {
		PossibiliAzioni posAz = null;
		lblf.setText(player.getMovementRec().getLastPlayerRecord().getPosition().getSectorID().toString());
		if(View.getGame().getUserTurno().equals(player.getPlayerName())){
			posAz = View.getGame().getPossibiliAzioni();			
			btnAttack.setEnabled(posAz.isAttacco());
			btnMove.setEnabled(posAz.isMossa());
			btnEndRound.setEnabled(posAz.isFineturno());
			if(View.getGame() instanceof AdvancedGame){
				cardView1.setClickable(posAz.isCartaObjUse());
				cardView2.setClickable(posAz.isCartaObjUse());
				cardView3.setClickable(posAz.isCartaObjUse());
			}else{
				cardView1.setClickable(false);
				cardView2.setClickable(false);
				cardView3.setClickable(false);
			}
		}else{
			btnAttack.setEnabled(false);
			btnMove.setEnabled(false);
			btnEndRound.setEnabled(false);
			cardView1.setClickable(false);
			cardView2.setClickable(false);
			cardView3.setClickable(false);
		}
		
		
	}
}
