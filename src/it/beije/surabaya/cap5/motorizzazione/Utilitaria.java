package it.beije.surabaya.cap5.motorizzazione;

public interface Utilitaria extends Automobile{
	
	public default int getNumPosti() {
		return 4;
	}

}
