package it.beije.surabaya.cap5.motorizzazione;

public abstract class MotoGP extends Ciclomotore {

	//valide per tutte le moto della categoria	
	public double getCilindrata() {
		return super.cilindrata;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void impenna() {
		System.out.println("Sto impennando...");
	}
	
	
}
