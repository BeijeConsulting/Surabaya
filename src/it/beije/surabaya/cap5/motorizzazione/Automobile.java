package it.beije.surabaya.cap5.motorizzazione;

public abstract interface Automobile {
	public final String tipo= "Automobile";
	
	public default String getType() {
		return tipo;
	}

	
}