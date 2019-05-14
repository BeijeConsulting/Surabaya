package it.beije.surabaya.cap5.motorizzazione;

public class KawasakiZ750 extends Ciclomotore {
	public int VelocitaMax() {
		return 280;
	}

	
	public String inpenna() {
		return "alla grande...";
	}


	public double getCilindrata() {
		
		return 2.0;
	}


	public double getPeso() {
		return 200.00;
	}

	
	public void viaggia() {
		
	}
	public static void main (String[]args) {
		KawasakiZ750 k= new KawasakiZ750();
		System.out.println("inpenna?? "+ k.inpenna());
		System.out.println("il numero ruote è "+ k.getNumRuote());
		System.out.println("la velocità massima è "+ k.VelocitaMax()+ " km/h");
	}
	
		
		
	
	

}
