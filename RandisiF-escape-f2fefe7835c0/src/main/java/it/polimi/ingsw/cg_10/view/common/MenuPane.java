/**
 * 
 */
package it.polimi.ingsw.cg_10.view.common;

import it.polimi.ingsw.cg_10.controller.client.ClientMain;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * @author Francesco
 *
 */
public class MenuPane {
	
	private JPanel menuWindowPanel;
	
	public MenuPane(){
		menuWindowPanel = new JPanel();
		GridBagLayout gbl_menuWindowPanel = new GridBagLayout();
		gbl_menuWindowPanel.columnWidths = new int[]{150, 200, 150, 0};
		gbl_menuWindowPanel.rowHeights = new int[]{50, 40, 42, 159, 0, 0};
		gbl_menuWindowPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_menuWindowPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		menuWindowPanel.setLayout(gbl_menuWindowPanel);
		
		JLabel lblComProtocol = new JLabel("Com protocol");
		final JComboBox<String> comboBox = new JComboBox<String>();	
		final JButton btnOk1 = new JButton("OK");	
		
		final JLabel lblPlayerName = new JLabel("Player Name");
		final JTextField txtInsertYourName = new JTextField();
		final JButton btnOk2 = new JButton("OK");
		
		final JPanel roomPanel = new JPanel();
		JLabel lblMapList = new JLabel("Select Map ");
		final JComboBox<String> selectMap = new JComboBox<String>();
		final JCheckBox cbCLISelect= new JCheckBox();
		final JButton btnConnect = new JButton("Start Game");
		
//		final JPanel newRoomPanel = new JPanel();
//		JLabel lblRoomName = new JLabel("Room Name");
//		JTextField roomNametextField = new JTextField();
//		JLabel lblChooseMap = new JLabel("Choose map");
//		JComboBox<String> selectMap = new JComboBox<String>();
						
		lblComProtocol.setHorizontalAlignment(SwingConstants.CENTER);
		lblComProtocol.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblComProtocol = new GridBagConstraints();
		gbc_lblComProtocol.anchor = GridBagConstraints.EAST;
		gbc_lblComProtocol.insets = new Insets(0, 0, 5, 5);
		gbc_lblComProtocol.gridx = 0;
		gbc_lblComProtocol.gridy = 1;
		menuWindowPanel.add(lblComProtocol, gbc_lblComProtocol);
				
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Socket", "RMI"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		menuWindowPanel.add(comboBox, gbc_comboBox);

		btnOk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientMain.initComm((String)comboBox.getItemAt(comboBox.getSelectedIndex()));
				comboBox.setEnabled(false);
				btnOk1.setEnabled(false);
				lblPlayerName.setVisible(true);
				txtInsertYourName.setVisible(true);
				btnOk2.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnOk1 = new GridBagConstraints();
		gbc_btnOk1.anchor = GridBagConstraints.WEST;
		gbc_btnOk1.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk1.gridx = 2;
		gbc_btnOk1.gridy = 1;
		menuWindowPanel.add(btnOk1, gbc_btnOk1);
		
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setVisible(false);
		GridBagConstraints gbc_lblPlayerName = new GridBagConstraints();
		gbc_lblPlayerName.anchor = GridBagConstraints.EAST;
		gbc_lblPlayerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerName.gridx = 0;
		gbc_lblPlayerName.gridy = 2;
		menuWindowPanel.add(lblPlayerName, gbc_lblPlayerName);

		txtInsertYourName.setVisible(false);
		GridBagConstraints gbc_txtInsertYourName = new GridBagConstraints();
		gbc_txtInsertYourName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsertYourName.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsertYourName.gridx = 1;
		gbc_txtInsertYourName.gridy = 2;
		menuWindowPanel.add(txtInsertYourName, gbc_txtInsertYourName);
		
		btnOk2.setVisible(false);
		btnOk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtInsertYourName.getText().equals("")){	
					if (!ClientMain.initUserName(txtInsertYourName.getText())){
						JOptionPane.showMessageDialog(menuWindowPanel, "Connection error, please retry", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else{
						txtInsertYourName.setEnabled(false);
						btnOk2.setEnabled(false);
						JOptionPane.showMessageDialog(menuWindowPanel, "Connection ok", "Connected", JOptionPane.INFORMATION_MESSAGE);
						roomPanel.setVisible(true);		

					}
				}
				else
					JOptionPane.showMessageDialog(menuWindowPanel, "Please insert your name", "Error", JOptionPane.ERROR_MESSAGE);	
			}

		});		
		GridBagConstraints gbc_btnOk2 = new GridBagConstraints();
		gbc_btnOk2.anchor = GridBagConstraints.WEST;
		gbc_btnOk2.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk2.gridx = 2;
		gbc_btnOk2.gridy = 2;
		menuWindowPanel.add(btnOk2, gbc_btnOk2);
		
		roomPanel.setPreferredSize(new Dimension(400, 150));
		roomPanel.setMinimumSize(new Dimension(400, 150));
		roomPanel.setVisible(false);
		roomPanel.setBackground(Color.CYAN);
		roomPanel.setBorder(new LineBorder(Color.BLACK, 4, true));
		GridBagConstraints gbc_roomPanel = new GridBagConstraints();
		gbc_roomPanel.insets = new Insets(0, 0, 5, 0);
		gbc_roomPanel.gridwidth = 3;
		gbc_roomPanel.gridx = 0;
		gbc_roomPanel.gridy = 3;
		menuWindowPanel.add(roomPanel, gbc_roomPanel);
		GridBagLayout gbl_roomPanel = new GridBagLayout();
		gbl_roomPanel.columnWidths = new int[]{120, 160, 120, 0};
		gbl_roomPanel.rowHeights = new int[]{100, 0, 0, 111, 0};
		gbl_roomPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_roomPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		roomPanel.setLayout(gbl_roomPanel);

		lblMapList.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMapList = new GridBagConstraints();
		gbc_lblMapList.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblMapList.insets = new Insets(0, 0, 5, 5);
		gbc_lblMapList.gridx = 0;
		gbc_lblMapList.gridy = 0;
		roomPanel.add(lblMapList, gbc_lblMapList);

		selectMap.addItem("Galilei");
		selectMap.addItem("Fermi");
		selectMap.addItem("Galvani");
		GridBagConstraints gbc_selectMap = new GridBagConstraints();
		gbc_selectMap.anchor = GridBagConstraints.SOUTH;
		gbc_selectMap.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectMap.insets = new Insets(0, 0, 5, 5);
		gbc_selectMap.gridx = 1;
		gbc_selectMap.gridy = 0;
		roomPanel.add(selectMap, gbc_selectMap);
		
		final JCheckBox cbAdvSelect = new JCheckBox("Advanced mode");
		cbAdvSelect.setBackground(Color.CYAN);
		GridBagConstraints gbc_cbAdvSelect = new GridBagConstraints();
		gbc_cbAdvSelect.anchor = GridBagConstraints.SOUTHWEST;
		gbc_cbAdvSelect.insets = new Insets(0, 0, 5, 5);
		gbc_cbAdvSelect.gridx = 1;
		gbc_cbAdvSelect.gridy = 1;
		roomPanel.add(cbAdvSelect, gbc_cbAdvSelect);

		cbCLISelect.setBackground(Color.CYAN);
		cbCLISelect.setText("Use CLI");
		GridBagConstraints gbc_cbCLISelect = new GridBagConstraints();
		gbc_cbCLISelect.anchor = GridBagConstraints.SOUTHWEST;
		gbc_cbCLISelect.insets = new Insets(0, 0, 5, 5);
		gbc_cbCLISelect.gridx = 1;
		gbc_cbCLISelect.gridy = 2;
		roomPanel.add(cbCLISelect, gbc_cbCLISelect);

		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.insets = new Insets(0, 0, 0, 5);
		gbc_btnConnect.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConnect.anchor = GridBagConstraints.NORTH;
		gbc_btnConnect.gridx = 1;
		gbc_btnConnect.gridy = 3;
		roomPanel.add(btnConnect, gbc_btnConnect);
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectMap.getSelectedIndex() != -1){
					JOptionPane.showMessageDialog(menuWindowPanel, "Starting...", "Starting", JOptionPane.INFORMATION_MESSAGE);
					if(StartView.close((String)selectMap.getSelectedItem(), cbAdvSelect.isSelected(), cbCLISelect.isSelected())){
						selectMap.setEnabled(false);
						cbAdvSelect.setEnabled(false);
						cbCLISelect.setEnabled(false);
						btnConnect.setEnabled(false);
						JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(menuWindowPanel);
						topFrame.dispose();
					}
				}
			}
		});
					
		menuWindowPanel.setVisible(true);
		menuWindowPanel.setBackground(Color.CYAN);
		menuWindowPanel.setPreferredSize(new Dimension(500, 360));
		menuWindowPanel.setMinimumSize(new Dimension(500, 360));
		menuWindowPanel.setSize(500, 360);
	}

	public JPanel getMenuWindowPanel() {
		return this.menuWindowPanel;
	}
}

