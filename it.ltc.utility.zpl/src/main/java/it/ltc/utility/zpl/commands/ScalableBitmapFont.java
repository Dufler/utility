package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.Font;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Comando che specifica il font da utilizzare in un campo di testo.
 * Il font specificato viene usato solo per il singolo comando <bold>^FD</bold> (<code>FieldData</code>) a cui è associato.
 * @author Damiano
 *
 */
public class ScalableBitmapFont extends FontCommand {
	
	public final static int MIN_MULTIPLIER = 1;
	public final static int MAX_MULTIPLIER = 10;
	
	public final static int MIN_VALUE = 10;
	public final static int MAX_VALUE = 32000;
	
	public final static Font DEFAULT_FONT = Font.A;
	
	private final String fontName;
	
	public ScalableBitmapFont(Font font, Orientation orientation, int multiplier) {
		super(getHeight(font, multiplier), getWidth(font, multiplier), orientation);
		this.fontName = font.name();
	}

	public ScalableBitmapFont(String font, Orientation orientation, int height, int width) {
		super(height, width, orientation);
		if (font == null || font.isEmpty())
			font = DEFAULT_FONT.name();
		this.fontName = font;
	}
	
	private static int getHeight(Font font, int multiplier) {
		if (multiplier < MIN_MULTIPLIER)
			multiplier = MIN_MULTIPLIER;
		else if (multiplier > MAX_MULTIPLIER)
			multiplier = MAX_MULTIPLIER;
		if (font == null)
			font = DEFAULT_FONT;
		return multiplier * font.getH();
	}
	
	private static int getWidth(Font font, int multiplier) {
		if (multiplier < MIN_MULTIPLIER)
			multiplier = MIN_MULTIPLIER;
		else if (multiplier > MAX_MULTIPLIER)
			multiplier = MAX_MULTIPLIER;
		if (font == null)
			font = DEFAULT_FONT;
		return multiplier * font.getW();
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^A");
		value.append(fontName);
		value.append(orientation);
		value.append(","); 
		value.append(height);
		value.append(",");
		value.append(width);
		return value.toString();
	}
	
}
