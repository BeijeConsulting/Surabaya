package motorizzazione.terzo.livello;

import motorizzazione.primo.livello.MotoGP;

public class Honda extends MotoGP {

	public Honda() {
		super.cilindrata = 1000;
		super.peso = 150;
		super.brand = "Honda";
		super.model = "GP";
	}
	
	public void viaggia() {
		System.out.println("Start: Honda in pista...");
	}

}
