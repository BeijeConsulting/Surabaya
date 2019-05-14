package it.beije.surabaya.cap5.motorizzazione;

public class Run {

	public static void main(String[] args) {
		System.out.println("****************************************");
		System.out.println("** SPECIFICHE AUTO + TEST DRIVE       **");
		System.out.println("****************************************");
		
		
		MercedesE c = new MercedesE();

		System.out.println("\n\n---------------> SPECIFICHE TECNICHE MERCEDES E <----------------");
		System.out.println("Cilindrata: "+c.getCilindrata()+"cc");
		System.out.println("Peso: "+c.getPeso()+"Kg");
		System.out.println("Numero posti:" + c.getNumPosti());
		System.out.println("**************** TEST DRIVE MERCEDES **************");
		c.viaggia();
		
		
		Fiat500 fiat = new Fiat500();
		
		System.out.println("\n\n---------------> SPECIFICHE TECNICHE FIAT500 <----------------");
		System.out.println("Cilindrata: "+fiat.getCilindrata()+"cc");
		System.out.println("Peso: "+fiat.getPeso()+"Kg");
		System.out.println("Numero posti:" + fiat.getNumPosti());
		System.out.println("**************** TEST DRIVE FIAT **************");
		c.viaggia();
		
		
		Mustang ecoBoost = new Mustang();
		
		System.out.println("\n\n---------------> SPECIFICHE TECNICHE MUSTANG ECOBOOST <----------------");
		System.out.println("Cilindrata: "+ecoBoost.getCilindrata()+"cc");
		System.out.println("Peso: "+ecoBoost.getPeso()+"Kg");
		System.out.println("Numero posti:" + ecoBoost.getNumPosti());
		
		System.out.println("**************** TEST DRIVE MUSTANG **************");
		ecoBoost.viaggia();
		
		
		Jeep cherook = new Jeep();
		
		System.out.println("\n\n---------------> SPECIFICHE TECNICHE JEEP CHEROKEE <----------------");
		System.out.println("Cilindrata: "+cherook.getCilindrata()+"cc");
		System.out.println("Peso: "+cherook.getPeso()+"Kg");
		System.out.println("Numero posti:" + cherook.getNumPosti());
		System.out.println("**************** TEST DRIVE JEEP **************");
		cherook.viaggia();
		
		
		Honda n46 = new Honda();
		System.out.println("\n\n---------------> SPECIFICHE TECNICHE HONDA <----------------");
		System.out.println("Cilindrata: "+n46.getCilindrata()+"cc");
		System.out.println("Peso: "+n46.getPeso()+"Kg");
		System.out.println("Numero posti:" + n46.getNumPosti());
		
		
		System.out.println("\n\nPrima prova libera:");
		n46.viaggia();
		
		
		System.out.println("Arrivo al traguardo: ");
		n46.impenna();
		
		System.out.println("\nTutte le auto esaminate!");
		
	}

}
