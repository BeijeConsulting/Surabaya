package it.beije.surabaya.cap5.motorizzazione;

public class Fiat_500 extends Utilitaria{
	
	public double getCilindrata() {
		return 875.0;
	}
	public int getNumPosti() {
		return 4;
	}
	public double getPeso() {
		return 980;
	}
	public void viaggia() {
		System.out.println("Posso spostarmi");
	}
	public String brand() {
		return "Fiat";
	}
}
