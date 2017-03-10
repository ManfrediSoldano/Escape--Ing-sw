package it.polimi.ingsw.cg_10.model.deck;

import it.polimi.ingsw.cg_10.model.card.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.Random;

public class DangerousSectorDeck extends Deck  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7716749183169605541L;
	private static final int MAX_NUM_NYS = 6;
	private static final int MAX_NUM_NYS_OBJ = 4;
	private static final int MAX_NUM_NAS = 6;
	private static final int MAX_NUM_NAS_OBJ = 4;
	private static final int MAX_NUM_SIL = 5;

	public DangerousSectorDeck() {
		super ();
		
		int size = MAX_NUM_NYS; 
		while (getCardList().size() < size)
			getCardList().add(new DangerousSectorCard(DangerousSectorCardType.NOISEYOURSECTOR,false));
		
		size += MAX_NUM_NYS_OBJ; 
		while (getCardList().size() < size)
			getCardList().add(new DangerousSectorCard(DangerousSectorCardType.NOISEYOURSECTOR,true));
			
		size += MAX_NUM_NAS; 
		while (getCardList().size() < size)
			getCardList().add(new DangerousSectorCard(DangerousSectorCardType.NOISEANYSECTOR,false));
			
		size += MAX_NUM_NAS_OBJ; 
		while (getCardList().size() < size)
			getCardList().add(new DangerousSectorCard(DangerousSectorCardType.NOISEANYSECTOR,true));

		size += MAX_NUM_SIL; 
		while (getCardList().size() < size)
			getCardList().add(new DangerousSectorCard(DangerousSectorCardType.NOISEANYSECTOR,false));	
		
		Collections.shuffle(getCardList(), new Random(System.nanoTime()));
	}
}
