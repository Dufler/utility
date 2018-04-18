package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.Drive;
import it.ltc.utility.zpl.parameters.Extension;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * CLasse che mappa il comando ^A@, permette di caricare un font
 * @author Antonio 24 ago 2017
 *
 */
public class FontName extends FontCommand {
	
	public static final Orientation DEFAULT_ORIENTATION = Orientation.NORMAL;
	public static final Drive DEFAULT_DRIVE = Drive.R;
	public static final Extension DEFAULT_EXTENSION = Extension.FONT;
	public static final String DEFAULT_FONT_NAME = "TT0003M_";
    
	/**
     * fieldOrientation identifica l'orientamento , assume un valore definito in <code>Orientation</code>.
     */
	private final Orientation fieldOrientation;
	
	/**
	 * characterHeight identifica la dimensione del font in altezza.
	 */
	private final int characterHeight;
	
	/**
	 * characterWidth identifica la dimensione del font in larghezza.
	 */
	private final int characterWidth;
	
	/**
	 * drivelocation identifica il drive da cui caricare il font, assume uno dei valori in <code>Drive</code>.
	 */
	private final Drive driveLocation;
	
	/**
	 * fontName identifica il nome del font.
	 */
	private final String fontName;
	
	/**
	 * extension identifica l'estensione del font, assume uno dei valori definiti in <code>Extension</code>.
	 */
	private final Extension extension;
	
	/**
	 * Costruttore di default.
	 * I parametri Drive e Extension legati al font vengono impostati a null e non utilizzati.
	 * @param fieldOrientation l'orientamento
	 * @param characterHeight l'altezza
	 * @param characterWidth la larghezza
	 * @param fontName il nome del font
	 */
	public FontName(Orientation fieldOrientation, int characterHeight, int characterWidth, String fontName) {
		super(characterHeight, characterWidth, fieldOrientation);
		this.fieldOrientation = checkOrientation(fieldOrientation);
		this.characterHeight = characterHeight;
		this.characterWidth = characterWidth;
		this.driveLocation = null;
		this.fontName = checkFontName(fontName);
		this.extension = null;
	}

	/**
	 * Costruttore che permette di specificare tutti i parametri.
	 * @param fieldOrientation l'orientamento
	 * @param characterHeight l'altezza
	 * @param characterWidth la larghezza
	 * @param driveLocation la posizione dove è salvato il font
	 * @param fontName il nome del font
	 * @param extension il tipo di font
	 */
	public FontName(Orientation fieldOrientation, int characterHeight, int characterWidth, Drive driveLocation,	String fontName, Extension extension) {
		super(characterHeight, characterWidth, fieldOrientation);
		this.fieldOrientation = checkOrientation(fieldOrientation);
		this.characterHeight = characterHeight;
		this.characterWidth = characterWidth;
		this.driveLocation = driveLocation;
		this.fontName = checkFontName(fontName);
		this.extension = extension;
	}

	private Orientation checkOrientation(Orientation fieldOrientation) {
		if (fieldOrientation == null)
			fieldOrientation = DEFAULT_ORIENTATION;
		return fieldOrientation;
	}
	
	private String checkFontName(String fontName) {
		if (fontName == null || fontName.isEmpty())
			fontName = DEFAULT_FONT_NAME;
		return fontName;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^A@");
		value.append(fieldOrientation.getValue());
		value.append(",");
		value.append(characterHeight);
		value.append(",");
		value.append(characterWidth);
		value.append(",");
		if (driveLocation != null) {
			value.append(driveLocation);
			value.append(":");
		}
		value.append(fontName);
		if (extension != null) {
			value.append(".");
			value.append(extension);
		}
		return value.toString();
	}
	
	
}
