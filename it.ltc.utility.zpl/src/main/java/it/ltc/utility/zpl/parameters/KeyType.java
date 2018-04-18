package it.ltc.utility.zpl.parameters;

/**
 * Identificano le possibili tipologia di stampa del carattere.
 * Vengono usate nella enum <code>Font</code> per identificare in quali possibili modi si possono stampare.
 * @author Damiano
 *
 */
public enum KeyType {
	
	U("Uppercase"),
	L("Lowercase"),
	D("Descenders"),
	OCR_A("OCR-A"),
	OCR_B("OCR-B"),
	SYMBOL("Symbols");
	
	private final String description;
	
	private KeyType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
