package it.ltc.utility.epl.etichette;

import it.ltc.utility.epl.elementi.Barcode;
import it.ltc.utility.epl.elementi.Elemento;
import it.ltc.utility.epl.elementi.FontMinSize;
import it.ltc.utility.epl.elementi.LineaOrizzontale;
import it.ltc.utility.epl.elementi.TitoloRidimensionabile;
import it.ltc.utility.epl.parametri.BARCODETYPE;
import it.ltc.utility.epl.parametri.FONTTYPE;
import it.ltc.utility.epl.parametri.READABLE;
import it.ltc.utility.epl.parametri.REVERSE;
import it.ltc.utility.epl.parametri.ROTATION;

public class EtichettaImballoPackingList_10x12 extends EtichettaImballoPackingList {

	public EtichettaImballoPackingList_10x12(int h, int w) {
		super(h, w);
	}
	
	public void EtichettaImballoPackingList_10x12Init(Boolean printBarcode) {
		ROTATION orientation = ROTATION.NORMAL;
		int w = this.getW();
		w = w-10;
		
		int initX = 40;
		
		FontMinSize fontMin = new FontMinSize(2, 1, 2);
		Elemento numOrdine = new TitoloRidimensionabile(initX, 5, 0, w-initX, FONTTYPE.DIM_10x16, 1, 2,
				"PK LIST Nr. " + numeroOrdine + "BOX " + numeroCollo, orientation, REVERSE.NORMAL, fontMin);
		addElemento(numOrdine);
		
		Elemento totPezzi = new TitoloRidimensionabile(initX, 50, 0, w-initX, FONTTYPE.DIM_10x16, 1, 2,
				"Totale pz. " + totalePezzi, orientation, REVERSE.NORMAL, fontMin);
		addElemento(totPezzi);
		
		int count = 0;
		for(ProdottoEtichetta prodotto : articoli) {
			if(count == 10) {
				break;
			}
			
			int offset = 100 * count;
			Elemento articolo = new TitoloRidimensionabile(initX, 100+offset, 0, 686-initX, FONTTYPE.DIM_10x16, 1, 2,
					prodotto.codiceArticolo + "T. " + prodotto.taglia, orientation, REVERSE.NORMAL, fontMin);
			addElemento(articolo);
			if(!printBarcode) {
				Elemento colArticolo = new TitoloRidimensionabile(initX, 140+offset, 0, w-initX, FONTTYPE.DIM_10x16, 1, 1,
						prodotto.colore, orientation, REVERSE.NORMAL);
				addElemento(colArticolo);
				Elemento descrArticolo = new TitoloRidimensionabile(initX, 165+offset, 0, w-initX, FONTTYPE.DIM_10x16, 1, 1,
						prodotto.descrizione, orientation, REVERSE.NORMAL);
				addElemento(descrArticolo);
			} else {
				Elemento descrArticolo = new TitoloRidimensionabile(initX, 140+offset, 0, w-initX, FONTTYPE.DIM_10x16, 1, 1,
						prodotto.descrizione, orientation, REVERSE.NORMAL);
				addElemento(descrArticolo);
				Elemento barcode = new Barcode(initX, 165+offset, 20, 3, prodotto.barcode, orientation, BARCODETYPE.CODE128_AUTO, READABLE.NO);
				addElemento(barcode);
			}
			
			Elemento qta = new TitoloRidimensionabile(686, 100+offset, 0, w-686, FONTTYPE.DIM_12x20, 2, 2,
					prodotto.quantita, orientation, REVERSE.NORMAL);
			addElemento(qta);
			Elemento linea = new LineaOrizzontale(20, 190+offset, 2, 770);
			addElemento(linea);
			
			count++;
		}
		
		
	}
	

}
