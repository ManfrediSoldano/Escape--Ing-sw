/**
 * 
 */
package it.polimi.ingsw.cg_10.view.common;

import it.polimi.ingsw.cg_10.controller.client.ClientMain;
import it.polimi.ingsw.cg_10.model.com.ComChat;
import it.polimi.ingsw.cg_10.view.GUI.PlayersView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

/**
 * @author Francesco
 *
 */
public class ChatView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlayersView playersView;
	private JTextArea chatTextArea;
	private JTextField chatTextField;

	public ChatView() {
		super();
		setPreferredSize(new Dimension(1200, 130));
		setMinimumSize(new Dimension(1200, 130));
		setBackground(Color.BLACK);
		GridBagLayout gbl_chatPanel = new GridBagLayout();
		gbl_chatPanel.columnWidths = new int[]{30, 400, 30, 400, 30, 0};
		gbl_chatPanel.rowHeights = new int[]{100, 30, 0, 0};
		gbl_chatPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_chatPanel.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_chatPanel);
		
		playersView = new PlayersView();
		playersView.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_playersView = new GridBagConstraints();
		gbc_playersView.gridheight = 2;
		gbc_playersView.insets = new Insets(0, 0, 5, 5);
		gbc_playersView.fill = GridBagConstraints.BOTH;
		gbc_playersView.gridx = 1;
		gbc_playersView.gridy = 0;
		add(playersView, gbc_playersView);
		
		JScrollPane scrollChat = new JScrollPane();
		chatTextArea = new JTextArea();
		chatTextArea.setText("*********************** CHAT ***********************");
		chatTextArea.setEditable(false);
		chatTextArea.setBackground(Color.CYAN);
		GridBagConstraints gbc_chatTextArea = new GridBagConstraints();
		gbc_chatTextArea.fill = GridBagConstraints.BOTH;
		gbc_chatTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_chatTextArea.gridx = 3;
		gbc_chatTextArea.gridy = 0;
		DefaultCaret caretArea = (DefaultCaret) chatTextArea.getCaret();
		caretArea.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollChat.setViewportView(chatTextArea);
		add(scrollChat, gbc_chatTextArea);
		
		chatTextField = new JTextField();
		chatTextField.setBackground(Color.CYAN);
		chatTextField.setMinimumSize(new Dimension(800, 30));
		chatTextField.setPreferredSize(new Dimension(800, 30));
		GridBagConstraints gbc_chatTextField = new GridBagConstraints();
		gbc_chatTextField.insets = new Insets(0, 0, 5, 5);
		gbc_chatTextField.fill = GridBagConstraints.BOTH;
		gbc_chatTextField.gridx = 3;
		gbc_chatTextField.gridy = 1;
		add(chatTextField, gbc_chatTextField);
		
		chatTextField.addKeyListener(new KeyListener(){

			@Override
            public void keyPressed(KeyEvent e){

                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                	processMessage(chatTextField.getText());
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
	
	public PlayersView getPlayersView() {
		return playersView;
	}

	public void setPlayersView(PlayersView playersView) {
		this.playersView = playersView;
	}

	public JTextComponent getChatTextArea() {
		return chatTextArea;
	}

	public void setChatTextArea(JTextArea chatTextArea) {
		this.chatTextArea = chatTextArea;
	}

	public JComponent getChatTextField() {
		return chatTextField;
	}

	public void setChatTextField(JTextField chatTextField) {
		this.chatTextField = chatTextField;
	}
	
	public void reciveChatMex (String s){
		chatTextArea.append('\n'+s);
	}
	
	private void processMessage(String text) {
		reciveChatMex("SEND: "+text);
       	chatTextField.setText("");
		ClientMain.ackSend(new ComChat(text));
	}

}
