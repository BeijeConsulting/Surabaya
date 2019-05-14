package it.beije.surabaya.cap5.motorizzazione;

public class Jeep extends Veicolo implements Automobile, Suv {
	
	public Jeep(double cilindrata, int numPosti, double peso, String marca, String modello){
		super(cilindrata, numPosti, peso, marca, modello);
	}
	
	public Jeep() {
		super(2000,6, 1200, "Grande", "Mod s");
	}
	
	public String toString() {
		return getNome() + super.toString();
	}
}
