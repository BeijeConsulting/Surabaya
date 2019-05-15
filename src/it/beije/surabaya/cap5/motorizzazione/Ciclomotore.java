package it.beije.surabaya.cap5.motorizzazione;

public abstract interface Ciclomotore{
	
	public abstract void impenna();
	
	public default int getNumRuote() {
		return 2;
	}
	
	public default int getNumPosti() {
		return 2;
	}
	
	public default void viaggia(){
		System.out.println("Viaggio su " + getNumRuote() + " ruote..");
	}
	
}
