package it.polimi.ingsw.cg_10.model.deck;

import it.polimi.ingsw.cg_10.model.card.*;

import java.util.Collections;
import java.util.Random;

public class EscapeHatchDeck extends Deck{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAX_NUM_GREEN=3;
	private static final int MAX_NUM_RED = 3;
	
	public EscapeHatchDeck() {
		super();
		
		int size = MAX_NUM_GREEN; 
		while (getCardList().size() < size)
			getCardList().add(new EscapeHatchCard(EscapeHatchCardType.GREEN));
		
		size += MAX_NUM_RED; 
		while (getCardList().size() < size)
			getCardList().add(new EscapeHatchCard(EscapeHatchCardType.RED));
			
		Collections.shuffle(getCardList(), new Random(System.nanoTime()));
	}

}

