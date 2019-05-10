package it.beije.surabaya.hibernate.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class TimeTable {

	
		
		@Id
		@GeneratedValue
		@Column(name = "id")
		private int id;
		
		@Column(name = "idUser")
		private String id_user;
		
		@Column(name = "date")
		private String date;

		@Column(name = "type")
		private String type;
		
		@Column(name = "star1")
		private Date start1;
		
		@Column(name = "end1")
		private Date end1;
		
		@Column(name = "star2")
		private Date start2;
		
		@Column(name = "end2")
		private Date end2;
		
		@Column(name = "tot")
		private String tot;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getIdUser() {
			return id_user;
		}
		public void setIdUser(String id_user) {
			this.id_user = id_user;
		}
		
		public String getDate() {
			return date;
			}
		
		public void setDate(String date) {
			this.date = date;
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		public Date getStart1() {
			return start1;
		}
		public void setStart1(Date start1) {
			this.start1 = start1;
		}
		
		public Date getEnd1() {
			return end1;
		}
		public void setEnd1(Date end1) {
			this.end1 = end1;
		}
		
		public Date getStart2() {
			return start2;
		}
		public void setStart2(Date star2) {
			this.start2 = start2;
		}
		
		public Date getEnd2() {
			return end2;
		}
		public void setEnd2(Date end2) {
			this.end2 = end2;
		}
		
		public String getTot() {
			return tot;
		}
		public void setTot(String tot) {
			this.tot = tot;
		}
	}

