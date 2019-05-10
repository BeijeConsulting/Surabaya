package it.beije.surabaya.rubrica;

import java.util.List;
import java.util.StringTokenizer;

import it.beije.surabaya.esempi.CSVutils;


//ID,Tipo,COD,Nome,Pubblicato,"In primo piano?","Visibilità nel catalogo","Breve descrizione",Descrizione,"Data di partenza del prezzo in saldo","Termine data del prezzo di vendita","Stato delle imposte","Aliquota di imposta","In stock?",Magazzino,"Abilita gli ordini arretrati?","Venduto singolarmente?","Peso (kg)","Lunghezza (cm)","Larghezza (cm)","Altezza (cm)","Permetti le recensioni clienti?","Nota di acquisto","Prezzo in offerta","Prezzo di listino",Categorie,Etichette,"Classe di spedizione",Immagine,"Limite di download","Scarica i giorni di scadenza",Genitore,"Prodotti raggruppati",Up-sell,Cross-sell,"URL esterna","Testo del pulsante",Posizione,"Attributo 1 nome","Attributo 1 valuta(e)","Attributo 1 visibile","Attributo 1 globale","Attributo 2 nome","Attributo 2 valuta(e)","Attributo 2 visibile","Attributo 2 globale","Attributo 2 predefinito"

public class Trasformatore {
	
	public static void main(String[] args) throws Exception {
		
		List<String> originalRows = CSVutils.getFileAsStrings("C:\\temp\\ecomm-transfer\\wc-product-export.csv");

		System.out.println(originalRows.size());
		
		StringTokenizer tokenizer = null;
		//for (int i = 0; i < originalRows.size(); i++) {
		for (int i = 0; i < 2; i++) {
			tokenizer = new StringTokenizer(originalRows.get(i), ",");
			while (tokenizer.hasMoreTokens()) {
				System.out.println(tokenizer.nextToken());
			}
		}
	}

}
