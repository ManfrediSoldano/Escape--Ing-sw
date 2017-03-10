package it.polimi.ingsw.cg_10.model.com;


/**
 * @author Manfredi
 *
 */
public class ComUseCard extends ComAction {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int cardIdx;

	/**Com che serve per usare una carta
	 * @param cardIdx id della carta
	 * @param username stringa che rapp. l'utente
	 */
	public ComUseCard(int cardIdx, String username) {
		this.setCardIdx(cardIdx);
		super.setUsername(username);
	}

	/**
	 * @param cardIdx importa la carta
	 */
	public ComUseCard(int cardIdx) {
		this.setCardIdx(cardIdx);
	}

	/**
	 * @return id intero della carta
	 */
	public int getCardIdx() {
		return cardIdx;
	}

	/**
	 * @param cardIdx
	 */
	public void setCardIdx(int cardIdx) {
		this.cardIdx = cardIdx;
	}

}
