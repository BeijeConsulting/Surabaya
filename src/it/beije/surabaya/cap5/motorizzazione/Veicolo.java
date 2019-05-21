package it.beije.surabaya.cap5.motorizzazione;

public abstract class Veicolo {
	
	private double cilindrata;
	private int numPosti;
	private double peso;
	private String marca;
	private String modello;
	
	public Veicolo(double cilindrata, int numPosti, double peso, String marca, String modello) {
		this.cilindrata = cilindrata;
		this.numPosti = numPosti;
		this.peso = peso;
		this.marca =marca;
		this.modello = modello;
	}

	public String toString() {
		return " con Cilindrata : " + cilindrata + ", numero posti " + numPosti +", peso " + peso +
				" " + getMarcaModello();
	}
	
	public double getCilindrata() {
		return cilindrata;
	}

	public int getNumPosti() {
		return numPosti;
	}


	public double getPeso() {
		return peso;
	}


	public String getMarca() {
		return marca;
	}


	public String getModello() {
		return modello;
	}


	public String getMarcaModello() {
		return "Marca: " + marca + ", Modello: " + modello;
	}
	
	
/*	
//	public abstract int getNumRuote();
	public abstract double getCilindrata();
//	public abstract int getNumPosti();
	public abstract double getPeso();
//	public abstract String viaggia();
	public abstract String getMarca();
	public abstract String getModello();
	public abstract String getMarcaModello();
*/
}

/*
Veicolo [ getNumRuote, getCilindrata, getNumPosti, getPeso, viaggia, getMarca, getModello, getMarcaModello ]

Ciclomotore [ impenna ]
Automobile [ ]

interfacce:
Utilitaria
Berlina
Sportiva
Suv
Furgone

<<<<<<< HEAD
<<<<<<< HEAD

interfaccie alimentazione:
=======
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> refs/remotes/origin/master
Benzina
Gasolio
Metano
Gpl
Elettrico

Fiat_500
VW_Golf
Renault_Captur
Toyota_Yaris
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
smart
=======
Smart


=======
Smart

>>>>>>> refs/remotes/origin/master
=======
Smart

>>>>>>> refs/remotes/origin/master
*/
