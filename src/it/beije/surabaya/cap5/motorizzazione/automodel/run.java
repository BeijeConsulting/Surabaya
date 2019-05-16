package it.beije.surabaya.cap5.motorizzazione.automodel;

import it.beije.surabaya.cap5.motorizzazione.Veicolo;

public class run {
	
	public static String capienza (Veicolo a, Veicolo b) {
		
		if (a.getNumPosti() > b.getNumPosti()) {
			return a.getMarcaModello() + " è più capiente di " + b.getMarcaModello();
		} else if (a.getNumPosti() < b.getNumPosti()) {
			return b.getMarcaModello() + " è più capiente di " + a.getMarcaModello();
		} else if (a.getNumPosti() == b.getNumPosti()) {
			return a.getMarcaModello() + " e " + b.getMarcaModello() + " hanno la stessa capienza";
		}
		
		return null;	
	}

	public static void main(String[] args) {
		Fiat_500 fiat = new Fiat_500();
		Toyota_Yaris yaris = new Toyota_Yaris();
		
		System.out.println(fiat.getType() + " " + fiat.getNumPosti());
		System.out.println(yaris.getNumPosti() + " " + yaris.getMotorType());

		
		System.out.println(capienza(fiat, yaris));
		
	}

}
