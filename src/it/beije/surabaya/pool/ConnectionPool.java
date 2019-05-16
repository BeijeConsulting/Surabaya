package it.beije.surabaya.pool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectionPool {
	
	public static void main(String[] args) {
		Prestito p = new Prestito ();
		List <Prestito> automobili = new ArrayList <Prestito> ();
		Scanner scan = new Scanner (System.in);
		String controllo="ciao";
		String auto,data;
		LocalDate dataInserita=null;
		System.out.println("Premere un qualsiasi tasto per cominciare a inserire nuovi prestiti");
		String scelta=scan.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		if (scelta!=null) { 
			while (!controllo.equalsIgnoreCase("q"))  {
				System.out.println("inserire modello auto");
				auto=scan.nextLine();
				p.setAuto(auto);
				System.out.println("inserire data d/MM/yyyy");
				data=scan.nextLine();
				dataInserita = LocalDate.parse(data, formatter);
				p.setDataPrestito(dataInserita);
				automobili.add(p);
				System.out.println("Premere q per terminare l'inserimento di nuovi prestiti");
				controllo = scan.nextLine();
				
		scan.close();
			}
		}
	}
}
