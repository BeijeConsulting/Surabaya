package it.beije.surabaya.cap5.motorizzazione;

public class Ducati extends Veicolo implements Ciclomotore, Sportiva  {

	public Ducati(double cilindrata, int numPosti, double peso, String marca, String modello) {
		super(cilindrata, numPosti, peso, marca, modello);
	}
	
	
	public Ducati() {
		super(8000, 1, 200, "S", "Rosso");
		
	}
	
	public String toString() {
		return getNome() + super.toString();
	}
}
