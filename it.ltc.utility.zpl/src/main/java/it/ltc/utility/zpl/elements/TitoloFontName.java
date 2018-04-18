package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.commands.ChangeInternational;
import it.ltc.utility.zpl.commands.FieldHexadecimal;
import it.ltc.utility.zpl.commands.FontCommand;
import it.ltc.utility.zpl.commands.FontName;
import it.ltc.utility.zpl.parameters.Charset;
import it.ltc.utility.zpl.parameters.Justify;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe che mappa la tipologia di titolo FontName. Utilizza il comando ^A@ per
 * caricare un font dalla stampante. La larghezza del font non è fissa.
 * Utilizzato per campi dove la lunghezza del testo non cambia.
 * 
 * @author Antonio 24 ago 2017
 *
 */
public class TitoloFontName extends Testo {

	public final static Orientation DEFAULT_ORIENTATION = Orientation.NORMAL;
	public final static Justify DEFAULT_JUSTIFY = Justify.LEFT;

	//private final FieldType fType;
	private final ChangeInternational defaultCInter;
	private final ChangeInternational cInter;
	private final FieldHexadecimal fHex;

	public TitoloFontName(int x, int y, int h, int w, String testo) {
		super(x, y, h, w, testo, 2, DEFAULT_JUSTIFY, DEFAULT_ORIENTATION, false, getFont(h));
		this.defaultCInter = new ChangeInternational(Charset.SINGLEBYTE_ITA);
		this.cInter = new ChangeInternational(Charset.SINGLEBYTE_ITA);
		//this.fType = new FieldType(x, y, DEFAULT_JUSTIFY);
		fHex = new FieldHexadecimal();
	}

	private static FontCommand getFont(int size) {
		return new FontName(DEFAULT_ORIENTATION, size, size, FontName.DEFAULT_FONT_NAME);
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		//value.append(fType);
		value.append(type);
		value.append(font);
		value.append(fHex);
		value.append(cInter);
		if (reverse != null)
			value.append(reverse);
		value.append(data);
		value.append(defaultCInter);
		return value.toString();
	}

}
