package it.beije.surabaya.cap5.motorizzazione;

public interface Berlina extends Automobile {
 
	public default int getNumPosti() {
		return 4;
	}
	
}
