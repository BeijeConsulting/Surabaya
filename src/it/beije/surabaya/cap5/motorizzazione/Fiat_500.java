package it.beije.surabaya.cap5.motorizzazione;

public class Fiat_500 extends Veicolo implements Automobile, Utilitaria {

//	public double cilindrata;
//	public int numPosti;
//	public double peso;
//	public String marca;
//	public String modello;
	
	public Fiat_500(double cilindrata, int numPosti, double peso, String marca, String modello) {
		super(cilindrata, numPosti, peso, marca, modello);
	}
	
	public Fiat_500() {
		super(500, 4, 300, "X", "Mirror");
	}
	
	public String toString() {
		return getNome() + super.toString();
	}
	

}
