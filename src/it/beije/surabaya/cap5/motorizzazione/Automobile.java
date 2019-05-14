package it.beije.surabaya.cap5.motorizzazione;

public abstract class Automobile extends Veicolo{
	
	private int nRuote = 4;
	private int nPosti = 4;	//per default vengono considerati 4 posti
	
	public int getNumRuote() {
		return nRuote;
	}
	
	public int getNumPosti() {
		return nPosti;
	}
	
	public void viaggia() {
		System.out.println("Veicolo in movimento...");
	}
	
	public abstract int getNumPorte();
	
}
