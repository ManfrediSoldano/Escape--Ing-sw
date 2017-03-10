package it.polimi.ingsw.cg_10.model.game;

import it.polimi.ingsw.cg_10.model.player.Player;

import java.util.ArrayList;

public class Chat {

	private ArrayList<String> msgList;
	
	public Chat() {
		msgList = new ArrayList<String>();
	}
	
	public void addMsg (String msg, Player player){
		msgList.add( player.getPlayerName() + ": " + msg);
	}
	
	public  ArrayList<String> getMsgList(){
		return msgList;
	}

}
