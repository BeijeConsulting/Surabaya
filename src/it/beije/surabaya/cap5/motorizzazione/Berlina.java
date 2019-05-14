package it.beije.surabaya.cap5.motorizzazione;

interface Berlina {
	String nome = "sono una berlina";
	
	public default String getNome () {
		return nome;
	}
}
