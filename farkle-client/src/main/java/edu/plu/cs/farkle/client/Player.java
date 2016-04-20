package edu.plu.cs.farkle.client;
public class Player {

	private String name;
	private String pass;
	private int wins;
	private int total;
	
	public Player(){
		name = "user";
		pass = "pass";
		wins = 0;
		total = 0;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Player(String user, String key){
		this.name = user;
		this.pass = key;
		wins = 0;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}

	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	


	public int getWins() {
		return this.wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
}
