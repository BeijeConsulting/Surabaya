package motorizzazione.terzo.livello;

import motorizzazione.primo.livello.Automobile;
import motorizzazione.secondo.livello.*;

public class Fiat500 extends Automobile implements Utilitaria{

	private final int nPosti = 2;
	
	public Fiat500() {
		super.cilindrata = 875;
		super.peso = 960;
		super.model = "Fiat500";
		super.brand = "Fiat";
	}

	public int getNumPosti() {
		return nPosti;
	}

}
