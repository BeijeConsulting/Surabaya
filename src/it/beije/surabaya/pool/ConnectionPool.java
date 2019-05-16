package it.beije.surabaya.pool;

import java.util.ArrayList;

public class ConnectionPool {

	private ArrayList<String> risorse = new ArrayList<>(10);		//non sarà string ma bin per contenere la risorsa e il momento in cui la occupiamo
																//inizializzazione array con il contenuto
	public String fornisciRisorsa() {	
		for (int i=0; i<risorse.size(); i++ ) {
			String r = risorse.get(i);
			if (r == null) {
				r = "occupato";		
																// aggiungere quando è stata settata a occupata (ora)
				return r;
			
			} 
		}
		return null;
	}
	
}
