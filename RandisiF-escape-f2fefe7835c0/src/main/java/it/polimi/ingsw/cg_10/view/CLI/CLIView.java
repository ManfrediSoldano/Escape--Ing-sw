package it.polimi.ingsw.cg_10.view.CLI;

import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.view.common.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CLIView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextArea cliTextArea;
	private static JTextField cliTextField;


	public CLIView() {
		setBackground(Color.BLACK);;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 1100, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 500, 30, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollCli = new JScrollPane();
		cliTextArea = new JTextArea();
		cliTextArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_cliTextArea = new GridBagConstraints();
		gbc_cliTextArea.fill = GridBagConstraints.BOTH;
		gbc_cliTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_cliTextArea.gridx = 1;
		gbc_cliTextArea.gridy = 1;
		cliTextArea.setEditable(false);
		cliTextArea.setBackground(Color.DARK_GRAY);
		cliTextArea.setForeground(Color.CYAN);
		cliTextArea.setText("Benvenuto in Escape");
		DefaultCaret caretArea = (DefaultCaret) cliTextArea.getCaret();
		caretArea.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollCli.setViewportView(cliTextArea);
		add(scrollCli, gbc_cliTextArea);
		
		cliTextField = new JTextField();
		cliTextField.setBackground(Color.CYAN);
		cliTextField.setPreferredSize(new Dimension(970, 20));
		cliTextField.setMinimumSize(new Dimension(0, 0));
		GridBagConstraints gbc_cliTextField = new GridBagConstraints();
		gbc_cliTextField.fill = GridBagConstraints.BOTH;
		gbc_cliTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cliTextField.gridx = 1;
		gbc_cliTextField.gridy = 2;
		add(cliTextField, gbc_cliTextField);
		
		cliTextField.addKeyListener(new KeyListener(){

			@Override
            public void keyPressed(KeyEvent e){

                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                	processMessage(cliTextField.getText());
                }       
            }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

        });
	}
	
	public static void processMessage(String string) {
		appendMessage("********** COMMAND: "+string.toUpperCase()+" **********");
		cliTextField.setText("");
		CLIResponse.CLIResp(string.toUpperCase());
	}
	
	public static void appendMessage(String string){
		cliTextArea.append('\n'+string);
	}
	
	public static void sendStringsMex(ArrayList<String> strings){
		for (String s : strings) 
			CLIView.appendMessage(s);
		
	}


	public void updateCLI(Player player) {
		appendMessage("Sei il giocatore: "+player);
		String s="Azioni disponibili: HELP, SHOW";
		if(player.getPlayerName().equals(View.getGame().getUserTurno())){
			if(View	.getGame().getPossibiliAzioni().isMossa())
				s+=", MOVE";
			if(View.getGame().getPossibiliAzioni().isAttacco())
				s+=", ATTACK";
			if(View.getGame().getPossibiliAzioni().isCartaObjUse())
				s+=", USEOBJECTCARD";
			if(View.getGame().getPossibiliAzioni().isCartaObj())
				s+=", DRAWOBJECTCARD";
			if(View.getGame().getPossibiliAzioni().isCartaSec())
				s+=", DRAWSECTORCARD";
			if(View.getGame().getPossibiliAzioni().isFineturno())
				s+=", FINISHTURN";
			
			if(View.getGame().getPossibiliAzioni().isReqLight())
				s=" Dove vuoi fare luce? ";
			if(View.getGame().getPossibiliAzioni().isReqNoise())
				s=" Dove vuoi fare rumore? ";
		}
		
		appendMessage(s);
		s="";
		if(player.getPlayerName().equals(View.getGame().getUserTurno()))
			if(View.getGame().getMessage()!=null && !View.getGame().getMessage().equals(""))
				s += "PRIVATE: "+View.getGame().getMessage();
		if(View.getGame().getToPublish()!=null && !View.getGame().getToPublish().equals(""))
			s += View.getGame().getToPublish();
		
		if(!s.equals(""))
			appendMessage(s);
		
		
	}
			
		
	
}