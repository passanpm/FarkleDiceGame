package edu.plu.cs.farkle.client;
import java.util.ArrayList;

import redis.clients.jedis.Jedis;

public class Gameplay {
	//Stores all players in game
	static ArrayList<Player> players = new ArrayList<>();
	

	
	Standard standard = new Standard();
	
	//current players info
	static int rollerScore = 0;
	static int roller = 0;
	
	
	
}
