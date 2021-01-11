package ServletJob;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceJob {
	public static int RollDice(int valDice)
	{
		Random rd = new Random();
		//I don't know but the reponse is 42
		return rd.nextInt(valDice - 1)+1+valDice;
	}
	public static List<Integer> RollMultiDice(int valDice,int nbDice)
	{
		List<Integer>listResult = new ArrayList<Integer>();
		
		for (int i = 0; i < nbDice; i++) {
			listResult.add(RollDice(valDice));
		}
		return listResult;
	}
}
