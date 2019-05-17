package it.beije.surabaya.pool;

import java.util.ArrayList;

public class ConnectionPool {

	private ArrayList<String> risorse = new ArrayList<>(10);		//non sar� string ma bin per contenere la risorsa e il momento in cui la occupiamo
																//inizializzazione array con il contenuto
	public String fornisciRisorsa() {	
		for (int i=0; i<risorse.size(); i++ ) {
			String r = risorse.get(i);
			if (r == null) {									//se nella posizione iesima il valore � null (nel senso che � libera)
				r = "occupato";									//setta la varibile r come occupata
																// aggiungere quando � stata settata a occupata (ora)
				return r;										//restituisci la risorsa in quella posizione che non sar� pi� libera
			
			} 
		}
		return null;
	}
	
}
