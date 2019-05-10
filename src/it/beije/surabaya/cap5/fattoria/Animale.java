package it.beije.surabaya.cap5.fattoria;

public abstract class Animale implements EssereVivente {
	
	private int numeroZampe;
	
	public Animale(int numeroZampe) {
		this.numeroZampe = numeroZampe;
		System.out.println("Sono un animale");
	}
	
	public Animale() {
		this(0);
	}
	
	protected int getNumeroZampe() {
		return numeroZampe;
	}
	
	public void respirare() {
		System.out.println("respiro...");
	}
	
	public void nutrirsi() {
		System.out.println("nutrirsi...");
	}

	public void riprodursi() {
		System.out.println("Animale riprodursi...");
	}	

}
