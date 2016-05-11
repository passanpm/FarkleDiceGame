package edu.plu.cs.farkle.gamerules;

import java.util.ArrayList;

public class Alternate extends Gameplay{
	
	/**
	 * Calculate the score of banked dice
	 * @return the value of the scoring banked dice
	 */
	public int bankScore(){
		change = false;
		
		int bank = 0;
		countDice();
		
		int amt;
		//Add 100 for each 1
		if(nums[0]>0){
			amt = nums[0];
			bank += 100*amt;
			System.out.println(amt+" 1's - Added "+100*amt);
		}
		
		//Add 50 for each 5
		if(nums[4]>0){
			amt = nums[4];
			bank += 50*amt;
			System.out.println(amt+" 5's - Added "+50*amt);
		}
		
		//There is a set of dice with value 1
		if(nums[0] == 3){
			bank += 700;
			System.out.println("Three Dice = 1. Added 700");
		}
		
		//There is a set of dice with value 5
		if(nums[4] == 3){
			bank += 350;
			System.out.println("Three Dice = 5. Added 350");
		}
		
		if(nums[0] > 0 || nums[4] > 0)
			change = true;

		
		int threePair = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i]==3){
				if(i != 4 && i != 0){
					bank += (i+1)*100;
					change = true;
					System.out.println("Three Dice = "+(i+1)+". Added "+ ((i+1)*100));
				}
			}
			//added for Full House
			if(nums[i]==2){
				threePair += 1;
				if(nums[i]==3){
					bank+= 250;
					change = true;
					System.out.println("Full House: Added 250");
				}
				//if there are three pairs add score
				if(threePair == 3){
					bank += 1500;
					change = true;
					System.out.println("Three Pair: Added 1500");
				}
			}
			//four of a kind
			if(nums[i]==4){
				if(i==0){
					bank += 1600;
					System.out.println("Bank: "+bank);
				}
				else if(i==4){
					bank += 1800;
					System.out.println("Bank: "+bank);
				}
				else{
					bank += 2000;
					System.out.println("Bank: "+bank);
				}
				change = true;
				System.out.println("Four of a kind: Added 2000");
			}
			//five of a kind
			if(nums[i]==5){
				if(i==0){
					bank += 3600;
				}
				else if(i==4){
					bank += 3800;
				}
				else{
					bank += 4000;
				}
				change = true;
				System.out.println("Five of a kind: Added 4000");
			}
			//six of a kind
			if(nums[i] == 6){
				if(i==0){
					bank += 5600;
				}
				else if(i==4){
					bank += 5800;
				}
				else{
					bank += 6000;
				}
				change = true;
				System.out.println("Six of a kind: Added 6000");
			}
			
		}
		
		//Straight Calculation
		if(nums[0] == 1 && nums[1] == 1 && nums[2] == 1  && nums[3] == 1 && nums[4] == 1 && nums[5] == 1 ){
			bank -= 650;
			bank += 2500;
			change = true;
			System.out.println("Straight Scored: Added 2500");
		}
		
		//no scoring dice automatic 500
		if( (nums[1] < 3 && nums[1] > 0) && (nums[2] < 3 && nums[2] > 0) && (nums[3] < 3 && nums[3] > 0) && (nums[5] < 3 && nums[5] > 0)){
			bank += 500;
			change = true;
			System.out.println("No Scoring Dice: Added 500");
		}
		
		//Farkle check
		if( (nums[1] < 3 && nums[1] > 0) || (nums[2] < 3 && nums[2] > 0) || (nums[3] < 3 && nums[3] > 0) || (nums[5] < 3 && nums[5] > 0)){
			change = false;
		}
		
		tempScore = bank;
		return bank;
	}
	

	/**
	 * FOR TESTING USE ONLY!
	 */
	public void getNum(){
		for(int i=0; i<nums.length; i++){
			System.out.println("nums["+i+"] ="+nums[i]);
		}
	}
	
	public int aiBankScore(ArrayList<Integer> aiRoll){
		single = aiRoll;
		return bankScore();
	}
	
	
}