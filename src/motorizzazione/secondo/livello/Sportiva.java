package motorizzazione.secondo.livello;

import motorizzazione.primo.livello.Automobile;

public interface Sportiva {

	public final static int nPosti = 4;
	
	default int getNumPosti() {
		return nPosti;
	}


}