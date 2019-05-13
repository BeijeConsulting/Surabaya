package it.beije.surabaya.cap5.savana;
import it.beije.surabaya.cap5.fattoria.Animale;

public class Opossum implements Predatore, Preda, Onnivoro {

	public void mangioErba() {}

	public void mangioCarne() {}

	public void mangioGhiande() {}

	public void scappa() {}

	public void caccia() {}
	
	//senza questo metodo definito in erbivoro, superclasse di onnivoro, da errore 
	public void ciao() {};
	
	public String toString() {
		return "Opossum";
	}
	public void mangio(Animale a) {
		System.out.println("Sono un opossum e oggi ho mangiato " + a);
	};
	
	public void mangio(Preda a) {
		System.out.println("Sono un opossum e oggi ho mangiato " + a);
	};

	public void mangioInteriora() {
		System.out.println("mangio la busecca...");
	}

}
