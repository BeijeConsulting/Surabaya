package it.beije.surabaya.cap5.fattoria;

public class Maiale extends Mammifero {

	private String nome;
	private final char sesso;//M/F
	private String colore;
	private double peso;//in kg
	private int mesi;
	
	
//	public Maiale() {
//		this.sesso = 'F';
//	}
	
	public Maiale() {
		this(' ');
	}

	public Maiale(char sesso) {
		this(sesso, null);
	}
	
	public Maiale(char sesso, String colore) {
		this(sesso, null, 0);
	}
	
	public Maiale(char sesso, String colore, double peso) {
		this(sesso, null, 0, null);
	}

	public Maiale(char sesso, String colore, double peso, String nome) {
		super(4);
		
		if (sesso == 'M') {
			this.sesso = sesso;
		} else {
			this.sesso = 'F';
		}
		
		this.colore = colore;
		this.peso = peso;
		this.nome = nome;
	}


		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getSesso() {
		return sesso;
	}
//	public void setSesso(char sesso) {
//		this.sesso = sesso;
//	}
	
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if (peso > 0) {
			this.peso = peso;
		} else System.out.println("PESO ERRATO!!");
	}
	
	public int getMesi() {
		return mesi;
	}
	public void setMesi(int mesi) {
		if (mesi >= 0) {
			this.mesi = mesi;
		}
	}
	
	public int getNumeroMammelle() {
		return super.getNumeroMammelle();
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder("[ ");
		b.append("nome : ").append(nome).append(" | ")
		.append("sesso : ").append(sesso).append(" | ")
		.append("colore : ").append(colore).append(" | ")
		.append("peso : ").append(peso).append(" | ")
		.append("mesi : ").append(mesi).append(" | ")
		.append("numeroZampe : ").append(getNumeroZampe()).append(" | ")
		.append("numeroMammelle : ").append(getNumeroMammelle())
		.append(" ]");

		return b.toString();
	}
}
