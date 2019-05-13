package it.beije.surabaya.cap5.savana;

public class Leone extends Animale implements Predatore, Carnivoro {

	public void mangioCarne() {
		System.out.println("mangio una bistecca...");
	}
	
	public void caccia() {
		System.out.println("ogni mattina etc etc...");
	}
	


	public String toString() {
		return "Leone";
	}
	
	public static void main(String [] args) {
		
		Leone l = new Leone();
		
	//	l.mangio((Preda)new Gazzella());
	//	l.mangio((Preda)new Opossum());
		l.mangio(new Leone());
	}
}
