package it.polimi.ingsw.cg_10.controller.rules;


import it.polimi.ingsw.cg_10.model.card.DangerousSectorCard;
import it.polimi.ingsw.cg_10.model.card.EscapeHatchCard;
import it.polimi.ingsw.cg_10.model.card.ObjectCard;
import it.polimi.ingsw.cg_10.model.game.AdvancedGame;
import it.polimi.ingsw.cg_10.model.game.Game;
import it.polimi.ingsw.cg_10.model.map.EscapeHatchSector;
import it.polimi.ingsw.cg_10.model.map.HumanSector;
import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.Player;

public class CardEffect {

	
	public static boolean dangerousSectorCardEffect(DangerousSectorCard dangerousSectorCard, Player player, Game match) {
		boolean retValue=false;
		switch (dangerousSectorCard.getDSCType()){
		
			case NOISEYOURSECTOR:
				match.setToPublish(player.getPlayerName()+": Rumore in settore " + player.getMovementRec().getLastPlayerRecord().getPosition().toString());
				retValue=false;
				break;
			
			case NOISEANYSECTOR:
				retValue=true;
				break;
			
			case SILENCE:
				match.setToPublish("Silenzio");
				retValue=false;
				break;
		}
		return retValue;
		
	}
	
	public static boolean objectCardEffect(ObjectCard objectCard, Game match, Player player) {
		boolean retValue= false;
		switch (objectCard.getObjType()){
		
			case ATTACK:
				GameController.attackPhase();
			break;
			
			case TELEPORT:
				player.getMovementRec().getLastPlayerRecord().setPosition(match.getZone().getSpecificSector(new HumanSector()).get(0));
			break;
			
			case ADRENALINE:
				((Human) player).setAdrenaline(true);
			break;
			
			case SEDATIVES:
				((Human) player).setSedative(true);
			break;
			
			case SPOTLIGHT:
				retValue=true; //richiesta settore
			break;
			
			case DEFENSE:
			break;
			
		}
		return retValue;
		
	}
	
	public static boolean checkDefenseCard(Game match, Player player) {
		for (int i=0; i<player.getObjOwned().getCardList().size();i++){
			if(player.getObjOwned().getCardList().get(i).getObjType().name() == "DEFENSE"){
				match.setToPublish("Giocatore "+player.getPlayerName()+" salvato grazie alla carta difesa");
				player.getObjOwned().removeCardFromHand(player.getObjOwned().getCardList().get(i), ((AdvancedGame)match).getObjectDeck());
				return true;
			}
		}
		return false;
	}
	
	public static void escapeHatchSectorCardEffect(EscapeHatchCard escapeHatchCard, Player player, Game match) {
		switch (escapeHatchCard.getEHCType()){
			case RED:
				((EscapeHatchSector)player.getMovementRec().getLastPlayerRecord().getPosition()).setOpen(false);
			break;
				
			case GREEN:
				((Human)player).setSave(true);
			break;
		}
	}
}
