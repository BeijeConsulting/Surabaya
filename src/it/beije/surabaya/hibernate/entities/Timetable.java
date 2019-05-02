package it.beije.surabaya.hibernate.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class Timetable {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "idUser")
	private int idUser;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "start1")
	private LocalTime start1;
	
	@Column(name = "end1")
	private LocalTime end1;
	
	@Column(name = "start2")
	private LocalTime start2;
	
	@Column(name = "end2")
	private LocalTime end2;
	
	@Column(name = "tot")
	private double tot;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public LocalTime getStart1() {
		return start1;
	}
	public void setStart1(LocalTime start1) {
		this.start1 = start1;
	}
	
	public LocalTime getEnd1() {
		return end1;
	}
	public void setEnd1(LocalTime end1) {
		this.end1 = end1;
	}
	
	public LocalTime getStart2() {
		return start2;
	}
	public void setStart2(LocalTime start2) {
		this.start2 = start2;
	}
	
	public LocalTime getEnd2() {
		return end2;
	}
	public void setEnd2(LocalTime end2) {
		this.end2 = end2;
	}
	
	public double getTot() {
		return tot;
	}
	public void setTot(double tot) {
		this.tot = tot;
	}
	
	
}
