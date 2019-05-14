package it.beije.surabaya.cap5.motorizzazione;

public class Honda extends MotoGP {

	public Honda() {
		super.cilindrata = 1000;
		super.peso = 150;
	}
	
	public void viaggia() {
		System.out.println("Start: Honda in pista...");
	}
	
	public static void main(String[] args) {

		Honda n46 = new Honda();
		System.out.println("---------------> SPECIFICHE TECNICHE HONDA <----------------");
		System.out.println("Cilindrata: "+n46.getCilindrata()+"cc");
		System.out.println("Peso: "+n46.getPeso()+"Kg");
		System.out.println("Numero posti:" + n46.getNumPosti());
		
		
		System.out.println("\n\nPrima prova libera:");
		n46.viaggia();
		
		
		System.out.println("Arrivo al traguardo: ");
		n46.impenna();
		
		
	}

}
