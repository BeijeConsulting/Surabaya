package it.beije.surabaya.cap5.motorizzazione;

public class RenaultCaptur extends Suv {

	public double getCilindrata() {
		return 1.4;
	}

	public double getPeso() {
		return 1400;
	}

	public void viaggia() {
		
	}
	
	public static void main (String[]args) {
		RenaultCaptur r= new RenaultCaptur();
		System.out.println("il suo peso � "+ r.getPeso());
		System.out.println("il numero ruote � "+ r.getNumRuote());
		System.out.println("la velocit� massima � "+ r.VelocitaMax()+ " km/h");
	}

}
