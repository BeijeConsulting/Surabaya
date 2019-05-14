package it.beije.surabaya.cap5.motorizzazione;

interface Automobile{

	int numRuote = 4;
	public default  int getNumRuote() {
		return numRuote;
	}
	
	public default String viaggia() {
		return "viaggio su " + getNumRuote() + " ruote";
	}
}
