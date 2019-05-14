package it.beije.surabaya.cap5.motorizzazione;

public class Jeep extends Suv {
	private double cilindrata;
	private int numPosti;
	private double peso;
	
	public Jeep(double cilindrata, int numPosti, double peso) {
		this.cilindrata = cilindrata;
		this.numPosti = numPosti;
		this.peso = peso;
	}
	
	public Jeep() {
		this.cilindrata = 2000;
		this.numPosti = 6;
		this.peso = 1500;
	}
	
	public String toString() {
		return Suv.getNome() + " con Cilindrata : " + cilindrata + ", numero posti " + numPosti +", peso " + peso;
	}
	
	public double getCilindrata() {
		return cilindrata;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public double getPeso() {
		return peso;
	}
	
	public void setCilindrata(double cilindrata) {
		this.cilindrata = cilindrata;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String viaggia() {
		return "viaggio su 4 ruote, e funziono anche nel deserto";
	}

}
