package motorizzazione.secondo.livello;

public interface Berlina {
	
	public final static int nPosti = 4;
	
	default int getNumPosti() {
		return nPosti;
	}
}
