/**
 * 
 */
package it.polimi.ingsw.cg_10.view.common;

import it.polimi.ingsw.cg_10.controller.client.ClientMain;
import it.polimi.ingsw.cg_10.model.com.ComChooseRoom;

import java.awt.Color;
import java.awt.Dimension;

/**
 * @author Francesco
 *
 */
public class StartView extends View{
	
		public StartView() {

			getFrame().setResizable(false);
			getFrame().setMinimumSize(new Dimension(600, 400));
			getFrame().setPreferredSize(new Dimension(600, 400));
			getFrame().pack();
			getFrame().setLocationRelativeTo(null);
			getFrame().getContentPane().setBackground(Color.BLACK);
		
			MenuPane menuPane = new MenuPane();
			getFrame().getContentPane().add (menuPane.getMenuWindowPanel());
		}
			
		public static boolean close(String map, boolean advMatch, boolean cliView){
			
			if(ClientMain.ackSend(new ComChooseRoom(0, "", true,advMatch, map)).isStat()){
				ClientMain.matchViewStart(cliView, advMatch);
				return true;
			}
			return false;

		}

		@Override
		public void showGameStatus() {}

		@Override
		public void sendToChat(String s) {}





			
		
}
