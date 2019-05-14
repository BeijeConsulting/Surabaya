package it.beije.surabaya.cap5.motorizzazione;

public class Run {

	public static void main(String[] args) {
		
		Automobile f = new Fiat_500();
		
		System.out.println(f.toString() + " " + f.viaggia());
	
		Jeep j = new Jeep();
		
		System.out.println(j.toString() + " " + j.viaggia());
		
		Ciclomotore d = new Ducati();
		
		System.out.println(d.toString() + " " + d.viaggia() + " " + d.impenna());
		
		if(f.getNumRuote() > d.getNumRuote())
			System.out.println("fiat ha più ruote");
		else
			System.out.println("ducati ha piu ruote");
		
		
	}

}
