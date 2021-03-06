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

	public void parseHand(int rank, char suit) {
		int suitIndex = suits.indexOf(suit);
		if(rank==14){
			joker++;
		}
		else{
		hand[rank][suitIndex]++;
		}
	}

	public void displayHand() {
		for (int r = 0; r < 14; r++) {
			for (int s = 0; s < 4; s++) 
			{
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

	public void findAndMeldCanasta() {

		final int CARDS_IN_CANASTA = 3;
		for (int rank = 1; rank <= 13; rank++) {
			for (int suit = 0; suit < 4; suit++) {
				if (hand[rank][suit] == CARDS_IN_CANASTA) {
					hand[rank][suit] = 0;
				}
			}
		}
	}

	public void findAndMeldRun()
	{
		for(int suit =0;suit<NO_OF_SUITS;suit++)
			findAndMeldRunForSuit(suit);
	}
	
	private void findAndMeldRunForSuit(int suit)
	{
		findAndMeldRunForSuitWithSequenceLength(suit, 3);
		//System.out.println(noOfCardsNeededToWin);
		findAndMeldRunForSuitWithSequenceLength(suit, 4);
		//System.out.println(noOfCardsNeededToWin);
		findAndMeldRunForSuitWithSequenceLength(suit, 5);
		//System.out.println(noOfCardsNeededToWin);
	}

	private void findAndMeldRunForSuitWithSequenceLength(int suit, int runLength) 
	{
		final int MAX_WINDOW_POSITION  = 15 - runLength;
		for (int windowPosition = 1; windowPosition <= MAX_WINDOW_POSITION; windowPosition++) 
		{
			int noOfGapsInCurrentWindow = 0;
			for(int positionInCurrentWindow=0;positionInCurrentWindow<runLength;positionInCurrentWindow++)
			{
				int rank =  (windowPosition + positionInCurrentWindow)%13;
				if(hand[rank][suit]==0)
					noOfGapsInCurrentWindow++;
			}
			if(noOfGapsInCurrentWindow<=3)
			{	
				System.out.println("Start position :"+windowPosition+","+runLength+")");
				System.out.println("cards to win = "+noOfCardsNeededToWin+" before adding gaps");
				noOfCardsNeededToWin += noOfGapsInCurrentWindow;
				System.out.println("cards to win = "+noOfCardsNeededToWin);
				for(int positionInCurrentWindow=0;positionInCurrentWindow<runLength;positionInCurrentWindow++)
				{
					int rank =  windowPosition + positionInCurrentWindow;
					
					if(hand[rank][suit]>0)
						hand[rank][suit]--;
				}
			}
			for(int r=1;r<=13;r++)
				System.out.println(hand[r][suit]);
		}
	}

	public void findAndMeldSets() {
		for (int rank = 1; rank <= 13; rank++) {
			ArrayList<Integer> suitsWithCardsOfCurrentRank = new ArrayList<Integer>();
			for (int suit = 0; suit < 4; suit++) {
				if (hand[rank][suit] > 0)
					suitsWithCardsOfCurrentRank.add(suit);
			}

			if (suitsWithCardsOfCurrentRank.size() >= 3) {
				for (Integer suit : suitsWithCardsOfCurrentRank)
					hand[rank][suit]--;
			}
		}
	}

	public void findAndMeldLoneCards(){
		int loneCardCount=0;
		for(int rank=1;rank<=13;rank++)
		{
			for(int suit=0;suit<4;suit++)
			{
				if(hand[rank][suit]!=0)
					loneCardCount+=hand[rank][suit];
			}
		}
		if(loneCardCount>0){
			noOfCardsNeededToWin +=(3-loneCardCount);
		}
		
	}	
};
