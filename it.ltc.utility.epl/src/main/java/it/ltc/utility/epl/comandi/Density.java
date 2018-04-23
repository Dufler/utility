package it.ltc.utility.epl.comandi;

/**
 * Classe che mappa il comando D, utilizzato per settare la densita di stampa
 * @author Antonio 08 set 2017
 *
 */
public class Density {

	/**
	 * densita di stampa ssume un valore compreso [0-15] deafult 10
	 */
	public String densityValue = "10";

	@Override
	public String toString() {
		return "D" + densityValue;
	}
}
