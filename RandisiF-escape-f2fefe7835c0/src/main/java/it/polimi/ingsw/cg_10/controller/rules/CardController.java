package it.polimi.ingsw.cg_10.controller.rules;


import it.polimi.ingsw.cg_10.model.card.DangerousSectorCard;
import it.polimi.ingsw.cg_10.model.card.EscapeHatchCard;
import it.polimi.ingsw.cg_10.model.card.ObjectCardType;
import it.polimi.ingsw.cg_10.model.game.AdvancedGame;
import it.polimi.ingsw.cg_10.model.game.Game;
import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.Player;

/**
 * @author Francesco
 *
 */
public class CardController {

	
	/**
	 * @param match Il gioco da passare
	 * @param player Il giocatore a cui applicare
	 * @param objCardIdx Index della carta
	 * @return True/false: tre se ha avuto successo, false altrimenti
	 */
	public static boolean useObjCard(Game match, Player player, int objCardIdx) {
		boolean retValue = false;
		if(player instanceof Human && match instanceof AdvancedGame){
			if(player.getObjOwned().getCardList().get(objCardIdx).getObjType() != ObjectCardType.DEFENSE){
				retValue = CardEffect.objectCardEffect(player.getObjOwned().getCardList().get(objCardIdx), match, player);
				player.getObjOwned().removeCardFromHand(player.getObjOwned().getCardList().get(objCardIdx) , ((AdvancedGame)match).getObjectDeck());
			}
			
		}
		return retValue;
	}
	
	

	public static void escapeHatchCard(Player player, Game match) {
		EscapeHatchCard escapeHatchCard = (EscapeHatchCard) ((AdvancedGame)match).getEscapeHatchDeck().drawCard();
		CardEffect.escapeHatchSectorCardEffect(escapeHatchCard, player, match);	
	}

	public static void checkDecks (Game match){
		
		match.getDangerousSectorDeck().refreshDeck();
		
		if(match instanceof AdvancedGame){
			((AdvancedGame) match).getObjectDeck().refreshDeck();
		}
	}


	public static boolean dangerousCard(Player player, Game match) {
		DangerousSectorCard dangerousSectorCard = (DangerousSectorCard) match.getDangerousSectorDeck().drawCard();
		boolean retValue=CardEffect.dangerousSectorCardEffect(dangerousSectorCard, player, match);
		if(match instanceof AdvancedGame){
			if(dangerousSectorCard.isItemIcon()){
				player.getObjOwned().addCardToHand(((AdvancedGame)match).getObjectDeck());
			}
		}
		return retValue;
	}
}
