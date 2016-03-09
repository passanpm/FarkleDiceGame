package edu.plu.cs.farkle.client;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Gameplay {
	//Stores all players in game
	
	Standard standard = new Standard();
	Player player = new Player();
	
	public static void main(String[] args) {
		
		redis server = new redis();
		server.initiateServer(); 
		
		FarkleUI ui = new FarkleUI();
		ui.deployUI();
		
		
	}
	
}
