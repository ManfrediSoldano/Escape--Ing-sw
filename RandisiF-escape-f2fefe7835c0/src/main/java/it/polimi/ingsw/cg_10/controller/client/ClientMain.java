/**
 * 
 */
package it.polimi.ingsw.cg_10.controller.client;

import it.polimi.ingsw.cg_10.model.com.ComAction;
import it.polimi.ingsw.cg_10.model.com.ComFirstConnection;
import it.polimi.ingsw.cg_10.model.com.ComServerReply;
import it.polimi.ingsw.cg_10.view.CLI.MatchCLIView;
import it.polimi.ingsw.cg_10.view.GUI.MatchGUIView;
import it.polimi.ingsw.cg_10.view.common.StartView;
import it.polimi.ingsw.cg_10.view.common.View;

/**
 * @author Francesco
 *
 */
public class ClientMain{

	private static StartView startView;
	private static View view;
	private static Communication communication;
	private static ComAction comaction;
	private static String userName;
	
	public ClientMain(){
		startView = new StartView();
		comaction = new ComAction();
	}
	
	public static void main(String[] args) {
		ClientMain clientMain = new ClientMain();
		clientMain.run();
	}

	private void run() {
		ClientMain.startView.run();	
	}
	
	public static void initComm(String type){
		communication = new Communication(type);
		communication.getConnection();
	}
	
	public static boolean initUserName(String name) {

		userName = name;
		System.out.println(name);
		comaction = new ComFirstConnection(userName);	
		return ackSend(comaction).isStat();
		
	}
	
	public static ComAction send(ComAction comaction) {
		comaction.setUsername(userName);
		return communication.sendMessage(comaction);
	}
	
	public static AckFromServer ackSend(ComAction comaction){
		
		boolean error = true;
		boolean stat = false;
		String message = "";
		
		ComAction response = send(comaction);
		if (response instanceof ComServerReply) {
			error=false;
			stat=((ComServerReply) response).getConferma();
			message = ((ComServerReply) response).getReply();
		} else {
			error=true;
		}
		
		return new AckFromServer(error,stat, message);
	}

	public static void matchViewStart(boolean cliView, boolean advGame) {
		if(cliView)
			view = new MatchCLIView(advGame);
		else
			view = new MatchGUIView(advGame);
			
		communication.addObserver(view);
		communication.subscribe(userName);
		View.setUserName(userName);
		ClientMain.view.run();	
	}


}
