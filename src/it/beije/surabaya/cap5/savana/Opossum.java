package it.beije.surabaya.cap5.savana;

public class Opossum implements Predatore, Preda, Onnivoro {

	public void mangioErba() {}

	public void mangioCarne() {}

	public void mangioGhiande() {}

	public void scappa() {}

	public void caccia() {}

	public void mangioInteriora() {
		System.out.println("mangio la busecca...");
	}

	@Override
	public void ciao() {
		System.out.println("L'opossum hello");
		
	}

}
