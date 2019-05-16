package it.beije.surabaya.connpool;

import java.util.ArrayList;
import java.util.List;


public class CarPool {

	//Array risorse
	final static List<Risorsa> risorse = new ArrayList<Risorsa>();
	
	private void stampaRisorse(){
		for (Risorsa r : risorse) {
			System.out.println(r);
			System.out.println("\n");
		}
	}
	
	private Risorsa getRisorsa(int index){
		return risorse.get(index);
	}
	
	public static void main(String[] args) {

		CarPool cars = new CarPool();
		
		risorse.add(new Risorsa("Prima",null));
		risorse.add(new Risorsa("Seconda",null));
		risorse.add(new Risorsa("Terza",null));
		risorse.add(new Risorsa("Quarta",null));
		risorse.add(new Risorsa("Quinta",null));
		
		//cars.stampaRisorse();
		System.out.println("Ci sono risorse disponibili?");
		boolean disponibile = Risorsa.verificaRisorsa();
		
		if(disponibile) {
			System.out.println("Ci sono "+ Risorsa.getNumRisorse()+ " risorse disponibili!");
		}
		else {
			System.out.println("Non ci sono risorse disponibili");
			}
		
		
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(0).occupaRisorsa("Pippo");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(1).occupaRisorsa("Fra");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(2).occupaRisorsa("Mario");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(3).occupaRisorsa("Luca");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(4).occupaRisorsa("Marco");

		System.out.println("\n");
		cars.stampaRisorse();
		
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(0).occupaRisorsa("Ciao");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(1).occupaRisorsa("Ciao");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(2).occupaRisorsa("Ciao");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(3).occupaRisorsa("Ciao");
		System.out.println("Richiesta risorsa ->");
		cars.getRisorsa(4).occupaRisorsa("Ciao");
		
	}

	
}
