package it.beije.surabaya.cap5.motorizzazione;

import motorizzazione.primo.livello.Automobile;
import motorizzazione.primo.livello.Veicolo;
import motorizzazione.secondo.livello.Sportiva;

public class Mustang extends Automobile implements Sportiva{

	private final int n = 2;
	
	public Mustang() {
		super.cilindrata = 2300;
		super.peso = 1655;
	}
	
	
	public int getNumPosti() {
		return n;
	}


	
}
