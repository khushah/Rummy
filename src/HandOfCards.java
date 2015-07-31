import java.util.ArrayList;

public class HandOfCards {

	int[][] hand = new int[14][4];
	public int NO_OF_SUITS = 4;
	
	private int noOfCardsNeededToWin = 0;

	public void HandParse(){}
	
	public void updateCards(){}
	
	public void findAndMeldRunForSuit(int suit)
	{
		findAndMeldRunForSuitWithSequenceLength(suit, 5);
		findAndMeldRunForSuitWithSequenceLength(suit, 4);
		findAndMeldRunForSuitWithSequenceLength(suit, 3);
	}
	
	private void findAndMeldRunForSuitWithSequenceLength(int suit, int runLength)
	{
		int[] window = new int[runLength];
		
		for(int windowPosition=1;windowPosition<=14-runLength;windowPosition++)
		{
			int noOfGapsInCurrentWindow = 0;
			for(int positionInCurrentWindow=0;positionInCurrentWindow<runLength;positionInCurrentWindow++)
			{
				int rank =  windowPosition + positionInCurrentWindow;
				if(hand[rank][suit]==0)
					noOfGapsInCurrentWindow++;
			}
			if(noOfGapsInCurrentWindow<=3)
			{
				noOfCardsNeededToWin += noOfGapsInCurrentWindow;
				for(int positionInCurrentWindow=0;positionInCurrentWindow<runLength;positionInCurrentWindow++)
				{
					int rank =  windowPosition + positionInCurrentWindow;
					if(hand[rank][suit]>0)
						hand[rank][suit]--;
				}
			}
		}
	}
	
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
			if(suitsWithCardsOfCurrentRank.size()>=3)
			{
				for(Integer suit : suitsWithCardsOfCurrentRank)
					hand[rank][suit]--;
			}
		}
	}
	
	public void isNaturalSet(){}
	
};
