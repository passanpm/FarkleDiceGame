package edu.plu.cs.farkle.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlternateTest {
	
	Alternate test = new Alternate();

	@Test
	public void testBankScore() {
		int value;
		
		test.addToSingle(1);
		value = test.bankScore();
		//System.out.println("Test One Scoring: ");
		//test.getNum();
		assertEquals(100, value);
		
		test.clear();
		test.reset();
		test.addToSingle(1);
		test.addToSingle(2);
		test.addToSingle(3);
		test.addToSingle(4);
		test.addToSingle(5);
		test.addToSingle(6);
		value = test.bankScore();
		//System.out.println("Test Straight Scoring: ");
		//test.getNum();
		assertEquals(2500, value);
		
		test.clear();
		test.reset();
		test.addToSingle(2);
		test.addToSingle(2);
		test.addToSingle(2);
		test.addToSingle(2);
		test.addToSingle(2);
		test.addToSingle(2);
		value = test.bankScore();
		//System.out.println("Test Six of a Kind:");
		//test.getNum();
		assertEquals(6000, value);		
		
		test.clear();
		test.reset();
		test.addToSingle(3);
		test.addToSingle(3);
		test.addToSingle(3);
		test.addToSingle(3);
		test.addToSingle(3);
		value = test.bankScore();
		//System.out.println("Test Five of a Kind:");
		//test.getNum();
		assertEquals(4000, value);
		
		test.clear();
		test.reset();
		test.addToSingle(4);
		test.addToSingle(4);
		test.addToSingle(4);
		test.addToSingle(4);
		value = test.bankScore();
		//System.out.println("Test Four of a Kind:");
		//test.getNum();
		assertEquals(2000, value);
		
		test.clear();
		test.reset();
		test.addToSingle(2);
		test.addToSingle(2);
		test.addToSingle(2);
		value =  test.bankScore();
		//System.out.println("Set of Three");
		//test.getNum();
		assertEquals(200, value);
		
		/*
		test.clear();
		test.reset();
		test.addToSingle(2);
		test.addToSingle(2);
		test.addToSingle(3);
		test.addToSingle(3);
		test.addToSingle(6);
		test.addToSingle(6);
		value =  test.bankScore();
		System.out.println("Test Three Pair");
		test.getNum();
		assertEquals(1500, value);
		
		test.clear();
		test.reset();
		test.addToSingle(2);
		test.addToSingle(3);
		test.addToSingle(4);
		test.addToSingle(3);
		test.addToSingle(6);
		test.addToSingle(6);
		value =  test.bankScore();
		System.out.println("Test No Scoring Dice");
		test.getNum();
		assertEquals(500, value);
		*/
	}

	
}
