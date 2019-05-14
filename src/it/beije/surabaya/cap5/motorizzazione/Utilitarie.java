package it.beije.surabaya.cap5.motorizzazione;

public class Utilitarie extends Utilitaria{
	
	private double cilindrata = 1.4;
	private double peso = 1200;
	private int porte = 5;
	private int posti = 5;
	
	public void viaggia() {
		System.out.println("Brum Brum");
	};
	
	public double getPeso() {
		
		double peso = this.peso;
		return peso;
		
	}
	
	public double getCilindrata() {
		
		double cilindrata = this.cilindrata;
		return cilindrata;
				
	};
	
	public int getNumPorte() {
		
		int porte = this.porte;
		return porte;
		
	};
	
	public int getNumPosti() {
		
		int posti = this.posti;
		return posti;
		
	};
	
	public void trazione() {
		System.out.println("La trazione è anteriore");
	};
	
}

class Fiat_500 extends Utilitarie {
	
	private int posti = 4;
	private double peso = 980;
	private double cilindrata = 1.2;
	
	public int getNumPosti() {
		
		int posti = this.posti;
		return posti;
		
	};
	
	public double getPeso() {
		
		double peso = this.peso;
		return peso;
		
	}
	
	public double getCilindrata() {
		
		double cilindrata = this.cilindrata;
		return cilindrata;
				
	};
	
	public static void main(String[] args){
		
		Fiat_500 prova = new Fiat_500();
		Utilitarie prova2 = new Utilitarie();
		System.out.println(prova.getNumPosti() + prova.getNumRuote() + prova.getCilindrata() + prova2.getNumPosti() + prova2.getNumRuote() + prova2.getCilindrata());
		
		
		
	}
}
	class Toyota_Yaris extends Utilitarie{
		
		private int porte = 3;
		
		public int getNumPorte() {
			
			int porte = this.porte;
			return porte;
			
		};
		
	}
