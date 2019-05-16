package it.beije.surabaya.cap5.motorizzazione;

public abstract class Veicolo {
	
	public int numRuote;
	public double cilindrata;
	public int numPosti;
	public double peso;
	public abstract double getPeso();
	

}

interface Automobile{
	
	
	final int numRuote = 4;
	 default int getNumRuote(){
		return numRuote;
	};
		
}

interface Ciclomotore{
	
	public int getNumRuote();
	public double getCilindrata();
	public default void impenna() {
		System.out.println("Tentato decollo");
	};
	final int numRuote = 2;
	
}

interface Alimentazione {
	
	void getAlimentazione();
}

interface Berlina extends Automobile{}

interface Sportiva extends Automobile{}

interface Suv extends Automobile{}

/*
Veicolo [ getNumRuote, getCilindrata, getNumPosti, getPeso, viaggia, getMarca, getModello, getMarcaModello ]

Ciclomotore [ impenna ]
Automobile [ ]

Utilitaria
Berlina
Sportiva
Suv


Fiat_500
VW_Golf
Renault_Captur
Toyota_Yaris
....
*/
