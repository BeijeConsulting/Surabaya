package it.beije.surabaya.pool;

import java.time.LocalDateTime;

public class MyConnection{
	
	private String conn;
	private boolean available;
	private LocalDateTime timestamp;
	
	public MyConnection() {
		this.conn = "sono una conn";
		this.available = false;
		this.timestamp = LocalDateTime.now();
	}
	
	public String getConn() {
		return conn;
	}
	public void setConn(String conn) {
		this.conn = conn;
	}
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}