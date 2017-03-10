/**
 * 
 */
package it.polimi.ingsw.cg_10.view.GUI;

import it.polimi.ingsw.cg_10.view.common.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

/**
 * @author Francesco
 *
 */
public class GUIView extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlayerPane playerPane;
	private RoundView roundView;
	private MovementRecordView movementRecordView;
	private DeckView deckView;
	private MapView mapView;
	
	public GUIView(){
		super();
		setPreferredSize(new Dimension(1300, 600));
		setMinimumSize(new Dimension(1300, 600));
		setBackground(Color.BLACK);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 380, 380, 23, 200, 0};
		gridBagLayout.rowHeights = new int[]{10, 400, 180, 10, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		playerPane = new PlayerPane(View.isAdvGame());
		GridBagConstraints gbc_playerPane = new GridBagConstraints();
		gbc_playerPane.fill = GridBagConstraints.BOTH;
		gbc_playerPane.gridwidth = 1;
		gbc_playerPane.gridheight = 1;
		gbc_playerPane.insets = new Insets(0, 0, 5, 5);
		gbc_playerPane.gridx = 0;
		gbc_playerPane.gridy = 1;
		add (playerPane, gbc_playerPane);
		
		roundView = new RoundView();
		GridBagConstraints gbc_roundView = new GridBagConstraints();
		gbc_roundView.fill = GridBagConstraints.BOTH;
		gbc_roundView.gridwidth = 1;
		gbc_roundView.gridheight = 1;
		gbc_roundView.insets = new Insets(0, 0, 5, 5);
		gbc_roundView.gridx = 0;
		gbc_roundView.gridy = 2;
		add (roundView, gbc_roundView);
		
		movementRecordView = new MovementRecordView();
		GridBagConstraints gbc_movementRecordView = new GridBagConstraints();
		gbc_movementRecordView.fill = GridBagConstraints.BOTH;
		gbc_movementRecordView.gridwidth = 1;
		gbc_movementRecordView.gridheight = 1;
		gbc_movementRecordView.insets = new Insets(0, 0, 5, 0);
		gbc_movementRecordView.gridx = 4;
		gbc_movementRecordView.gridy = 2;
		add (movementRecordView, gbc_movementRecordView);
		
		deckView = new DeckView(View.isAdvGame());
		GridBagConstraints gbc_deckView = new GridBagConstraints();
		gbc_deckView.fill = GridBagConstraints.BOTH;
		gbc_deckView.gridwidth = 1;
		gbc_deckView.gridheight = 1;
		gbc_deckView.insets = new Insets(0, 0, 5, 0);
		gbc_deckView.gridx = 4;
		gbc_deckView.gridy = 1;
		add (deckView, gbc_deckView);
	
		mapView = new MapView(0,0,600,16,25);
		mapView.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_mapView = new GridBagConstraints();
		gbc_mapView.fill = GridBagConstraints.BOTH;
		gbc_mapView.gridwidth = 3;
		gbc_mapView.gridheight = 2;
		gbc_mapView.insets = new Insets(0, 0, 5, 5);
		gbc_mapView.gridx = 1;
		gbc_mapView.gridy = 1;
		add (mapView, gbc_mapView);
		mapView.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		mapView.setVisible(true);
		mapView.repaint();	
	}
	
	
	public PlayerPane getPlayerPane() {
		return playerPane;
	}

	public void setPlayerPane(PlayerPane playerPane) {
		this.playerPane = playerPane;
	}

	public RoundView getRoundView() {
		return roundView;
	}

	public void setRoundView(RoundView roundView) {
		this.roundView = roundView;
	}

	public MovementRecordView getMovementRecordView() {
		return movementRecordView;
	}

	public void setMovementRecordView(MovementRecordView movementRecordView) {
		this.movementRecordView = movementRecordView;
	}

	public DeckView getDeckView() {
		return deckView;
	}

	public void setDeckView(DeckView deckView) {
		this.deckView = deckView;
	}

	public MapView getMapView() {
		return mapView;
	}

	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}


}
