package farkle;

import java.util.ArrayList;

public class Gameplay {
	static ArrayList<String> players = new ArrayList<>();
	static ArrayList<Integer> playerScores = new ArrayList<>();
	static int roller = 0;
	static ArrayList<Object> version = new ArrayList<>();
	
	public static void endTurn(){
		if (roller < players.size()-1){
			roller++;
		}else{
			roller = 0;
		};
	}
	
	public static void updateScore(int player, int score){
		playerScores.set(player, playerScores.get(player)+score);
	}
}
