package it.beije.surabaya.cap5.motorizzazione;

public abstract class Ciclomotore extends Veicolo {

	protected abstract void impenna();
	
	public int getNome() {
		return ruote;
	}
}
