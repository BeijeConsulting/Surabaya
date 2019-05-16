package autonoleggio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.beije.surabaya.cap5.motorizzazione.*;

public class Sistema {

	//Dichiarazione ed inizializzazione della multi map statica 
	private static Map<String, ArrayList<Automobile>> automobili = new HashMap<>();
	static {
		ArrayList<Automobile> fiat = new ArrayList<>();
		fiat.add(new Fiat_500());
		fiat.add(new Fiat_500());
		
		ArrayList<Automobile> alfa = new ArrayList<>();
		alfa.add(new Alfa_Quadrifoglio());
		alfa.add(new Alfa_Quadrifoglio());

		automobili.put("Fiat 500", fiat);
		automobili.put("Alfa Quadrifoglio", alfa);
	}
	
	//Metodo per richiedere una automobile usando il nome di questa
	public static Automobile getAuto(String nome) throws IndexOutOfBoundsException{
		
		if(automobili.containsKey(nome)) {
			ArrayList<Automobile> a = automobili.get(nome);
			Automobile auto = a.get(0);
			try {
				a.remove(0);
			}catch(IndexOutOfBoundsException e) {
				throw e;
			}
			automobili.put(nome, a);
			return auto;
		}
			
		return null;
	
	}
	
	//metodo per restituire una automobile 
	public static void returnFiat(Automobile auto) {
		ArrayList<Automobile> a = automobili.get("Fiat 500");
		a.add(auto);
		automobili.put("Fiat 500", a);
	}
	
	
	
	public static void main(String[] args) {

		System.out.println(automobili);
		Automobile a1 = null, a2 = null, a3 = null, a4 = null;
		
		try {
			a1 = getAuto("Fiat 500");
			a1.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Fiat esaurite");
		}
		
		try {
			a2 = getAuto("Fiat 500");
			a2.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Fiat esaurite");
		}
		
		try {
			a3 = getAuto("Fiat 500");
			a3.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Fiat esaurite");
		}
		
		System.out.println(automobili);
		
		returnFiat(a2);
		
		System.out.println(automobili);
		
		try {
			a2 = getAuto("Alfa Quadrifoglio");
			a2.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Alfa esaurite");
		}		
		
		try {
			a4 = getAuto("Alfa Quadrifoglio");
			a4.viaggia();
		}catch(IndexOutOfBoundsException e){
			System.out.println("Alfa esaurite");
		}
		
		System.out.println(automobili);
		
		
	}

	

}
