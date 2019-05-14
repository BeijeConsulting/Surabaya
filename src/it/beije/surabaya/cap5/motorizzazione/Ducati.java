package it.beije.surabaya.cap5.motorizzazione;

public class Ducati extends Sportiva {

	private double cilindrata;
	private int numPosti;
	private double peso;
	
	public Ducati(double cilindrata, int numPosti, double peso) {
		this.cilindrata = cilindrata;
		this.numPosti = numPosti;
		this.peso = peso;
	}
	
	public Ducati() {
		this.cilindrata = 8000;
		this.numPosti = 1;
		this.peso = 200;
	}
	
	public String toString() {
		return Sportiva.getNome() + " con Cilindrata : " + cilindrata + ", numero posti " + numPosti +", peso " + peso;
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
