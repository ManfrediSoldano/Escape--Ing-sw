package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.view.common.MatchView;


public class MatchGUIView extends MatchView {

	private GUIView guiView;
	
	public MatchGUIView(boolean advGame){
		super(advGame);
		guiView = new GUIView();
		setGUIView(guiView);	
	}

	@Override
	public void showGameStatus() {
		((GUIView) getGameView()).getMapView().updateMap(getGame().getZone().getSectors());
		//((GUIView) getGameView()).getMapView().updatePlayerPosition(getPlayer());
		((GUIView) getGameView()).getPlayerPane().updatePlayerPane(getPlayer());
		((GUIView) getGameView()).getMovementRecordView().updateMovementRecord(getPlayer());
		((GUIView) getGameView()).getPlayerPane().updateButton(getPlayer());
		((GUIView) getGameView()).getDeckView().updateButton(getPlayer());
		((GUIView) getGameView()).getRoundView().update(getPlayer());
		getChatView().getPlayersView().updatePlayersView(getGame().getPlayerList());
		
	}

}
