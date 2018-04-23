package it.ltc.utility.epl.elementi;

import it.ltc.utility.epl.comandi.AsciiText;
import it.ltc.utility.epl.parametri.FONTTYPE;
import it.ltc.utility.epl.parametri.FontSize;
import it.ltc.utility.epl.parametri.REVERSE;
import it.ltc.utility.epl.parametri.ROTATION;

/**
 * Classe che mappa l'elemento titolo ridimensionabile
 * @author Antonio 07 set 2017
 *
 */
public class TitoloRidimensionabile extends Titotlo {

	
	/**
	 * definisce il comando finale
	 */
	AsciiText font = new AsciiText();
	/**
	 * definisce la dimensione del font
	 */
	FontSize fontSize;
	
	/**
	 * variabile utulizzata per il ridimensionamento
	 */
	Integer multiplierH;
	/**
	 * variabile utulizzata per il ridimensionamento
	 */
	Integer multiplierHResized;
	/**
	 * definisce il font minimo da utilizzare
	 */
	FontMinSize fontMin;
	
	/**
	 * Metodo che setta il tipo di font dato il parametro in ingresso
	 * @param size
	 */
	private void setFontType(Integer size) {
		String value = size.toString();
		if (value.equals("1")) {
			font.fontSelection = FONTTYPE.DIM_8x12; 
		}
		else if(value.equals("2")) {
			font.fontSelection = FONTTYPE.DIM_10x16; 
		}
		else if(value.equals("2")) {
			font.fontSelection = FONTTYPE.DIM_10x16; 
		}
		else if(value.equals("3")) {
			font.fontSelection = FONTTYPE.DIM_12x20; 
		}
		else if(value.equals("4")) {
			font.fontSelection = FONTTYPE.DIM_14x24; 
		}
		else if(value.equals("5")) {
			font.fontSelection = FONTTYPE.DIM_32x48; 
		}
		else if(value.equals("6")) {
			font.fontSelection = FONTTYPE.NUMONLY_DIM_14x19_6; 
		}
		else if(value.equals("7")) {
			font.fontSelection = FONTTYPE.NUMONLY_DIM_14x19_7; 
		}
	}
	
	
	
	/**
	 * Costruttore titolo
	 * @param x posizione rispetto all'asse x
	 * @param y posizione rispetto all'asse y
	 * @param h altezza del titolo
	 * @param w larghezza del titolo
	 * @param fontType tipo di font
	 * @param multiplierH moltiplicatore orizzontale del font
	 * @param multiplierV moltiplicatore verticale del font
	 * @param testo
	 * @param rotation
	 * @param reverse
	 */
	public TitoloRidimensionabile(int x, int y, int h, int w, FONTTYPE fontType, Integer multiplierH, Integer multiplierV, String testo, ROTATION rotation, REVERSE reverse) {
		super(x, y, h, w, 0, testo);
		this.size = Integer.parseInt(fontType.getValue());
		this.multiplierH = multiplierH;
		this.multiplierHResized = multiplierH;
		fontSize = new FontSize(fontType.getValue());
		
		font.horizontalStartPosition = x;
		font.verticalStartPosition = y;
		font.rotation = rotation;
		font.fontSelection = fontType;
		
		font.horizontalMultiplier = multiplierH;
		font.verticalMultiplier = multiplierV;
		if (rotation == ROTATION.ROTATED90 || rotation == ROTATION.ROTATED270) {
			font.horizontalMultiplier = multiplierV;
			font.verticalMultiplier = multiplierH;
		}
		font.reverseImage = reverse;
		font.data = testo;
		
		fontMin = new FontMinSize(1,1,1);
	}

	/**
	 * Costruttore titolo
	 * @param x posizione rispetto all'asse x
	 * @param y posizione rispetto all'asse y
	 * @param h altezza del titolo
	 * @param w larghezza del titolo
	 * @param fontType tipo di font
	 * @param multiplierH moltiplicatore orizzontale del font
	 * @param multiplierV moltiplicatore verticale del font
	 * @param testo
	 * @param rotation
	 * @param reverse
	 * @param fontMinSize font minimo utilizzabile
	 */
	public TitoloRidimensionabile(int x, int y, int h, int w, FONTTYPE fontType, Integer multiplierH, Integer multiplierV, String testo, ROTATION rotation, REVERSE reverse, FontMinSize fontMinSize) {
		super(x, y, h, w, 0, testo);
		this.size = Integer.parseInt(fontType.getValue());
		this.multiplierH = multiplierH;
		this.multiplierHResized = multiplierH;
		fontSize = new FontSize(fontType.getValue());
		
		font.horizontalStartPosition = x;
		font.verticalStartPosition = y;
		font.rotation = rotation;
		font.fontSelection = fontType;
		font.horizontalMultiplier = multiplierH;
		font.verticalMultiplier = multiplierV;
		if (rotation == ROTATION.ROTATED90 || rotation == ROTATION.ROTATED270) {
			font.horizontalMultiplier = multiplierV;
			font.verticalMultiplier = multiplierH;
		}
		font.reverseImage = reverse;
		font.data = testo;
		
		fontMin = fontMinSize;
	}
	
	/**
	 * Metodo che effettua il ridimensionamento del font.
	 * Considera la larghezza massima e il font minimo settati per il titolo.
	 */
	private void resizeFont()
	{
		int len = getLength();
		Boolean sizeRedimensioned = true;
		while (len > w && (size > fontMin.getSize() || (multiplierHResized > fontMin.getMultiplierH()-1) && multiplierHResized > 1)) {
			
			if(!sizeRedimensioned) {
				multiplierHResized = multiplierH;
				if (font.rotation == ROTATION.ROTATED90 || font.rotation == ROTATION.ROTATED270) {
					font.verticalMultiplier = multiplierHResized;
				}
				else {
					font.horizontalMultiplier = multiplierHResized;
				}
				
				if(size > fontMin.getSize()){
					sizeRedimensioned = true;
					size--;
					fontSize = new FontSize(size.toString());
					setFontType(size);
				}
			}
			else if (sizeRedimensioned && multiplierHResized > fontMin.getMultiplierH()-1 && multiplierHResized>1) {
				sizeRedimensioned = false;
				
				multiplierHResized--;
				if (font.rotation == ROTATION.ROTATED90 || font.rotation == ROTATION.ROTATED270) {
					font.verticalMultiplier = multiplierHResized;
				}
				else {
					font.horizontalMultiplier = multiplierHResized;
				}
			}
			else if (sizeRedimensioned && multiplierHResized == fontMin.getMultiplierH()) {
				sizeRedimensioned = false;
			}
			
			len = getLength();
		}
		
		if(len > w) {
			while(len > w) {
				testo = testo.substring(0, testo.length()-1);
				len = getLength();
			}
			
			font.data = testo;
		}
	}
	
	/**
	 * Meotodo che permette di calcolare la lunghezza del testo sulla base dei parametri settati.
	 * @return un intero len identifica la lunghezza del testo
	 */
	public Integer getLength() {
		int len = 0;
		int testoLength = testo.length();
		
		int horizontalMultiplier = font.horizontalMultiplier;
		if (font.rotation == ROTATION.ROTATED90 || font.rotation == ROTATION.ROTATED270) {
			horizontalMultiplier = font.verticalMultiplier;
		}
		
		len = (testoLength * fontSize.getW() * horizontalMultiplier) + (testoLength * 2 * horizontalMultiplier); 
		return len;
	}


	@Override
	public String toString() {
		
		resizeFont();
		String value = font.toString();
		
		return value;
	}
	
	
}
