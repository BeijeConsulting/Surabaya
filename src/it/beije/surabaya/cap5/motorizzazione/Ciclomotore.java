package it.beije.surabaya.cap5.motorizzazione;

interface Ciclomotore{
	
	int numRuote = 2;
	
	public default  String impenna() {
		return "so fare impennate";
	}
	
	public default String viaggia() {
		return "viaggio su " + numRuote + " ruote";
	}
	public default  int getNumRuote() {
		return numRuote;
	}
}
