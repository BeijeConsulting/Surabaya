package motorizzazione.secondo.livello;

public interface Suv {
	
	public final static int nPosti = 5;
	
	default int getNumPosti() {
		return nPosti;
	}
	
}
