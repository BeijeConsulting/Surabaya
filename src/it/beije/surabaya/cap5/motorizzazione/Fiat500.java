package it.beije.surabaya.cap5.motorizzazione;

public class  Fiat500 extends Utilitaria{

	public double getPeso() {
		return 1000.00;
	}
	
	public void viaggia() {
		
	}

	public double getCilindrata() {
		return 1.0;
	}
	
	public int NumeroPorte() {
		return 3;
	}
	
	public static void main (String[]args) {
		Fiat500 f= new Fiat500();
		System.out.println("il numero porte � "+ f.NumeroPorte());
		System.out.println("il numero ruote � "+ f.getNumRuote());
		System.out.println("la velocit� massima � "+ f.VelocitaMax()+ " km/h");
	}
}
