package edu.plu.cs.farkle.client;

public class serverTest extends Database{

	public serverTest(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		
		System.out.println(1);
		//d.get();
		
		
		System.out.println(2);
		d.put();
		
		System.out.println(3);
		d.get();
		
		System.out.println("NUMBER OF PLAYERS: " + user.getPlayers().size());
		
		
		System.out.println(4);
		user.setName("NEWNAME");
		user.setPass("NEWPASS");
		user.setTotal(500);
		user.setWins(5);
		
		d.post();
		
		System.out.println(5);
		d.get();
		System.out.println("NUMBER OF PLAYERS: " + user.getPlayers().size());
		System.out.println(6);
		d.delete();
		
		System.out.println(7);
		d.get();
		
		
		

	}
	

}
