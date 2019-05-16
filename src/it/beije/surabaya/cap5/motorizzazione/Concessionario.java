package it.beije.surabaya.cap5.motorizzazione;

import java.util.ArrayList;
import java.util.List;

public class Concessionario {

	static List<Risorsa> r = new ArrayList<>();
	
	public static void main(String[] args) {
		

		
		Veicolo f = new Fiat_500();
		Veicolo j= new Jeep();
		
		r.add(new Risorsa(1, f));
		r.add(new Risorsa(2, j));
		
		System.out.println(r.get(0).getVeicolo().toString());
		
		System.out.println("Libero: " + r.get(0).isLibero());
		
		richiediVeicolo();
		

	}
	
	
	public static void richiediVeicolo() {
		boolean b = controlloDisponibilita();
		System.out.println("Richiesta accolta: " + b );
	}
	
	public static boolean controlloDisponibilita() {
		for(int i = 0; i < r.size(); i++ ) {
			if (r.get(i).isLibero()) {
				r.get(i).setLibero(false);
				System.out.println("Preso il veicolo id " + i);
				return true;
			}
		}
		
		return false;
	}

}
