package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.view.common.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JTextArea;


public class RoundView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblRound = new JLabel();
	JLabel lblPlayerName = new JLabel();
	JLabel lblOc = new JLabel();
	JLabel lblPenultimaMossa = new JLabel();
	private final JTextArea textArea = new JTextArea();

	public RoundView(){
		
		super();
		setPreferredSize(new Dimension(200, 180));
		setMinimumSize(new Dimension(200, 180));
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 60, 60, 60, 10, 0};
		gridBagLayout.rowHeights = new int[]{35, 10, 3, 0, 3, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblRound.setHorizontalAlignment(SwingConstants.CENTER);
		lblRound.setAlignmentY(0.0f);
		lblRound.setForeground(Color.BLUE);
		lblRound.setFont(new Font("Tahoma", Font.BOLD, 19));
		GridBagConstraints gbc_lblRound = new GridBagConstraints();
		gbc_lblRound.anchor = GridBagConstraints.SOUTH;
		gbc_lblRound.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRound.gridwidth = 3;
		gbc_lblRound.insets = new Insets(0, 0, 5, 5);
		gbc_lblRound.gridx = 1;
		gbc_lblRound.gridy = 0;
		add(lblRound, gbc_lblRound);
		
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPlayerName.setForeground(Color.CYAN);
		GridBagConstraints gbc_lblPlayerName = new GridBagConstraints();
		gbc_lblPlayerName.fill = GridBagConstraints.BOTH;
		gbc_lblPlayerName.gridwidth = 2;
		gbc_lblPlayerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerName.gridx = 1;
		gbc_lblPlayerName.gridy = 1;
		add(lblPlayerName, gbc_lblPlayerName);
		
		lblOc.setHorizontalAlignment(SwingConstants.CENTER);
		lblOc.setForeground(Color.CYAN);
		GridBagConstraints gbc_lblOc = new GridBagConstraints();
		gbc_lblOc.fill = GridBagConstraints.BOTH;
		gbc_lblOc.insets = new Insets(0, 0, 5, 5);
		gbc_lblOc.gridx = 3;
		gbc_lblOc.gridy = 1;
		add(lblOc, gbc_lblOc);
		
		JScrollPane scrollPane = new JScrollPane();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		textArea.setBackground(Color.CYAN);
		DefaultCaret caretArea = (DefaultCaret) textArea.getCaret();
		caretArea.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane.setViewportView(textArea);
		add(scrollPane, gbc_textArea);

	}

	public void update(Player player) {
		lblRound.setText("ROUND " + (View.getGame().findFromUsername(View.getGame().getUserTurno()).getMovementRec().getMovementList().size()-1));
		lblPlayerName.setText(View.getGame().getUserTurno());
		textArea.append(View.getGame().getToPublish());
		if(player.getPlayerName().equals(View.getGame().getUserTurno()))
			if(View.getGame().getMessage()!=null && !View.getGame().getMessage().equals(""))
			textArea.append("\nPRIVATE: "+View.getGame().getMessage());
	}
	
}