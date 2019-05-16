package it.beije.surabaya.cap5.motorizzazione;

import java.util.Date;

public class Risorsa {
	public int id;
	public Veicolo veicolo;
	public Date dataInizio, dataFine;
	public boolean libero;
	
	public Risorsa(int id, Veicolo veicolo, Date dataInizio, Date dataFine, boolean libero) {
		this.id  = id;
		this.veicolo = veicolo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.libero = libero;
	}
	
	public Risorsa(int id, Veicolo veicolo) {
		this.id  = id;
		this.veicolo = veicolo;
		this.libero = true;
	}
	

	public int getId() {
		return id;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	
	
	
	
}
