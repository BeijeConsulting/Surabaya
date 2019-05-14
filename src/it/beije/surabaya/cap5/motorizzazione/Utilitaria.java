package it.beije.surabaya.cap5.motorizzazione;

interface Utilitaria {

	String nome = "sono una utilitaria";
	
	public default  String getNome () {
		return nome;
	}
}
