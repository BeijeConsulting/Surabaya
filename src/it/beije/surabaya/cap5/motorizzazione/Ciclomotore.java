package it.beije.surabaya.cap5.motorizzazione;

public abstract class Ciclomotore extends Veicolo {
	public abstract String inpenna();
	
	public int getNumRuote() {
		return 2;
	}

	public int getNumPosti() {
		return 2;
	}
}
