package it.beije.surabaya.cap5.savana;

public interface Predatore {
	
	public abstract void caccia();
	
	public default void mangio(Preda p) {
		System.out.println("Oggi ho mangiato " + p);
	}
	
}
