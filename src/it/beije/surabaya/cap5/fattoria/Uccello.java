package it.beije.surabaya.cap5.fattoria;

public class Uccello extends Animale {

	public Uccello(int numeroZampe) {
		super(numeroZampe);
		System.out.println("Sono un uccello");
	}
	
	public void depositoUova() {
		System.out.println("deposito uova...");
	}
	
}
