/**
 * 
 */
package it.polimi.ingsw.cg_10.view.CLI;

import it.polimi.ingsw.cg_10.view.common.MatchView;
import it.polimi.ingsw.cg_10.view.common.View;

/**
 * @author Francesco
 *
 */

public class MatchCLIView extends MatchView {

	private CLIView cliView;

	public MatchCLIView(boolean advGame) {
		super(advGame);
		cliView = new CLIView();
		setCLIView(cliView);
	}

	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.cg_10.view.View#showGameStatus(it.polimi.ingsw.cg_10.model.game.Game)
	 */
	@Override
	public void showGameStatus() {
		((CLIView) getGameView()).updateCLI(View.getPlayer());
		getChatView().getPlayersView().updatePlayersView(getGame().getPlayerList());
	}

}
