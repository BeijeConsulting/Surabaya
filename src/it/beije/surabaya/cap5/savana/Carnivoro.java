package it.beije.surabaya.cap5.savana;
import it.beije.surabaya.cap5.fattoria.Animale;

public interface Carnivoro {
	
	public abstract void mangioCarne();

//	manca default!!	
//	public void mangioInteriora() {
//		System.out.println("mangio la trippa...");
//	}
	public default void mangioInteriora() {
		System.out.println("mangio la trippa...");
	}


	public void mangio(Animale a);
	
// siccome sia erbivoro che preda sono animali, è meglio creare un metodo per la classe più generale
//	public default void mangio(Erbivoro e) {
//		System.out.println("Oggi ho mangiato" + e);
//	};
//	
}
