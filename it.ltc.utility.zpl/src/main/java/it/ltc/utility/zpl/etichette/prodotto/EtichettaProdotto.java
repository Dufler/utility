package it.ltc.utility.zpl.etichette.prodotto;

import it.ltc.utility.zpl.etichette.Etichetta;
import it.ltc.utility.zpl.parameters.Orientation;

public abstract class EtichettaProdotto extends Etichetta {
	
	protected final InfoProdotto info;

	public EtichettaProdotto(int h, int w, Orientation orientation, InfoProdotto info) {
		super(h, w, orientation);
		this.info = info;
	}

}
