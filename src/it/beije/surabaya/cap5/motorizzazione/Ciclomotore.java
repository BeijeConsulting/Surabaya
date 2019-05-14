package it.beije.surabaya.cap5.motorizzazione;

public abstract class Ciclomotore extends Veicolo{
	
	private final int numRuote = 2;
	
	public  String impenna() {
		return "so fare impennate";
	}
	
	public String viaggia() {
		return "viaggio su " + numRuote + " ruote";
	}
	public  int getNumRuote() {
		return numRuote;
	}
}
