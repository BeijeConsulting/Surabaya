package it.beije.surabaya.cap5.motorizzazione;

public abstract interface Automobile{
	
	public abstract int getNumPosti();
	
	public default int getNumRuote() {
		return 4;
	}
	
	public default void viaggia(){
		System.out.println("Viaggio su " + getNumRuote() + " ruote..");
	}

}
