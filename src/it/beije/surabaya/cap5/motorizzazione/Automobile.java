package it.beije.surabaya.cap5.motorizzazione;

public abstract class Automobile extends Veicolo {
	public abstract String tipoTrazione ();  //VARIA DA TIPOLOGIA A TIPOLOGIA E ANCHE PER MODELLO
	public  int getNumRuote()  {
		return 4;
	}								//"viaggia" comune a tutte le auto e anche numRuote con rare eccezioni 
	public void viaggia()  {
		System.out.println("Viaggio");
	}
}
