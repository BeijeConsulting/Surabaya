package it.beije.surabaya.cap5.motorizzazione;

public abstract class Automobile extends Veicolo{
	public int getNumRuote() {
		return 4;
	}
	public abstract void tetto() ;
	
	public boolean camporella() {
		return true;
	}
}
