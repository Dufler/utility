package it.ltc.utility.epl.etichette;

/**
 * Classe che mappa l'etichetta bse di imballo
 * @author Antonio 08 set 2017
 *
 */
public class EtichettaImballo extends Etichetta {

	public String ragsocCliente;
	public String indirizzoCliente;
	public String capcittaprovCliente;
	
	public String ragsocMittente;
	public String capcittaprovMittente;
	public String opzionaliCliente;
	
	public String numeroOrdine;
	
	public String ragsocDestinatario;
	public String indirizzoDestinatario;
	public String capcittaprovDestinatario;
	public String nazioneDestinatario;
	public String corriere;
	public String peso;
	public String note;
	
	public String progressivoCollo;
	public String numeroCollo;
	
	
	public EtichettaImballo(int h, int w) {
		super(h, w);
	}

}
