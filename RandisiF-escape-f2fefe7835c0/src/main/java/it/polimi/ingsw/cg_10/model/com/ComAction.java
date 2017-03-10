package it.polimi.ingsw.cg_10.model.com;

import it.polimi.ingsw.cg_10.model.map.Coordinate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Manfredi
 *
 */

public class ComAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * String username
	 */
	private String username;
	
	/**Superclasse di tutti i tipi di comunicazione per il pattern Client/Server.
	 * Ha un atributo stringa chiamato username che rappresenta l'ide dell'utnete inserito nel momento della 
	 * ComFirstConnectio
	 */
	public ComAction()
	{
	
	}
	
	public ComAction(String deser)
	{
		
		this.deserialize(deser);
	}
	
	/**
	 * @return ritorna la stringa della serializzazione dell'ogetto stesso.
	 */
	public String serialize(){
		 try {	     
		     ByteArrayOutputStream bo = new ByteArrayOutputStream();
		     ObjectOutputStream so = new ObjectOutputStream(bo);
		     so.writeObject(this);
		     so.flush();
		     return bo.toString("ISO-8859-1");
		    
		 } catch (Exception e) {
		     System.err.println(e);
		     return null;
		 }
	}
	
	/**
	 * @param scommand: la stringa serializzata
	 * @return ComAction
	 */
	public ComAction deserialize(String scommand){
		 try {
			  byte b[] = scommand.getBytes("ISO-8859-1");  
		      ByteArrayInputStream bi = new ByteArrayInputStream(b);
		      ObjectInputStream si = new ObjectInputStream(bi);
		      ComAction obj = (ComAction) si.readObject();
		      if(obj instanceof ComMove){
		    	  if (((ComMove) obj).getXy().contains("//")) {
						String[] parts = ((ComMove) obj).getXy().split("//");
						Coordinate coordinata = new Coordinate();
						coordinata.setCoordX(Integer.parseInt(parts[0]));
						coordinata.setCoordY(Integer.parseInt(parts[1]));
						((ComMove) obj).setCoordinate(coordinata);
					} 
		    	  
		      }
		      return obj;
		     } catch (Exception e) {
		    	 
		     System.err.println(e);	    
		     return null;
		 }
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param Setta l'username
	 */
	public void setUsername(String username) {
		this.username = username;
	}





}
