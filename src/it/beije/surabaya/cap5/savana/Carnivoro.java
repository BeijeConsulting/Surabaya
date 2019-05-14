package it.beije.surabaya.cap5.savana;

public interface Carnivoro {
	
	public abstract void mangioCarne();
	
	public default void mangioInteriora() {
		System.out.println("mangio la trippa...");
	}

	public default void mangio(Animale a) {
		System.out.println("mangio un animale");
	}

}
