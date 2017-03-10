package it.polimi.ingsw.cg_10.model.player;

import it.polimi.ingsw.cg_10.controller.socket.BrokerThread;

import java.util.ArrayList;

public class Room {
	private ArrayList<Player> playerlist = new ArrayList<Player>();
	private int ID;
	private BrokerThread bt;
	private Boolean active = true;
	private String mappa="";
	private Boolean advanced= false;
	public Room(int ID)
	{
		this.ID = ID;
		setBt(null);
	}
	
	public void addPlayerToRoom(Player player)
	{
		playerlist.add(player);
	}
	
	public Player playerFromList(int index){
		return playerlist.get(index);
	}
	
	public ArrayList<Player> getArrayList(){
		return playerlist;
	}
	
	public int getID()
	{
		return this.ID;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public BrokerThread getBt() {
		return bt;
	}

	public void setBt(BrokerThread bt) {
		this.bt = bt;
	}

	public String getMappa() {
		return mappa;
	}

	public void setMappa(String mappa) {
		this.mappa = mappa;
	}

	public Boolean getAdvanced() {
		return advanced;
	}

	public void setAdvanced(Boolean advanced) {
		this.advanced = advanced;
	}

	public void setArrayList(ArrayList<Player> playerType) {
		this.playerlist=playerType;
		
	}
	
	public Player findFromUsername(String username){
		for(Player player:playerlist){
			if(player.getPlayerName().equals(username)){
				return player;
			}
		}
		return null;
		
	}

}
