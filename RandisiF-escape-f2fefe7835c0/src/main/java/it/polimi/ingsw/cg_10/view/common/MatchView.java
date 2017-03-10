/**
 * 
 */
package it.polimi.ingsw.cg_10.view.common;

import it.polimi.ingsw.cg_10.view.CLI.CLIView;
import it.polimi.ingsw.cg_10.view.GUI.GUIView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

/**
 * @author Francesco
 *
 */
public abstract class MatchView extends View {

	private static ChatView chatView;
	private JPanel gameView ;
	
	private GridBagLayout gridBagLayout = new GridBagLayout();
	private GridBagConstraints gbc_guiPanel = new GridBagConstraints();
	private GridBagConstraints gbc_chatPanel = new GridBagConstraints();

	
	public MatchView(boolean advGame){
		super();
		setAdvGame(advGame);
		
		getFrame().setResizable(true);
		getFrame().setMinimumSize(new Dimension(1300, 800));
		getFrame().setPreferredSize(new Dimension(1300, 800));
		getFrame().pack();
		getFrame().setLocationRelativeTo(null);
		getFrame().getContentPane().setBackground(Color.BLACK);
		
		gridBagLayout.columnWidths = new int[]{1300, 0};
		gridBagLayout.rowHeights = new int[]{430, 130, 30, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		getFrame().getContentPane().setLayout(gridBagLayout);
			
		gbc_guiPanel.fill = GridBagConstraints.BOTH;
		gbc_guiPanel.insets = new Insets(0, 0, 5, 0);
		gbc_guiPanel.gridx = 0;
		gbc_guiPanel.gridy = 0;
		
		gbc_chatPanel.gridheight = 2;
		gbc_chatPanel.fill = GridBagConstraints.BOTH;
		gbc_chatPanel.gridx = 0;
		gbc_chatPanel.gridy = 1;
		
		chatView = new ChatView();

		getFrame().getContentPane().add(chatView, gbc_chatPanel);
	}
	
	public void setGUIView(GUIView guiView){
		gameView = guiView;
		getFrame().getContentPane().add(gameView, gbc_guiPanel);
	}
	
	public void setCLIView(CLIView cliView){
		gameView = cliView;
		getFrame().getContentPane().add(gameView, gbc_guiPanel);
	}
	
	public ChatView getChatView() {
		return chatView;
	}

	public void setChatView(ChatView chatView) {
		MatchView.chatView = chatView;
	}

	public JPanel getGameView() {
		return gameView;
	}

	public void setGameView(JPanel gameView) {
		this.gameView = gameView;
	}

	@Override
	public void sendToChat(String s){
		chatView.reciveChatMex(s);
	}
}
