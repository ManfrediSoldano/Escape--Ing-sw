/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.controller.client.ClientMain;
import it.polimi.ingsw.cg_10.model.com.ComDrawCard;
import it.polimi.ingsw.cg_10.model.deck.DangerousSectorDeck;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;
import it.polimi.ingsw.cg_10.model.game.AdvancedGame;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.view.common.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * @author Francesco
 *
 */
public class DeckView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final CardView cardView;
	final CardView cardView_1;
	
	public DeckView(boolean objDeckEnabled){
		
		super();
		setPreferredSize(new Dimension(200, 400));
		setMinimumSize(new Dimension(200, 400));
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 120, 10, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 160, 0, 160, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSectorDeck = new JLabel("DECKS");
		lblSectorDeck.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorDeck.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSectorDeck.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblSectorDeck = new GridBagConstraints();
		gbc_lblSectorDeck.anchor = GridBagConstraints.SOUTH;
		gbc_lblSectorDeck.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSectorDeck.gridwidth = 3;
		gbc_lblSectorDeck.insets = new Insets(0, 0, 5, 0);
		gbc_lblSectorDeck.gridx = 0;
		gbc_lblSectorDeck.gridy = 0;
		add(lblSectorDeck, gbc_lblSectorDeck);
		
		cardView = new CardView(120, 160, "SECTOR CARD","./image/sectorCard.png", false, "", "./image/sectorCard.png", true);
		cardView.setClickable(false);
		GridBagConstraints gbc_cardView = new GridBagConstraints();
		gbc_cardView.insets = new Insets(0, 0, 5, 5);
		gbc_cardView.fill = GridBagConstraints.BOTH;
		gbc_cardView.gridx = 1;
		gbc_cardView.gridy = 2;
		add(cardView, gbc_cardView);
			
		cardView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//invio richiesta pescare carta
			}
		});
		
		cardView.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(cardView.isClickable()){
					ClientMain.ackSend(new ComDrawCard(new DangerousSectorDeck()));
				}
			}
		});
		
		
		cardView_1 = new CardView(120, 160, "OBJECT CARD","./image/objCard.png", false, "", "./image/objCard.png", true);
		cardView_1.setClickable(false);
		GridBagConstraints gbc_cardView_1 = new GridBagConstraints();
		gbc_cardView_1.insets = new Insets(0, 0, 5, 5);
		gbc_cardView_1.fill = GridBagConstraints.BOTH;
		gbc_cardView_1.gridx = 1;
		gbc_cardView_1.gridy = 4;
		add(cardView_1, gbc_cardView_1);
		if(objDeckEnabled)
			cardView_1.setVisible(true);
		else
			cardView_1.setVisible(false);
		cardView_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(cardView_1.isClickable()){
					ClientMain.ackSend(new ComDrawCard(new ObjectDeck()));
				}
			}
		});
		



	}

	public void updateButton(Player player) {
		if(View.getGame().getUserTurno().equals(player.getPlayerName())){
			if(View.getGame() instanceof AdvancedGame)
				cardView_1.setClickable(View.getGame().getPossibiliAzioni().isCartaObj());

			cardView.setClickable(View.getGame().getPossibiliAzioni().isCartaSec());
			
			if(View.getGame().getPossibiliAzioni().isReqNoise() || View.getGame().getPossibiliAzioni().isReqLight())
				MapView.setClickable(true);
			
			MapView.setSelNoise(View.getGame().getPossibiliAzioni().isReqNoise());
			MapView.setReqLight(View.getGame().getPossibiliAzioni().isReqLight());
		}
		
	}

}
