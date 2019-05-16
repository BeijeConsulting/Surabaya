package autonoleggio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.beije.surabaya.cap5.motorizzazione.*;

public class Sistema {


	private static Map<Integer, ArrayList<Automobile>> automobili = new HashMap<>();
	static {
		ArrayList<Automobile> fiat = new ArrayList<>();
		fiat.add(new Fiat_500());
		fiat.add(new Fiat_500());
		
		ArrayList<Automobile> alfa = new ArrayList<>();
		alfa.add(new Alfa_Quadrifoglio());
		alfa.add(new Alfa_Quadrifoglio());

		automobili.put(1, fiat);
		automobili.put(2, alfa);
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
			a1.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Stai a piedi");
		}
		
		try {
			a2 = getFiat();
			a2.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Stai a piedi");
		}
		
		try {
			a3 = getFiat();
			a3.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Stai a piedi");
		}
		System.out.println(automobili);
		
		returnFiat(a2);
		
		System.out.println(automobili);

//		Automobile a4 = getFiat();
//		try {
//			a4.viaggia();
//		}catch(NullPointerException e){
//			System.out.println("Stai a piedi");
//		}
//		
//		System.out.println(automobili);
//		returnFiat(a3);
//		System.out.println(automobili);
//		
//		returnFiat(a1);
//		System.out.println(automobili);
//
//		a4 = getFiat();
//		try {
//			a4.viaggia();
//		}catch(NullPointerException e){
//			System.out.println("Stai a piedi");
//		}
		
		
	}

	

}
