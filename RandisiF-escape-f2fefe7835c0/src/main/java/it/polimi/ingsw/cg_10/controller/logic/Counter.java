package it.polimi.ingsw.cg_10.controller.logic;

import it.polimi.ingsw.cg_10.model.game.Game;

public class Counter extends Thread {
	private int time;

	private MatchLogic ml;

	private String username;

	private Game match;



	
	public Counter(int time, MatchLogic ml, String username, Game match){
		this.time=time*1000;
		this.setUsername(username);
		this.ml = ml;
		this.match = match;
	}

	public Counter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {}
		
		ml.endTimeTurn(username, match);

    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
