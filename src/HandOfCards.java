import java.util.ArrayList;

public class HandOfCards {

	int[][] hand = new int[14][4];
	public int NO_OF_SUITS = 4;

	public void HandParse(){}
	
	public void updateCards(){}
	
	public void isRun(){}
	
	public void findAndMeldSets()
	{
		for(int rank=1;rank<=13;rank++)
		{
			ArrayList<Integer> suitsWithCardsOfCurrentRank  = new ArrayList<Integer>() ;
			for(int suit=0;suit<4;suit++)
			{
				if(hand[rank][suit]>0)
					suitsWithCardsOfCurrentRank.add(suit);
			}
			if(suitsWithCardsOfCurrentRank.size()>3)
			{
				for(Integer suit : suitsWithCardsOfCurrentRank)
					hand[rank][suit]--;
			}
		}
	}
	
	public void isNaturalSet(){}
	
};
