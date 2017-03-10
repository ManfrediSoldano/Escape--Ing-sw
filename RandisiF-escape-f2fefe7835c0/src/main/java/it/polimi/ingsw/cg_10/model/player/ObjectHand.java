package it.polimi.ingsw.cg_10.model.player;

import it.polimi.ingsw.cg_10.model.card.ObjectCard;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Francesco
 *
 */

public class ObjectHand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ObjectCard> cardList;
	
	private static final int MAX_NUM_OBJCARD = 3;
	
	public ObjectHand (){
		cardList = new ArrayList<ObjectCard>();
	}
	
	public int numObjOwned (){
		return cardList.size();
	}
	

	public void addCardToHand (ObjectDeck objDeck){
		if (isFull())
			removeCardFromHand(this.getCardList().get((new Random()).nextInt(2)), objDeck);
			
		cardList.add((ObjectCard) objDeck.drawCard());		
	}	
	public void removeCardFromHand (ObjectCard c, ObjectDeck objDeck){
		if(cardList.contains(c)){
			objDeck.useCard(c);			
			cardList.remove(c);
		}
	}

	public ArrayList<ObjectCard> getCardList() {
		return cardList;
	}

	public boolean isFull() {
		if(numObjOwned() < MAX_NUM_OBJCARD)
			return false;
		return true;
	}
	
	
}
