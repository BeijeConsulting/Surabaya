package it.beije.surabaya.cap5.motorizzazione;

public abstract class Berlina extends Automobile {
	public abstract boolean pagaSuperBollo  ();   //Sensato su alcune berline, meglio guardare modello per modello
	public int getNumPosti()  {
		return 5;
	}
	
	
	
	// MEGLIO LASCIARE LA DEFINIZIONE DEL TIPO DI TRAZIONE AI SINGOLI MODELLI, MERCTO TROPPO VASTO
}
