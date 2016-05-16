package edu.plu.cs.farkle.client;

public class st {

	public static void main(String[] args) {
		Player p = new Player();
		p.setName("phillip");
		p.setPass("hue");
		
		Database d = new Database(p.getName(), p.getPass());
		System.out.println(1);
		d.get(p);
		
		
		System.out.println(2);
		d.put();
		
		System.out.println(3);
		d.get(p);
		
		System.out.println("NUMBER OF PLAYERS: " + p.getPlayers().size());
		
		
		System.out.println(4);
		p.setName("NEWNAME");
		p.setPass("NEWPASS");
		p.setTotal(500);
		p.setWins(5);
		
		d.post(p);
		
		System.out.println(5);
		d.get(p);
		System.out.println("NUMBER OF PLAYERS: " + p.getPlayers().size());
		System.out.println(6);
		d.delete(p);
		
		System.out.println(7);
		d.get(p);

	}

}
