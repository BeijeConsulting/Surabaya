package it.beije.surabaya.cap5.motorizzazione;

public abstract class Veicolo {
	
	public abstract int getNumRuote();
	public abstract double getCilindrata();
	public abstract int getNumPosti();
	public abstract double getPeso();
	public abstract void viaggia();	

}

abstract class Ciclomotore extends Veicolo {
	
	public abstract void impenna();
	
	public int getNumRuote() {
		return 2;
		
	};
	
}

abstract class Automobile extends Veicolo {
	
	public int getNumRuote() {
		return 4;
		
	};
	
	public abstract void trazione();
	
	public abstract int getNumPorte();
	
	
	
}



abstract class Utilitaria extends Automobile {}

abstract class Berlina extends Automobile {}

abstract class Sportiva extends Automobile {}

abstract class Suv extends Automobile {}

abstract class Furgone extends Automobile {}




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
