package it.beije.surabaya.cap5.motorizzazione;

public class Ciclomotori extends Ciclomotore{
	
	private int posti = 2;
	private double peso = 200;
	private double cilindrata = 250;
	
	public void viaggia() {
		System.out.println("mmmeeeeeeeeh mmeeeeeeeh");
	}
	
	public void impenna() {
		System.out.println("Ostia che pinna");
	}

	public int getNumPosti() {
		
		return this.posti;
		
	};
	
	public double getPeso() {
		
		return this.peso;
		
	};
	
	public double getCilindrata() {
		
		return this.cilindrata;
	};
	
}

class Harley_883 extends Ciclomotori{
	
	private double peso = 247;
	private int posti = 1;
	
	public void impenna() {
		System.out.println("Come no, ti piacerebbe");
		
	}
		public int getNumPosti() {
			
			return this.posti;
			
		};
	
	public double getPeso() {
			
			return this.peso;
			
		};
		
		
	
}
