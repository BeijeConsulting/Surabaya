package it.beije.surabaya.cap5.motorizzazione;

public class VWGolf extends Sportiva {
	public double getCilindrata() {
		return 1.6;
	}

	public double getPeso() {
		return 1600;
	}

	public void viaggia() {
		
	}
	
	public String Alimentazione() {
		return "benzina";
		
	}
	public static void main (String[]args) {
		VWGolf vw= new VWGolf();
		System.out.println("l'alimentazione � "+ vw.Alimentazione());
		System.out.println("il numero ruote � "+ vw.getNumRuote());
		System.out.println("la velocit� massima � "+ vw.VelocitaMax()+ " km/h");
	}
}
