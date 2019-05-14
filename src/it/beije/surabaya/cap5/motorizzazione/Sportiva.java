package it.beije.surabaya.cap5.motorizzazione;

interface Sportiva{
	String nome = "sono una sportiva";
	
	public default  String getNome () {
		return nome;
	}
}
