package it.beije.surabaya.cap5.motorizzazione;

public class Test {

	public static void main(String[] args) {
		
		Fiat_Utilitaria f = new Fiat_Utilitaria();
		
		System.out.println(f.toString() + " " + f.viaggia());

		Jeep j = new Jeep();
		
		System.out.println(j.toString() + " " + j.viaggia());
		
		Ciclomotore d = new Ducati();
		
		System.out.println(d.toString() + " " + d.viaggia() + " " + d.impenna());
	}

}
