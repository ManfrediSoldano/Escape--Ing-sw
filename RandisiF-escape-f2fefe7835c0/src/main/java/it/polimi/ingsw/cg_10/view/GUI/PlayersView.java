/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.model.player.Player;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Francesco
 *
 */
public class PlayersView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PlayerDataView> player;

	public PlayersView(){
				
		super();
		
		player=new ArrayList<PlayerDataView>(8);
		player.add(new PlayerDataView());
		player.add(new PlayerDataView());
		player.add(new PlayerDataView());
		player.add(new PlayerDataView());
		player.add(new PlayerDataView());
		player.add(new PlayerDataView());
		player.add(new PlayerDataView());
		player.add(new PlayerDataView());
		
		setPreferredSize(new Dimension(400, 130));
		setMinimumSize(new Dimension(400, 130));
		setBackground(Color.DARK_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{2, 98, 98, 98, 98, 2, 0};
		gridBagLayout.rowHeights = new int[]{0, 30, 50, 50, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblPlayerView = new JLabel("PLAYERS");
		lblPlayerView.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerView.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPlayerView.setForeground(Color.WHITE);
		lblPlayerView.setAlignmentY(0.0f);
		GridBagConstraints gbc_lblPlayerView = new GridBagConstraints();
		gbc_lblPlayerView.fill = GridBagConstraints.BOTH;
		gbc_lblPlayerView.gridwidth = 4;
		gbc_lblPlayerView.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerView.gridx = 1;
		gbc_lblPlayerView.gridy = 1;
		add(lblPlayerView, gbc_lblPlayerView);
		
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(0, 0, 5, 5);
		gbc_player1.fill = GridBagConstraints.BOTH;
		gbc_player1.gridx = 1;
		gbc_player1.gridy = 2;
		player.get(0).setBackground(Color.GRAY);
		add(player.get(0), gbc_player1);
		
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(0, 0, 5, 5);
		gbc_player2.fill = GridBagConstraints.BOTH;
		gbc_player2.gridx = 2;
		gbc_player2.gridy = 2;
		player.get(1).setBackground(Color.GRAY);
		add(player.get(1), gbc_player2);
		
		GridBagConstraints gbc_player3 = new GridBagConstraints();
		gbc_player3.insets = new Insets(0, 0, 5, 5);
		gbc_player3.fill = GridBagConstraints.BOTH;
		gbc_player3.gridx = 3;
		gbc_player3.gridy = 2;
		player.get(2).setBackground(Color.GRAY);
		add(player.get(2), gbc_player3);
		
		GridBagConstraints gbc_player4 = new GridBagConstraints();
		gbc_player4.insets = new Insets(0, 0, 5, 5);
		gbc_player4.fill = GridBagConstraints.BOTH;
		gbc_player4.gridx = 4;
		gbc_player4.gridy = 2;
		player.get(3).setBackground(Color.GRAY);
		add(player.get(3), gbc_player4);
		
		GridBagConstraints gbc_player5 = new GridBagConstraints();
		gbc_player5.insets = new Insets(0, 0, 5, 5);
		gbc_player5.fill = GridBagConstraints.BOTH;
		gbc_player5.gridx = 1;
		gbc_player5.gridy = 3;
		player.get(4).setBackground(Color.GRAY);
		add(player.get(4), gbc_player5);
		
		GridBagConstraints gbc_player6 = new GridBagConstraints();
		gbc_player6.insets = new Insets(0, 0, 5, 5);
		gbc_player6.fill = GridBagConstraints.BOTH;
		gbc_player6.gridx = 2;
		gbc_player6.gridy = 3;
		player.get(5).setBackground(Color.GRAY);
		add(player.get(5), gbc_player6);
		
		GridBagConstraints gbc_player7 = new GridBagConstraints();
		gbc_player7.insets = new Insets(0, 0, 5, 5);
		gbc_player7.fill = GridBagConstraints.BOTH;
		gbc_player7.gridx = 3;
		gbc_player7.gridy = 3;
		player.get(6).setBackground(Color.GRAY);
		add(player.get(6), gbc_player7);
		
		GridBagConstraints gbc_player8 = new GridBagConstraints();
		gbc_player8.insets = new Insets(0, 0, 5, 5);
		gbc_player8.fill = GridBagConstraints.BOTH;
		gbc_player8.gridx = 4;
		gbc_player8.gridy = 3;
		player.get(7).setBackground(Color.GRAY);
		add(player.get(7), gbc_player8);

	}

	public void updatePlayersView(ArrayList<Player> playerList) {

		int index = 0;
		for (Player p : playerList ) {
			player.get(index).setLblPlayerName(p.getPlayerName());
			player.get(index).setLblObjCard(p.getObjOwned().getCardList().size());
			player.get(index).setPlayerStatus(p.isAlive());
			index++;
		}
		
	}
}
