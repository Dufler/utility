package it.ltc.utility.zpl.commands;

/**
 * Calsse che mappa il comando ^FD, invia il testo da stampare.
 * @author Antonio 24 ago 2017
 *
 */
public class FieldData {
	
	/**
	 * identifica il testo da stampare.
	 */
	private final String data;
	
	/**
	 * identifica se il testo è allegato al codice a barre.
	 */
	private final boolean barcode;
	
	/**
	 * indica se è numerico o alfaNumerico.
	 */
	private final boolean allNumeric;
	
	private final FieldSeparetor fs;
	
	/**
	 * Costruttore di default in cui i parametri barcode e allNumeric sono false.
	 * @param dataValue
	 */
	public FieldData(String data) {
		this.data = data;
		this.barcode = false;
		this.allNumeric = false;
		this.fs = new FieldSeparetor();
	}	
	
	/**
	 * Costruttore che permette di specificare tutti i parametri.
	 * @param dataValue
	 * @param barcode
	 * @param allNumeric
	 */
	public FieldData(String data, boolean barcode, boolean allNumeric) {
		this.data = data;
		this.barcode = barcode;
		this.allNumeric = allNumeric;
		this.fs = new FieldSeparetor();
	}

	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^FD");
		if (barcode) {
			value.append(">");
			if (allNumeric)
				value.append(";");
			else
				value.append(":");
		}
		value.append(data);
		value.append(fs);
		return value.toString();
	}
}
