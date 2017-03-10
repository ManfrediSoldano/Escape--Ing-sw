/**
 * 
 */
package it.polimi.ingsw.cg_10.view.CLI;

import it.polimi.ingsw.cg_10.controller.client.ClientMain;
import it.polimi.ingsw.cg_10.model.com.ComAttack;
import it.polimi.ingsw.cg_10.model.com.ComDrawCard;
import it.polimi.ingsw.cg_10.model.com.ComEndTurn;
import it.polimi.ingsw.cg_10.model.com.ComMove;
import it.polimi.ingsw.cg_10.model.com.ComNoise;
import it.polimi.ingsw.cg_10.model.com.ComUseCard;
import it.polimi.ingsw.cg_10.model.deck.DangerousSectorDeck;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;
import it.polimi.ingsw.cg_10.model.map.Coordinate;
import it.polimi.ingsw.cg_10.model.map.Sector;
import it.polimi.ingsw.cg_10.view.common.View;

import java.util.ArrayList;

/**
 * @author Francesco
 *
 */
public class CLIResponse {


	public static void CLIResp (String cmd){

		String command="";
		String param ="";
		ArrayList<String> risposte = new ArrayList<String>();
		
		if(View.getGame().getPossibiliAzioni().isReqNoise()){
			waitForNoise(cmd);
			return;
		}
		if(View.getGame().getPossibiliAzioni().isReqLight()){
			waitForLight(cmd);
			return;
		}
			
			
		if(cmd.indexOf(" ") != -1){
			command = cmd.substring(0, cmd.indexOf(" "));
			if(!cmd.endsWith(" "))
				param = cmd.substring(cmd.indexOf(" ")+1);
		}else
			command = cmd;
		
		
		CLICommand cliCmd = null;
		for (CLICommand cliCommand : CLICommand.values()) {
			if(cliCommand.getString().equals(command)){
				cliCmd=cliCommand;		
				break;
			}
		}
		 
		if(cliCmd== null)
			risposte.add("Invalid command");
		else{
			switch (cliCmd){
				case HELP:
					for ( CLICommand c : CLICommand.values()) 
						risposte.add(c.getTip());
				break;
				
				case ATTACK:
					if(View.getGame().getPossibiliAzioni().isAttacco())
						ClientMain.ackSend(new ComAttack(View.getPlayer().getMovementRec().getLastPlayerRecord().getPosition().getSectorID()));
					else
						risposte.add("Invalid command");
				break;
				
				case MOVE:
					if(View.getGame().getPossibiliAzioni().isMossa()){
						param = checkParam(param);
						if(param != null){
							ClientMain.ackSend(new ComMove(Coordinate.fromStringToCoordinate(param)));
						}else
							risposte.add("Invalid coordinate (move [XXX])");
					}else
						risposte.add("Invalid command");
				break;
				
				case DRAWSECTORCARD:
					if(View.getGame().getPossibiliAzioni().isCartaSec()){
					ClientMain.ackSend(new ComDrawCard(new DangerousSectorDeck()));
					}else
						risposte.add("Invalid command");
				break;
				
				case DRAWOBJECTCARD:
					if(View.getGame().getPossibiliAzioni().isCartaObj()){
						ClientMain.ackSend(new ComDrawCard(new ObjectDeck()));
					}else
						risposte.add("Invalid command");
				break;
				
				case USEOBJECTCARD:
					if(View.getGame().getPossibiliAzioni().isCartaObjUse()){
						int x = Character.getNumericValue(param.charAt(0));
						ClientMain.ackSend(new ComUseCard(x));
					}else
						risposte.add("Invalid command");
				break;
				
				case ENDTURN:		
					if(View.getGame().getPossibiliAzioni().isFineturno()){
						ClientMain.ackSend(new ComEndTurn());
					}else
						risposte.add("Invalid command");
				break;
				
				case SHOWGAME:
					risposte.add(View.getGame().toString());
				break;
		
				default:
					risposte.add("Invalid command");
				break;
			}
		}
		
		CLIView.sendStringsMex(risposte);	
	}

	private static void waitForNoise(String cmd) {
		Coordinate sec= waitforSector(cmd);
		if (sec!=null){
			ClientMain.ackSend(new ComNoise(sec));
		}
		
	}

	private static void waitForLight(String cmd) {
		Coordinate sec= waitforSector(cmd);
		if (sec!=null){
			for (Sector s : View.getGame().getZone().getSectors()) {
				if(s.getSectorID() == sec){
					ClientMain.ackSend(new ComNoise(s));
					return;
				}
			}
		}
	}

	private static Coordinate waitforSector(String cmd) {
		cmd = checkParam(cmd);
		if(cmd != null)
			return Coordinate.fromStringToCoordinate(cmd);
		else
			CLIView.appendMessage("Invalid command (right format: [XXX])");
		return null;
	}

	private static String checkParam(String param) {
		if(param.length()==5){
			if (param.startsWith("[") && param.endsWith("]")){
				return param.substring(1, 4);
			}
		}
		return null;
		
	}
	

		
}
