package edu.plu.cs.farkle.client;
import java.util.ArrayList;

public class Standard{
	
	protected int score = 0;
	protected static ArrayList<Integer> set = new ArrayList<Integer>();
	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	public void debug(){
		System.out.println("single: " + single);
		System.out.println("set: " + set);
	}
	
	public void addToSingle(int value){
		single.add(value);
		System.out.println("single: " + single);
	}
	
	public void addToSet(int value){
		set.add(value);
		System.out.println("set: " + set);
	}
	
	public void removeFromSingle(int die){
		single.remove(Integer.valueOf(die));
		System.out.println("single: " + single);
	}
	
	public void removeFromSet(int die){
		set.remove(Integer.valueOf(die));
		System.out.println("set: " + set);
	}
	
	//calculate value of bank
	public void bank(){
		int bank = 0;
		
		//single calculation
		for (int i = 0; i < single.size(); i++){
			if (single.get(i) == 1){
				bank += 100;
				single.remove(Integer.valueOf(1));
			}else if (single.get(i) == 5){
				bank += 50;
				single.remove(Integer.valueOf(5));
			}
		}
		
		//set of 3 calc
		//Remember: Requires holding down shift to work
		if (set.size() == 3){
			if (set.get(0) == 1){
				bank += 1000;
			}else{
				bank += set.get(0) * 100;
			}
			set.clear();
		}
		
		score += bank;
		
		
		
	}
	
	public int getScore(){
		return score;
	}
	
	//farkle -> next player
	public static void farkle(){

	}
	

}
