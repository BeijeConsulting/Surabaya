package it.beije.surabaya.cap5.motorizzazione;

public class Fiat_Utilitaria extends Utilitaria{

	private double cilindrata;
	private int numPosti;
	private double peso;
	
	public Fiat_Utilitaria(double cilindrata, int numPosti, double peso) {
		this.cilindrata = cilindrata;
		this.numPosti = numPosti;
		this.peso = peso;
	}
	
	public Fiat_Utilitaria() {
		this.cilindrata = 500;
		this.numPosti = 4;
		this.peso = 300;
	}
	
	public String toString() {
		return Utilitaria.getNome() + " con Cilindrata : " + cilindrata + ", numero posti " + numPosti +", peso " + peso;
	}
	
	@Override
	public double getCilindrata() {
		// TODO Auto-generated method stub
		return cilindrata;
	}

	@Override
	public int getNumPosti() {
		// TODO Auto-generated method stub
		return numPosti;
	}

	@Override
	public double getPeso() {
		// TODO Auto-generated method stub
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



}
