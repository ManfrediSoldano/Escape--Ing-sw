package it.polimi.ingsw.cg_10.model.deck;

import it.polimi.ingsw.cg_10.model.card.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.Random;

public class ObjectDeck extends Deck implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAX_NUM_ATK = 2;
	private static final int MAX_NUM_TTS = 2;
	private static final int MAX_NUM_ADR = 2;
	private static final int MAX_NUM_SED = 3;
	private static final int MAX_NUM_LIG = 2;
	private static final int MAX_NUM_DEF = 1;
	
	public ObjectDeck() {
		super();
			
			int size = MAX_NUM_ATK; 
			while (getCardList().size() < size)
				getCardList().add(new ObjectCard(ObjectCardType.ATTACK));
			
			size += MAX_NUM_TTS; 
			while (getCardList().size() < size)
				getCardList().add(new ObjectCard(ObjectCardType.TELEPORT));
			
			size += MAX_NUM_ADR; 
			while (getCardList().size() < size)
				getCardList().add(new ObjectCard(ObjectCardType.SEDATIVES));
			
			size += MAX_NUM_SED; 
			while (getCardList().size() < size)
				getCardList().add(new ObjectCard(ObjectCardType.SPOTLIGHT));
			
			size += MAX_NUM_LIG; 
			while (getCardList().size() < size)
				getCardList().add(new ObjectCard(ObjectCardType.DEFENSE));
			
			size += MAX_NUM_DEF; 
			while (getCardList().size() < size)
				getCardList().add(new ObjectCard(ObjectCardType.ADRENALINE));
			
			Collections.shuffle(getCardList(), new Random(System.nanoTime()));
	}
}
