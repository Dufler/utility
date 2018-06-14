package it.ltc.utility.miscellanea.time;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe con funzioni utili per manipolare i Timestamp.
 * E' molto utilizzata nei progetti legacy dove i timestamp salvati a DB devono avere come precisione massima solo il giorno. 
 * @author Damiano
 *
 */
public class DateConverter {
	
	public static GregorianCalendar ottieniDataPrecisa(Timestamp data, int ore) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(data.getTime());
		String tempo = Integer.toString(ore);
		int index = tempo.length() == 5 ? 1 : 2;
		int ora = Integer.parseInt(tempo.substring(0, index));
		int minuti = Integer.parseInt(tempo.substring(index, index + 2));
		int secondi = Integer.parseInt(tempo.substring(index + 2));
		gc.set(Calendar.HOUR_OF_DAY, ora);
		gc.set(Calendar.MINUTE, minuti);
		gc.set(Calendar.SECOND, secondi);
		gc.set(Calendar.MILLISECOND, 0);
		return gc;
	}
	
	public static int getOraComeIntero(Timestamp data) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(data.getTime());
		int ora = gc.get(Calendar.HOUR_OF_DAY);
		int minuti = gc.get(Calendar.MINUTE);
		int secondi = gc.get(Calendar.SECOND);
		int totale = ora * 10000 + minuti * 100 + secondi;
		return totale;
	}
	
	public static Timestamp ripulisciTimestap(Timestamp data) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(data.getTime());
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		return new Timestamp(gc.getTimeInMillis());
	}

}
