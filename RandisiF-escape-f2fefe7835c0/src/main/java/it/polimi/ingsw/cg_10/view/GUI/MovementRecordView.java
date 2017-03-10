/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.model.player.Player;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

/**
 * @author Francesco
 *
 */
public class MovementRecordView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Integer> comboBox;
	private JLabel lbln;
	private List<String> posRonud = new ArrayList<String>();
	
	public MovementRecordView() {
		
		super();
		setPreferredSize(new Dimension(200, 180));
		setMinimumSize(new Dimension(200, 180));
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 60, 60, 60, 10, 0};
		gridBagLayout.rowHeights = new int[]{40, 25, 10, 25, 25, 25, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblMovementRecord = new JLabel("MOVEMENT RECORD");
		lblMovementRecord.setForeground(Color.BLUE);
		lblMovementRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovementRecord.setFont(new Font("Tahoma", Font.BOLD, 21));
		GridBagConstraints gbc_lblMovementRecord = new GridBagConstraints();
		gbc_lblMovementRecord.anchor = GridBagConstraints.SOUTH;
		gbc_lblMovementRecord.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMovementRecord.gridwidth = 3;
		gbc_lblMovementRecord.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovementRecord.gridx = 1;
		gbc_lblMovementRecord.gridy = 0;
		add(lblMovementRecord, gbc_lblMovementRecord);
		
		JLabel lblSelectRound = new JLabel("Round");
		lblSelectRound.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectRound.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSelectRound.setForeground(Color.CYAN);
		GridBagConstraints gbc_lblSelectRound = new GridBagConstraints();
		gbc_lblSelectRound.fill = GridBagConstraints.BOTH;
		gbc_lblSelectRound.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectRound.gridx = 1;
		gbc_lblSelectRound.gridy = 2;
		add(lblSelectRound, gbc_lblSelectRound);
		

		comboBox = new JComboBox<Integer>();	
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBackground(Color.BLACK);
		comboBox.setForeground(Color.WHITE);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		JLabel lblSector = new JLabel("Sector");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSector.setForeground(Color.CYAN);
		GridBagConstraints gbc_lblSector = new GridBagConstraints();
		gbc_lblSector.insets = new Insets(0, 0, 5, 5);
		gbc_lblSector.gridx = 1;
		gbc_lblSector.gridy = 4;
		add(lblSector, gbc_lblSector);
		
		lbln = new JLabel("");
		lbln.setHorizontalAlignment(SwingConstants.CENTER);
		lbln.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbln.setForeground(new Color(0, 255, 255));
		GridBagConstraints gbc_lbln = new GridBagConstraints();
		gbc_lbln.fill = GridBagConstraints.BOTH;
		gbc_lbln.insets = new Insets(0, 0, 5, 5);
		gbc_lbln.gridx = 2;
		gbc_lbln.gridy = 4;
		add(lbln, gbc_lbln);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=-1)
					lbln.setText(posRonud.get(comboBox.getSelectedIndex()));
			}
		});

	}

	public void updateMovementRecord(Player player) {
		
		posRonud.clear();
		comboBox.removeAllItems();
		for (int i=0;i<player.getMovementRec().getMovementList().size();i++) {
			posRonud.add(player.getMovementRec().getMovementList().get(i).getPosition().getSectorID().toString());
			comboBox.addItem(i);
		}
		
	}

}
