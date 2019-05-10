package it.beije.surabaya.cap5.fattoria;

public abstract class Mammifero extends Animale {

	private int numeroMammelle;
	
	public Mammifero(int numeroZampe) {
		super(numeroZampe);
		this.numeroMammelle = 12;
		System.out.println("Sono un mammifero");
	}
	
	protected int getNumeroMammelle() {
		return this.numeroMammelle;
	}
	
	public void allattare() {
		System.out.println("allatto...");
	}
}
