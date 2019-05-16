package motorizzazione.terzo.livello;

import motorizzazione.primo.livello.Automobile;
import motorizzazione.primo.livello.Veicolo;
import motorizzazione.secondo.livello.Diesel;
import motorizzazione.secondo.livello.Sportiva;

public class Mustang extends Automobile implements Sportiva,Diesel{

	private final int n = 2;
	
	public Mustang() {
		super.cilindrata = 2300;
		super.peso = 1655;
		super.brand = "Ford";
		super.model ="Mustang EcoBoost";
	}
	
	
	public int getNumPosti() {
		return n;
	}


	
}
