package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.commands.FieldData;
import it.ltc.utility.zpl.commands.FieldReverse;
import it.ltc.utility.zpl.commands.FieldType;
import it.ltc.utility.zpl.commands.FontCommand;
import it.ltc.utility.zpl.commands.ScalableBitmapFont;
import it.ltc.utility.zpl.parameters.Font;
import it.ltc.utility.zpl.parameters.Justify;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe che renderizza un semplice elemento di testo.
 * @author Damiano
 *
 */
public class Testo extends Elemento {
	
	public enum ResizeStrategy { TRUNCATE, DECREASE_SIZE }
	
	public final static Justify DEFAULT_JUSTIFY = Justify.LEFT;
	public final static Orientation DEFAULT_ORIENTATION = Orientation.NORMAL;
	public final static Font DEFAULT_FONT = Font.A;
	public final static int DEFAULT_MINIMUM_MULTIPLIER = 1;
	
	protected final FieldType type;
	protected final FontCommand font;
	protected final FieldData data;
	protected final FieldReverse reverse;
	protected final int minimumMultiplier;
	
	private int multiplier;
	private ResizeStrategy strategy;
	
	public Testo(int x, int y, int h, int w, String value) {
		super(x, y, h, w);
		strategy = ResizeStrategy.DECREASE_SIZE;
		multiplier = 10;
		adjustment(DEFAULT_FONT, value);
		type = new FieldType(x, y, DEFAULT_JUSTIFY);
		font = new ScalableBitmapFont(DEFAULT_FONT, DEFAULT_ORIENTATION, multiplier);
		data = new FieldData(value);
		reverse = null;
		minimumMultiplier = DEFAULT_MINIMUM_MULTIPLIER;
	}
	
	public Testo(int x, int y, int h, int w, String value, Font f, int mm, Orientation o) {
		super(x, y, h, w);
		strategy = ResizeStrategy.DECREASE_SIZE;
		multiplier = 10;
		adjustment(f, value);
		type = new FieldType(x, y, DEFAULT_JUSTIFY);
		font = new ScalableBitmapFont(f, o, multiplier);
		data = new FieldData(value);
		reverse = null;
		minimumMultiplier = mm;
	}
	
	/**
	 * Con questo non vengono fatti aggiustamenti.
	 */
	public Testo(int x, int y, int h, int w, String value, int mm, Justify j, Orientation o, boolean r, FontCommand fontCommand) {
		super(x, y, h, w);
		strategy = ResizeStrategy.DECREASE_SIZE;
		type = new FieldType(x, y, j);
		font = fontCommand;
		data = new FieldData(value);
		reverse = r ? new FieldReverse() : null;
		minimumMultiplier = mm;
	}
	
	protected void adjustment(Font font, String value) {
		int width = calculateWidth(value, font, multiplier);
		int height = calculateHeight(value, font, multiplier);
		while (width > w || height > h) {
			if (strategy == ResizeStrategy.DECREASE_SIZE && multiplier > minimumMultiplier) {
				multiplier = adjustFont(multiplier);
			} else {
				value = adjustText(value);
			}
			width = calculateWidth(value, font, multiplier);
			height = calculateHeight(value, font, multiplier);
		}
	}
	
	protected int calculateWidth(String value, Font font, int multiplier) {
		int width = font.calcolaLarghezza(value, multiplier);
		return width;
	}
	
	protected int calculateHeight(String value, Font font, int multiplier) {
		int height = font.calcolaAltezza(value, multiplier);
		return height;
	}
	
	protected int adjustFont(int multiplier) {
		return multiplier - 1;
	}
	
	protected String adjustText(String value) {
		return value.substring(0, value.length() - 1);
	}
	
	public void setResizeStrategy(ResizeStrategy strategy) {
		if (strategy == null)
			strategy = ResizeStrategy.DECREASE_SIZE;
		this.strategy = strategy;
	}
	
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		//value.append(origin);
		value.append(type);
		value.append(font);
		value.append(data);
		if (reverse != null)
			value.append(reverse);
		value.append(CRLF);
		return value.toString();
	}

}
