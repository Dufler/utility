package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.commands.ScalableBitmapFont;
import it.ltc.utility.zpl.parameters.Justify;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe che mappa la tipologia di titolo Scalabile. Utilizza il font 0, font
 * ridimensionabile a piacere. La larghezza del font non è fissa. Utilizzato per
 * campi dove la lunghezza del testo non cambia.
 * 
 * @author Antonio 24 ago 2017
 *
 */
public class TitoloScalable extends Testo {

	//private final FieldType fType;

	public TitoloScalable(int x, int y, int h, int w, String testo, Orientation orientation) {
		super(x, y, h, w, testo, 2, Justify.LEFT, orientation, false, getFont(orientation, h));

		//this.fType = new FieldType(x, y, Justify.LEFT);
	}

	private static ScalableBitmapFont getFont(Orientation orientation, int size) {
		return new ScalableBitmapFont("0", orientation, size, size);
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		//value.append(fType);
		value.append(type);
		value.append(font);
		if (reverse != null)
			value.append(reverse);
		value.append(data);
		return value.toString();
	}

}
