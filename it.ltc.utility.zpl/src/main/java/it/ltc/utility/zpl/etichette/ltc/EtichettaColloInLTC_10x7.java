package it.ltc.utility.zpl.etichette.ltc;

import it.ltc.utility.zpl.elements.Barcode;
import it.ltc.utility.zpl.elements.BoxGrafico;
import it.ltc.utility.zpl.elements.Elemento;
import it.ltc.utility.zpl.parameters.Justify;
import it.ltc.utility.zpl.parameters.Orientation;
import it.ltc.utility.zpl.parameters.YesNo;

/**
 * La dimensione standard dell'etichetta in dots è H=812, W=609.
 * L'array di prodotti con cui la si istanzia può contenerne al massimo 6.
 * 
 * @author Damiano
 *
 */
public class EtichettaColloInLTC_10x7 extends EtichettaColloInLTC {

	private static final int width = 812;
	private static final int height = 609;

	private final static Orientation orientation = Orientation.ROTATED270;

	private static final int sizeIntestazione = 25;
	private static final int sizeCodArticolo = 18;
	private static final int sizeTaglia = 18;
	private static final int sizeDescr = 18;
	private static final int sizeQta = 18;
	
	public EtichettaColloInLTC_10x7(String cliente, String packing, String barcode, String ubicazione, String numeroCollo, ProdottoEtichetta[] prodotti, Integer totaleComplessivo) {
		super(height, width, orientation, cliente, packing, barcode, ubicazione, numeroCollo, prodotti, totaleComplessivo);

		int yInit = 600;
		int yInitBox = yInit - 20;
		int yInitBarcode = yInit - 40;

		//Barcode collo
		Elemento barcodeElement = new Barcode(140, yInitBarcode, 60, 3, barcode, 3.0, Justify.LEFT, orientation, YesNo.YES,	YesNo.NO, false);
		addElemento(barcodeElement);

		//Cliente
		addBitmapTextElement(33, yInit, 30, yInit, cliente, 1);
		
		//Packing List
		addBitmapTextElement(73, yInit, 30, yInit, packing, 1);

		//Info prodotti
		BoxGrafico gBox = new BoxGrafico(188, 24, yInitBox, 1, 2);
		addElemento(gBox);
		addScalableTextElement(185, yInit, sizeIntestazione, sizeIntestazione, "Articolo");
		addScalableTextElement(185, 161, sizeIntestazione, sizeIntestazione, "Taglia");
		addScalableTextElement(185, 82, sizeIntestazione, sizeIntestazione, "Q.ta");
		
		//Prodotti
		int count = 0;
		for (ProdottoEtichetta prodotto : articoli) {
			if (prodotto != null) {
				int offset = 80 * count;

				addBitmapTextElement(215 + offset, yInit, sizeCodArticolo, 380, prodotto.getCodiceArticolo(), 1);
				addBitmapTextElement(218 + offset, 145, sizeTaglia, sizeTaglia * 3, prodotto.getTaglia(), 1);
				addBitmapTextElement(242 + offset, 82, sizeQta, sizeQta * 3, Integer.toString(prodotto.getQuantita()), 1);
				addBitmapTextElement(258 + offset, yInit, sizeDescr, 450, prodotto.getDescrizione(), 1);
				
				BoxGrafico linea = new BoxGrafico(267 + offset, 24, yInitBox, 1, 1);
				addElemento(linea);

				count++;
			}
		}

		int xFooter = 698;
		
		//Totale
		addScalableTextElement(xFooter, 161, 20, 25, "tot.");
		String totale = Integer.toString(quantitaTotale);
		if (totaleComplessivo != null)
			totale += " / " + totaleComplessivo.toString();
		addBitmapTextElement(xFooter, 125, 30, 100, totale, 1);
		

		//Ubicazione
		addBitmapTextElement(xFooter, yInit, 40, 380, ubicazioneProposta, 1);

		//Numero collo
		addScalableTextElement(781, 497, 79, 79, numeroCollo);
	}

}
