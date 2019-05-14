package it.beije.surabaya.cap5.motorizzazione;

interface Suv{
	String nome = "sono un suv";
	
	public default  String getNome () {
		return nome;
	}
}
