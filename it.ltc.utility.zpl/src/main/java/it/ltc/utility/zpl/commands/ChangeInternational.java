package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.Charset;

/**
 * Classe che mappa il comando ^CI per settare l'insieme di caratteri da
 * utilizzare.
 * 
 * @author Antonio 24 ago 2017
 *
 */
public class ChangeInternational {
	/**
	 * set identifica l'insieme di caratteri definiti in CHARSET
	 */
	private final Charset set;
	/**
	 * source1 charcter output image 0 to 255
	 */
	private final Integer source1;
	/**
	 * destination1 charcter input 0 to 255
	 */
	private final Integer destination1;
	/**
	 * source2 charcter output image 0 to 255
	 */
	private final Integer source2;
	/**
	 * destination2 charcter input 0 to 255
	 */
	private final Integer destination2;
	
	/**
	 * Costruttore di default in cui basta specificare il charset.
	 * source e destination vengono impostati a null e non verranno utilizzati.
	 * @param set il Charset da utilizzare.
	 */
	public ChangeInternational(Charset set) {
		this.set = set;
		source1 = null;
		destination1 = null;
		source2 = null;
		destination2 = null;
	}
	
	/**
	 * Costruttore utilizzato per specificare nel dettaglio tutti i parametri.
	 * @param set il Charset da utilizzare.
	 * @param soruce1
	 * @param destination1
	 * @param source2
	 * @param destination2
	 */
	public ChangeInternational(Charset set, Integer soruce1, Integer destination1, Integer source2,	Integer destination2) {
		this.set = set;
		this.source1 = soruce1;
		this.destination1 = destination1;
		this.source2 = source2;
		this.destination2 = destination2;
	}



	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^CI");
		value.append(set);
		if (source1 != null) {
			value.append(",");
			value.append(source1);
		}
		if (destination1 != null) {
			value.append(",");
			value.append(destination1);
		}
		if (source2 != null) {
			value.append(",");
			value.append(source2);
		}
		if (destination2 != null) {
			value.append(",");
			value.append(destination2);
		}
		return value.toString();
	}

}
