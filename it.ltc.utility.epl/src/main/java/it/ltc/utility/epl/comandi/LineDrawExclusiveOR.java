package it.ltc.utility.epl.comandi;

/**
 * Classe che mappa il comando LE, utilizzato per disegnare 
 * @author Antonio 08 set 2017
 *
 */
public class LineDrawExclusiveOR {
	/**
	 * posizione x
	 */
	public Integer horizontalPosition;
	/**
	 * posizione y
	 */
	public Integer verticalPosition;
	/**
	 * lunghezza in orizzontale
	 */
	public Integer horizontalLength;
	/**
	 * lunghezza in verticale
	 */
	public Integer verticalLength;
	
	
	@Override
	public String toString() {
		String value = "LE";
		value += horizontalPosition + "," + verticalPosition + "," + horizontalLength + "," + verticalLength; 
		return value;
	}
	
}
