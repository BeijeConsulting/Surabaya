package it.beije.surabaya.cap5.savana;

public interface Carnivoro {
	
	public abstract void mangioCarne();
	
<<<<<<< HEAD
	public default  void mangioInteriora() {
=======
	public default void mangioInteriora() {
>>>>>>> refs/remotes/origin/master
		System.out.println("mangio la trippa...");
	}
<<<<<<< HEAD
	
	public default void mangio(Animale a) {
		System.out.println("mangio un animale");
	}
	public default void quantaCarne(Animale... p) {
		int i=0;
		int kg=0;
		while (i < p.length) {
			kg+=p[i].peso();
			i++;
		}
		System.out.println("Ho mangiato " + kg + " kg di carne");
	}
=======

	public default void mangio(Animale a) {
		System.out.println("mangio un animale");
	}

>>>>>>> refs/remotes/origin/master
}
