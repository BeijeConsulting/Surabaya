package it.beije.surabaya.cap5.motorizzazione;

public abstract interface Ciclomotore {
	public final String tipo= "Ciclomotore";
	
	public default String getType() {
		return tipo;
	}
}