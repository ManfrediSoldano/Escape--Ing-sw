/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * @author Francesco
 *
 */
public class PlayerDataView extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPlayerName;
	private JLabel lblObjcard;
	
	public PlayerDataView(){
		setPreferredSize(new Dimension(98, 50));
		setMinimumSize(new Dimension(98, 50));
		setMaximumSize(new Dimension(98, 50));
		
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{4, 45, 45, 4, 0};
		gridBagLayout.rowHeights = new int[]{30, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblPlayerName = new JLabel();
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlayerName.setForeground(Color.CYAN);
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setPreferredSize(new Dimension(98, 20));
		lblPlayerName.setMinimumSize(new Dimension(98, 20));
		lblPlayerName.setMaximumSize(new Dimension(98, 20));
		GridBagConstraints gbc_lblPlayerName = new GridBagConstraints();
		gbc_lblPlayerName.fill = GridBagConstraints.BOTH;
		gbc_lblPlayerName.gridwidth = 4;
		gbc_lblPlayerName.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlayerName.gridx = 0;
		gbc_lblPlayerName.gridy = 0;
		add(lblPlayerName, gbc_lblPlayerName);
		
		lblObjcard = new JLabel();
		lblObjcard.setForeground(Color.CYAN);
		lblObjcard.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObjcard.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblObjcard = new GridBagConstraints();
		gbc_lblObjcard.gridwidth = 2;
		gbc_lblObjcard.insets = new Insets(0, 0, 0, 5);
		gbc_lblObjcard.gridx = 1;
		gbc_lblObjcard.gridy = 1;
		add(lblObjcard, gbc_lblObjcard);
	}
	
	public void setLblPlayerName (String playerName){
		
		lblPlayerName.setText(playerName);
		lblObjcard.setText ("ObjCard: 0");
	}
	
	public void setLblObjCard (int objCardNum){
		lblObjcard.setText("ObjCard: "+objCardNum);
	}
	
	public void setPlayerStatus(boolean status){
		if(status)
			lblPlayerName.setForeground(Color.GREEN);
		else
			lblPlayerName.setForeground(Color.RED);
	}
	
	
}
