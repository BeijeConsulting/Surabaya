package it.beije.surabaya.cap5.motorizzazione;

import motorizzazione.primo.livello.Automobile;
import motorizzazione.secondo.livello.Berlina;

public class MercedesE extends Automobile implements Berlina {
	
	public MercedesE() {
		super.cilindrata = 1992;
		super.peso = 1700;
	}
}
