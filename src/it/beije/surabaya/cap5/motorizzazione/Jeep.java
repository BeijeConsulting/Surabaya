package it.beije.surabaya.cap5.motorizzazione;

public class Jeep extends Suv{
	
	public Jeep() {
		super.cilindrata = 2184;
		super.peso = 2290;
	}
	
	public double getCilindrata() {
		return cilindrata;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public static void main(String[] args) {
		
		Jeep cherook = new Jeep();
		
		System.out.println("---------------> SPECIFICHE TECNICHE JEEP CHEROKEE <----------------");
		System.out.println("Cilindrata: "+cherook.getCilindrata()+"cc");
		System.out.println("Peso: "+cherook.getPeso()+"Kg");
		System.out.println("Numero posti:" + cherook.getNumPosti());
		System.out.println("Numero porte: "+cherook.getNumPorte());
		
		System.out.println("\n");
		System.out.println("**************** TEST DRIVE JEEP **************");
		cherook.viaggia();
		
	}

}
