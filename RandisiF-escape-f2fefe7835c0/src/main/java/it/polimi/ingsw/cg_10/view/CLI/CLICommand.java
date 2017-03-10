package it.polimi.ingsw.cg_10.view.CLI;

public enum CLICommand {

	HELP(1,"HELP","","Help -> see the cmd list"),
	ATTACK(2,"ATTACK","","Attack -> attack your sector"),
	MOVE(3,"MOVE","","Move [Destination] -> move to destination"),
	DRAWSECTORCARD(4,"DRAWSECTORCARD","","DrawSectorCard -> draw a card from sector deck"),
	DRAWOBJECTCARD(5,"DRAWOBJECTCARD","","DrawOjectCard -> draw a card from object deck"),
	USEOBJECTCARD(6,"USEOBJECT","","UseObject [Object] -> use selected object"),
	ENDTURN (7,"FINISHTURN","","FinishTurn -> close your round and go to next player"),
	SHOWGAME(8,"SHOW","","Show -> show zone and player status");
	
	private final int idx;
	private final String string;
	private String param;
	private final String tip;
	
	private CLICommand(int idx, String string, String param,String tip){
		this.idx =idx;
		this.string=string;
		this.setParam(param);
		this.tip=tip;
	}

	public String getString() {
		return string;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public void clrParam(){
		this.setParam("");
	}
	
	public String getTip() {
		return tip;
	}

	public int getIdx() {
		return idx;
	}

}
