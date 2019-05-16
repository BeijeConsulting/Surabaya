package it.beije.surabaya.pool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.beije.surabaya.cap5.motorizzazione.*;
import it.beije.surabaya.cap5.motorizzazione.automodel.Fiat_500;
import it.beije.surabaya.cap5.motorizzazione.automodel.Toyota_Yaris;

public class Sistema {

	private static Map<Integer, ArrayList<Automobile>> automobili = new HashMap<>();
	static {
		ArrayList<Automobile> fiat = new ArrayList<>();
		fiat.add(new Fiat_500());
		fiat.add(new Fiat_500());
		
		ArrayList<Automobile> toyota = new ArrayList<>();
		toyota.add(new Toyota_Yaris());
		toyota.add(new Toyota_Yaris());

		automobili.put(1, fiat);
		automobili.put(2, toyota);
	}
	
	public static Automobile getFiat() throws IndexOutOfBoundsException{
		
		if(automobili.containsKey(1)) {
			ArrayList<Automobile> f = automobili.get(1);
			Automobile fiat = f.get(0);
			try {
				f.remove(0);
			}catch(IndexOutOfBoundsException e) {
				System.out.println("fiat esaurite");
				throw e;
			}
			automobili.put(1, f);
			return fiat;
		}
			
		return null;
	
	}
	
	public static void returnFiat(Automobile a) {
		ArrayList<Automobile> f = automobili.get(1);
		f.add(a);
		automobili.put(1, f);
	}
	
	public static void main(String[] args) {

		System.out.println(automobili);
		Automobile a1 = null, a2 = null, a3 = null;
		try {
			a1 = getFiat();
			System.out.println("Fiat noleggiata");
		}catch(IndexOutOfBoundsException e){
			System.out.println("Stai a piedi");
		}
		
		try {
			a2 = getFiat();
			System.out.println("Fiat noleggiata");
		}catch(IndexOutOfBoundsException e){
			System.out.println("Stai a piedi");
		}
		
		try {
			a3 = getFiat();
			System.out.println("Fiat noleggiata");
		}catch(IndexOutOfBoundsException e){
			System.out.println("Stai a piedi");
		}
		System.out.println(automobili);
		
		returnFiat(a2);
		
		System.out.println(automobili);
		
	}
}