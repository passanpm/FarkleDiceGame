package edu.plu.cs.farkle.client;
import edu.plu.cs.farkle.client.Standard;

public class testInheritance extends Standard {

	public testInheritance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bank(){
		int bank = 0;
		
		//single calculation
		for (int i = 0; i < Standard.single.size(); i++){
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
				bank += set.get(0) * 100;
			}
			set.clear();
			score += bank;
	}
}
