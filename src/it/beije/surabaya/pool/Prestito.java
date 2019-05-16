package it.beije.surabaya.pool;

import java.time.LocalDate;
//Bean
public class Prestito {
	
	private String auto;
	private LocalDate dataPrestito=null;
	public String getAuto() {
		return auto;
	}
	public void setAuto(String auto) {
		this.auto = auto;
	}
	public LocalDate getDataPrestito() {
		return dataPrestito;
	}
	public void setDataPrestito(LocalDate dataPrestito) {
		this.dataPrestito = dataPrestito;
	}
	
	
}
