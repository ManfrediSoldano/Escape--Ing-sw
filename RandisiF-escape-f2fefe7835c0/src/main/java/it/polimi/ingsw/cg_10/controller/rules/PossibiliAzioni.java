package it.polimi.ingsw.cg_10.controller.rules;

import java.io.Serializable;

public class PossibiliAzioni implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean cartaObjUse = false;
	private boolean cartaObj = false;
	private boolean cartaSec = false;
	private boolean mossa = false;
	private boolean attacco = false;
	private boolean fineturno = false;
	private boolean reqNoise= false;
	private boolean reqLight= false;
	
	public boolean isCartaObjUse() {
		return cartaObjUse;
	}
	public void setCartaObjUse(boolean cartaObjUse) {
		this.cartaObjUse = cartaObjUse;
	}
	public boolean isCartaObj() {
		return cartaObj;
	}
	public void setCartaObj(boolean cartaObj) {
		this.cartaObj = cartaObj;
	}
	public boolean isCartaSec() {
		return cartaSec;
	}
	public void setCartaSec(boolean cartaSec) {
		this.cartaSec = cartaSec;
	}
	public boolean isMossa() {
		return mossa;
	}
	public void setMossa(boolean mossa) {
		this.mossa = mossa;
	}
	public boolean isAttacco() {
		return attacco;
	}
	public void setAttacco(boolean attacco) {
		this.attacco = attacco;
	}
	public boolean isFineturno() {
		return fineturno;
	}
	public void setFineturno(boolean fineturno) {
		this.fineturno = fineturno;
	}


	public boolean isReqNoise() {
		return reqNoise;
	}
	public void setReqNoise(boolean reqNoise) {
		this.reqNoise = reqNoise;
	}
	public boolean isReqLight() {
		return reqLight;
	}
	public void setReqLight(boolean reqLight) {
		this.reqLight = reqLight;
	}
	public void phase(int phase, boolean objUsed) {
		setCartaObjUse(objUsed);
		switch (phase){
		
			case 0:
				setMossa(true);
				setAttacco(false);
				setCartaSec(false);
				setCartaObj(objUsed);
				setFineturno(false);	
				setReqNoise(false);
				setReqLight(false);
				break;
				
			case 1:
				setMossa(false);
				setAttacco(true);
				setCartaSec(true);
				setCartaObj(objUsed);
				setFineturno(false);	
				setReqNoise(false);
				setReqLight(false);
				break;
				
			case 2:
				setMossa(false);
				setAttacco(false);
				setCartaSec(true);
				setCartaObj(objUsed);
				setFineturno(false);
				setReqNoise(false);
				setReqLight(false);
				break;
				
			case 3:
				setMossa(false);
				setAttacco(true);
				setCartaSec(false);
				setCartaObj(objUsed);
				setFineturno(true);
				setReqNoise(false);
				setReqLight(false);
				break;
				
			case 4:
				setMossa(false);
				setAttacco(false);
				setCartaSec(false);
				setCartaObj(objUsed);
				setFineturno(true);	
				setReqNoise(false);
				setReqLight(false);
				break;
				
			case 5:
				setMossa(false);
				setAttacco(false);
				setCartaSec(false);
				setCartaObj(false);
				setFineturno(false);	
				setReqNoise(true);
				setReqLight(false);
				break;
				
			case 6:
				setMossa(false);
				setAttacco(false);
				setCartaSec(false);
				setCartaObj(false);
				setFineturno(false);	
				setReqNoise(false);
				setReqLight(true);
				break;
				
				
				//fase 0 muoviti
				//fase 1 attacca o pesca
				//fase 2 pesca
				//fase 3 attacca o fine
				//fase 4 fineturno
				//fase 5 richiedi dove fare rumore
				//fase 6 richiedi dove fare luce
				
		}
		
	}
	

	
}
