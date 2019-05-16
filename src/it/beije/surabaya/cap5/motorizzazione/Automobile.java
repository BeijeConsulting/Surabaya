package it.beije.surabaya.cap5.motorizzazione;

public abstract interface Automobile {

	public abstract int getNumRuote();
	
	public default int getNumPosti() {
		return 4;
	}
	
	public abstract String alimentazione();
	
	public default void viaggia() {
		System.out.println("Viaggio su " + getNumRuote() + "ruote");
	}
}
	
