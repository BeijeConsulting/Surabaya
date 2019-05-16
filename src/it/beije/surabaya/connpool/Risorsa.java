package it.beije.surabaya.connpool;


public class Risorsa {

	public static int risorseDisponibili = 5;
	boolean risorsaOccupata;
	private final String nomeRisorsa;
	private String nomeCliente;
	
	public Risorsa(String nomeRisorsa, String nomeCliente){
		this.nomeRisorsa = nomeRisorsa;
		risorsaOccupata = false;
		this.nomeCliente = nomeCliente;
	}

	public String getNomeRisorsa() {
		return nomeRisorsa;
	}
	
	public static int getNumRisorse() {
		return risorseDisponibili;
	}
	
	public boolean occupata() {
		return risorsaOccupata;
	}
	
	private void setOccupata(boolean value) {
		this.risorsaOccupata = value;
	}
	
	public static boolean verificaRisorsa() {
		if(risorseDisponibili != 0)
			return true;
		else
			return false;
	}
	
	public String toString() {
		return this.getNomeRisorsa() + " risorsa\nOccupata: " + this.occupata() + "\nNome cliente: "+this.nomeCliente ;
	}
	
	public void occupaRisorsa(String nomeCliente) {
		if(nomeCliente != null && risorseDisponibili != 0 && this.occupata() != true) {
			setOccupata(true);
			this.nomeCliente = nomeCliente;
			risorseDisponibili--;
			System.out.println("Risorsa prenotata.");
		}else {
			System.out.println("Risorsa già occupata!\n");
		}
	}
	
	public void rilasciaRisorsa(String nomeCliente) {
		if(nomeCliente != null && risorseDisponibili < 5) {
			setOccupata(false);
			this.nomeCliente = null;
			risorseDisponibili++;
		}
	}
	
}
