package it.beije.surabaya.cap5.motorizzazione;

import motorizzazione.primo.livello.Automobile;
import motorizzazione.secondo.livello.Suv;

public class Jeep extends Automobile implements Suv{
	
	public Jeep() {
		super.cilindrata = 2184;
		super.peso = 2290;
		super.brand ="Jeep";
		super.model="Cherokee";
	}

}
