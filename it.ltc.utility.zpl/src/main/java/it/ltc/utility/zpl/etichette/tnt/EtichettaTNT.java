package it.ltc.utility.zpl.etichette.tnt;

import it.ltc.utility.zpl.etichette.Etichetta;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe che estende la classe Etichetta, definisce i campi utilizzati nell'etichetta TNT.
 * @author Antonio 24 ago 2017
 *
 */
public class EtichettaTNT extends Etichetta {

	public String codFilialePartenza;
	
	public String nrColli;
	public String peso;
	
	public String mittente;
	public String destinatario;
	public String indirizzoDest;
	public String localitaDest;
	
	public String numSegnaCollo;
	public String filialeArrivo;
	public String rifMittente;
	public String micorZona;
	public String codFilialeArrivo;
	
	public String dataPartenza;
	public String letteraVettura;
	
	public String servizioPremium;
	public String hub;
	public String fermoDeposito;
	public String speciale;
	
	public String commento;
	public String destinatario2;
	
	public String barcode;	
	
	public EtichettaTNT(int h, int w, Orientation orientation) {
		super(h, w, orientation);
	}
	
}
