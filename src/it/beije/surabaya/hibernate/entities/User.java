package it.beije.surabaya.hibernate.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@Entity
@Table(name = "user")
public class User {
		

			@Id
			@GeneratedValue
			@Column(name = "id")
			private int id;
			
			@Column(name = "lastName")
			private String lastName;
			
			@Column(name = "firstName")
			private String firstName;

			@Column(name = "personalEmail")
			private String personalEmail;
			
			@Column(name = "workEmail")
			private String workEmail;
			
			@Column(name = "phone")
			private String phone;
			
			@Column(name = "fiscalCode")
			private String fiscalCode;
			
			@Column(name = "admin")
			private Boolean admin;
			
			@Column(name = "password")
			private String password;
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			
			public String getPersonalEmail() {
				return personalEmail;
			}
			public void setPersonalEmail(String personalEmail) {
				this.personalEmail = personalEmail;
			}
			
			public void getPhone() {
				this.phone = phone;
			}
			
			public void setPhone(String phone) {
				this.phone = phone;
			}
			
			public String getFiscalCode() {
				return fiscalCode;
			}
			public void setFiscalCode(String fiscalCode) {
				this.fiscalCode = fiscalCode;
			}
			
			public Boolean getAdmin() {
				return admin;
			}
			
			public void setAdmin(Boolean admin) {
				this.admin = admin;
			}
			
			public String getPassword() {
				return password;
			}
			
			public String setPassword(String password) {
				return password;
			}
			
			
		}
