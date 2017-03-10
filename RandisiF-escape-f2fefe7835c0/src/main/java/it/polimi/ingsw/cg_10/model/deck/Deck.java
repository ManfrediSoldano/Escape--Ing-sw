package it.polimi.ingsw.cg_10.model.deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import it.polimi.ingsw.cg_10.model.card.*;


public class Deck implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> cardList; 		
	private ArrayList<Card> usedCard;	
	
	public Deck (){
		cardList = new ArrayList<Card>();
		usedCard = new ArrayList<Card>();
	}

	public void refreshDeck() {
		if(!usedCard.isEmpty() && cardList.isEmpty())
		{
			cardList.clear();
			cardList.addAll(usedCard);
			usedCard.clear();
			Collections.shuffle(cardList, new Random(System.nanoTime()));
		}
	}

	public Card drawCard() {
		Card c = cardList.get (cardList.size()-1);
		cardList.remove(cardList.size()-1);
		return c;
	}

	public void useCard(Card c) {
		usedCard.add(c);	
	}
	
	public ArrayList<Card> getCardList() {
		return cardList;
	}
	
	public void setCardList(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}	
	
	public ArrayList<Card> getUsedCard() {
		return usedCard;
	}
	
	public void setUsedCard(ArrayList<Card> usedCard) {
		this.usedCard = usedCard;
	}
}