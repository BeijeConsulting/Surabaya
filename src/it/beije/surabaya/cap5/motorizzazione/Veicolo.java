package it.beije.surabaya.cap5.motorizzazione;

public abstract class Veicolo {
	
	public abstract int getNumRuote();
	public abstract double getCilindrata();
	public abstract int getNumPosti();
	public abstract double getPeso();
	public abstract void viaggia();

}

/*
Veicolo [ getNumRuote, getCilindrata, getNumPosti, getPeso, viaggia, getMarca, getModello, getMarcaModello ]

Ciclomotore [ impenna ]
Automobile [ ]

Utilitaria
Berlina
Sportiva
Suv
Furgone

Benzina
Gasolio
Metano
Gpl
Elettrico

Fiat_500
VW_Golf
Renault_Captur
Toyota_Yaris
Smart

*/
