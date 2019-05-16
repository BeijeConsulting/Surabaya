package it.beije.surabaya.cap5.motorizzazione;
import java.util.*;

public class Fiat_500 extends Veicolo implements Utilitaria{

	
	@Override
	public int getNumRuote() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public double getCilindrata() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public double getPeso() {
		// TODO Auto-generated method stub
		return 900;
	}
	
	public String alimentazione() {
		return null;
		
	}
	public static void main(String[] args) {
		System.out.println("Inserisci tipo alimentazione: ");
		Fiat_500 prima= new Fiat_500();
		Scanner input= new Scanner(System.in);
		String alimentazione= input.nextLine();
		System.out.println("Ha una cilindrata di: " + prima.getCilindrata());
		System.out.println("Pesa: " + prima.getPeso());
		System.out.println("Ha un totale ruote numero: " + prima.getNumRuote());
		System.out.println("è alimentata a: " + alimentazione);
		
		
	}
	
	

}
