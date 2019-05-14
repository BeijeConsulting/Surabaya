package it.beije.surabaya.cap5.motorizzazione;

public class Mustang extends Sportiva{

	public Mustang() {
		super.cilindrata = 2300;
		super.peso = 1655;
	}
	
	public double getCilindrata() {
		return cilindrata;
	}
	
	public double getPeso() {
		return peso;
	}
	
	
	public static void main(String[] args) {
		Mustang ecoBoost = new Mustang();
		
		System.out.println("---------------> SPECIFICHE TECNICHE MUSTANG ECOBOOST <----------------");
		System.out.println("Cilindrata: "+ecoBoost.getCilindrata()+"cc");
		System.out.println("Peso: "+ecoBoost.getPeso()+"Kg");
		System.out.println("Numero posti:" + ecoBoost.getNumPosti());
		System.out.println("Numero porte: "+ecoBoost.getNumPorte());
		
		System.out.println("\n");
		System.out.println("**************** TEST DRIVE MUSTANG **************");
		ecoBoost.viaggia();
		
		
	}

	
}
