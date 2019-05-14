package it.beije.surabaya.cap5.motorizzazione;

public abstract class Automobile extends Veicolo {
	private final int numRuote = 4;
	
	public  int getNumRuote() {
		return numRuote;
	}
	
	public String viaggia() {
		return "viaggio su " + numRuote + " ruote";
	}
}
