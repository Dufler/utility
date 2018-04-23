package it.ltc.utility.epl.etichette;

import java.util.List;

public class EtichettaImballoPackingList extends Etichetta {

	public String numeroOrdine;
	public String numeroCollo;

	public String totalePezzi;
	
	public List<ProdottoEtichetta> articoli;
	
	public EtichettaImballoPackingList(int h, int w) {
		super(h, w);
	}

}
