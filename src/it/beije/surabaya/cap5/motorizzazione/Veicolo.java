package it.beije.surabaya.cap5.motorizzazione;

public abstract class Veicolo {
	public abstract int getNumPosti();
	public abstract double getCilindrata();
	public abstract double getPeso();
	public abstract int getNumRuote();
	public abstract String getBrand();
	public abstract String getModel();
	public abstract String getMarcaModello();
	public abstract String getMotorType();
}
	
	
	

/*
Veicolo [ getNumRuote, getCilindrata, getNumPosti, getPeso, viaggia ]

//ASTRATTE
Ciclomotore [ impenna ]
Automobile [ ]

//INTERFACCE
Utilitaria
Berlina
Sportiva
Suv
Furgone

//INTERFACCE
Benzina
Gasolio
Metano
Gpl
Elettrico

//CONCRETE
Fiat_500
VW_Golf
Renault_Captur
Toyota_Yaris
Smart
*/
