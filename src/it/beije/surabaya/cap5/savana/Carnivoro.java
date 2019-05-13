package it.beije.surabaya.cap5.savana;

public interface Carnivoro {
	
	void mangioCarne();
	
	default public void mangioInteriora() {
		System.out.println("mangio la trippa...");
	}

	default public void mangio(Carnivoro p) {
		System.out.println("ho mangiato un: " + p);
	}
}
