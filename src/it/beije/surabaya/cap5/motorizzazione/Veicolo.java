package it.beije.surabaya.cap5.motorizzazione;

public abstract class Veicolo {
	
	public int ruote;
	
	public abstract int getNumRuote();
	public abstract double getCilindrata();
	public abstract int getNumPosti();
	public abstract double getPeso();
	public abstract void viaggia();

}

/*
Veicolo [ getNumRuote, getCilindrata, getNumPosti, getPeso, viaggia ]

Ciclomotore [ impenna ]
Automobile [ ]

Utilitaria
Berlina
Sportiva
Suv
Furgone


Fiat_500
VW_Golf
Renault_Captur
Toyota_Yaris
....
*/
