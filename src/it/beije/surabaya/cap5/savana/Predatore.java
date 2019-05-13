package it.beije.surabaya.cap5.savana;

public interface Predatore {
	
	public abstract void caccia();

	public default void mangio(Preda g) {
		System.out.println("oggi ho mangiato una preda:" + g);
	}
}
