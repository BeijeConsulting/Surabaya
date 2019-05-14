package motorizzazione.primo.livello;

public abstract class Veicolo {
	
	protected double cilindrata;
	protected double peso;
	protected String model = "";
	protected String brand = "";
	
	public abstract int getNumRuote();
	public abstract double getCilindrata();
	public abstract double getPeso();
	public abstract void viaggia();
	
	
	public abstract String getModel();
	public abstract String getBrand();
	
	public abstract String getModelBrand();

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
