package it.beije.surabaya.cap5.motorizzazione;

public class Utilitarie {
	
interface Utilitaria extends Automobile{
	
	final int numPosti = 4;
	default public int getNumPosti(){
		return numPosti;
	};
}

	static class Fiat_500 extends Veicolo implements Utilitaria,Alimentazione {
		
	
		 double cilindrata = 1200;
		 double peso = 980;
		 String marca = "Fiat";
		 String Modello = "500";
		 String[] alimentazione = {"Benzina", "Diesel"};

		
		public double getCilindrata(){
			return this.cilindrata;
		};
		
		public double getPeso(){
			return this.peso;
		};
		
		public void getAlimentazione(){
			for(String s : this.alimentazione)
				System.out.println(s);
		};
		
	}

	
	static class Smart extends Veicolo implements Utilitaria,Alimentazione {
		

		double peso = 880;
		int numPosti = 2;
		double cilindrata = 1200;
		String alimentazione = "Benzina";

		public double getPeso(){
			return this.peso;
		};
		
		public double getCilindrata(){
			return this.cilindrata;
		};	
		
		public void getAlimentazione(){
			String s = this.alimentazione;
				System.out.println(s);
		};
	}
}
