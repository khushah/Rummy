import java.util.ArrayList;

public class HandOfCards {

	private int[][] hand = new int[14][4];
	private int noOfCardsNeededToWin = 0;
	private static final int NO_OF_SUITS = 4;
	
	
	int joker=0;
	static String suits= "SHCD";
	public HandOfCards(){
		for(int r=0;r<14; r++){
			for(int s=0;s<4;s++){
				hand[r][s]=0;
			}
		}
	}
	
	public void parseHand(int rank, char suit){
		int suitIndex= suits.indexOf(suit);
		hand[rank][suitIndex]++;
	}
	
	public void displayHand(){
		for(int r=0;r<14; r++){
			for(int s=0;s<4;s++){
				System.out.print(hand[r][s]);
			}
			System.out.println();
		}
	}

	public int meldCards()
	{
		findAndMeldCanasta();
		findAndMeldRun();
		findAndMeldSets();
		findAndMeldLoneCards();
		return noOfCardsNeededToWin;
	}
	
	public void findAndMeldRun()
	{
		for(int suit =0;suit<NO_OF_SUITS;suit++)
			findAndMeldRunForSuit(suit);
	}
	
	private void findAndMeldRunForSuit(int suit)
	{
		findAndMeldRunForSuitWithSequenceLength(suit, 5);
		findAndMeldRunForSuitWithSequenceLength(suit, 4);
		findAndMeldRunForSuitWithSequenceLength(suit, 3);
	}
	
	private void findAndMeldRunForSuitWithSequenceLength(int suit, int runLength)
	{
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
	
	public void findAndMeldCanasta(){
		
		final int CARDS_IN_CANASTA = 3;
			for(int rank = 1; rank <= 13; rank++){
				for(int suit = 0; suit < 4; suit++){
					if(hand[rank][suit] == CARDS_IN_CANASTA){
						hand[rank][suit] = 0;
				}
			}
		}
	}
	
}
