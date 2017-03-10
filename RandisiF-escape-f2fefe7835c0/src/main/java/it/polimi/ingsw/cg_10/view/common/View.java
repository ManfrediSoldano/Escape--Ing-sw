/**
 * 
 */
package it.polimi.ingsw.cg_10.view.common;

import it.polimi.ingsw.cg_10.model.game.AdvancedGame;
import it.polimi.ingsw.cg_10.model.game.Game;
import it.polimi.ingsw.cg_10.model.player.Player;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * @author Francesco
 *
 */
public abstract class View implements Observer, Runnable {

	private static boolean advGame;
	private static Player player;
	private static Game game;
	private JFrame frame;
	private static String userName;
	
	public View(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
		
		frame= new JFrame("Escape");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public abstract void showGameStatus();
	public abstract void sendToChat(String s);
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof AdvancedGame){
			setGame((AdvancedGame)arg);
			setPlayer(userName);
			this.showGameStatus();
		}else if (arg instanceof Game){
			setGame((Game)arg);
			setPlayer(userName);
			this.showGameStatus();
		}else if (arg instanceof String){
			this.sendToChat((String)arg);
		}else{
			throw new IllegalArgumentException();			
		}
	}
	
	@Override
	public void run() {
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{				
				frame.setVisible(true);
			}
		});
	}

	public static boolean isAdvGame() {
		return advGame;
	}

	public void setAdvGame(boolean advGame) {
		View.advGame = advGame;
	}

	public static Game getGame() {
		return game;
	}

	public static void setGame(Game game) {
		View.game = game;
	}

	public static Player getPlayer() {
		return player;
	}

	public void setPlayer(String name) {
		View.player = game.findFromUsername(name);
	}
	
	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		View.userName = userName;
	}


}
