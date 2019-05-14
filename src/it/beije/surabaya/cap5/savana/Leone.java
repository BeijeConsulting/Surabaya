package it.beije.surabaya.cap5.savana;

public class Leone extends Animale implements Predatore, Carnivoro {

	public void mangioCarne() {
		System.out.println("mangio una bistecca...");
	}
	
//	public void mangio(Preda p) {
//		System.out.println("Oggi ho mangiato "+p.toString());
//	}
//	
//	public void quanto(Preda... p) {
//		int i=0;
//		int kg=0;
//		while (i < p.length) {
//			kg+=p[i].peso();
//			i++;
//		}
//		System.out.println("Ho mangiato " + kg + " kg di carne");
//	}
	public void mangio(Animale a) {
		System.out.println("Oggi ho mangiato "+a.toString());
	}
	public void caccia() {
		System.out.println("ogni mattina etc etc...");
	}
	public String toString() {
		return "Leone";
	}
	public static void main(String[] args) {
		Leone leone = new Leone();
		Gazzella gaz=new Gazzella();
		Opossum opu=new Opossum();
		leone.mangio(new Gazzella());
		leone.mangio(new Opossum());
		leone.quantaCarne(gaz, opu, leone);
	}
	public int peso() {
		return 40;
	}
}
