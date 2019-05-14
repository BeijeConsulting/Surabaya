package it.beije.surabaya.cap5.savana;

public class Gazzella extends Animale implements Preda, Erbivoro {

	public void mangioErba() {
		System.out.println("pure scondita...");
	}

	public void scappa() {
		System.out.println("hai voglia a correre...");
	}

	@Override
	public void ciao() {
		System.out.println("La gazzella saluta");
	}
	public String toString() {
		return "Gazzella";
	}

}
