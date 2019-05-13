package it.beije.surabaya.cap5.savana;
import it.beije.surabaya.cap5.fattoria.Animale;

public class Leone implements Predatore, Carnivoro {

	public void mangioInteriora() {
		System.out.println("mangio la trippa...");
	};
	
	public void mangioCarne() {
		System.out.println("mangio una bistecca...");
	}

	public void mangio(Animale a) {
		System.out.println("Sono un leone e oggi ho mangiato " + a);
	};
	
	
	public void mangio(Preda p) {
		System.out.println("Sono un leone e oggi ho mangiato " + p);
	}
	
	public void mangio(Erbivoro e ) {
		System.out.println("Sono un leone e oggi ho mangiato " + e);
					
	}
	
	public void caccia() {
		System.out.println("ogni mattina etc etc...");
	}
	
	public static void main(String[] args) {
		Leone leone = new Leone();
		
		leone.mangio((Erbivoro) new Gazzella());
		leone.mangio((Preda) new Opossum());
		
		
		
	}

}
