package it.beije.surabaya.cap5.savana;

public class Opossum extends Animale implements Predatore, Preda, Onnivoro {

	public void mangioErba() {}

	public void mangioCarne() {}

	public void mangioGhiande() {}

	public void scappa() {}

	public void caccia() {}

	public void mangioInteriora() {
		System.out.println("mangio la busecca...");
	}
	public void mangio(Animale a) {
		System.out.println("Oggi ho mangiato "+a.toString());
	}
	public String toString() {
		return "Opossum";
	}
	
	public int peso(){
		return 8;
	}
}
