package it.beije.surabaya.cap5.motorizzazione;

import motorizzazione.primo.livello.Automobile;
import motorizzazione.secondo.livello.*;

public class Fiat500 extends Automobile implements Utilitaria{

	private static final int nPosti = 2;
	
	public Fiat500() {
		super.cilindrata = 875;
		super.peso = 960;
	}

	public int getNumPosti() {
		return nPosti;
	}

}
