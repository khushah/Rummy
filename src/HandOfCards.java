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
		//findAndMeldSets();
		//findAndMeldLoneCards();
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
		findAndMeldRunForSuitWithSequenceLength(suit, 5);
	}

	private void findAndMeldRunForSuitWithSequenceLength(int suit, int runLength) 
	{
		final int MAX_WINDOW_POSITION  = 15 - runLength;
		for (int windowPosition = 1; windowPosition <= MAX_WINDOW_POSITION; windowPosition++) 
		{
			String attendanceRegex="";
			if(attendanceRegex.matches("[O]*XX[O]*"))
			{
				noOfCardsNeededToWin+=1;
				for(int positionInCurrentWindow=0;positionInCurrentWindow<runLength;positionInCurrentWindow++)
				{
					int rank =  (windowPosition + positionInCurrentWindow)%13;
					if(hand[rank][suit]!=0)
						hand[rank][suit]--;
				}
			}	
			else if(attendanceRegex.matches("[O]*[X]+[O,X]*[X]+[O]*"))
			{
				int indexOfLastX = 0;
				for(int index = attendanceRegex.length()-1; index>0;index--)
				{
					if(attendanceRegex.charAt(index)=='X')
					{
						indexOfLastX = index;
						break;
					}
				}
				int indexOfFirstX = 0;
				for(int index = 0; index<attendanceRegex.length();index++)
				{
					if(attendanceRegex.charAt(index)=='X')
					{
						indexOfFirstX = index;
						break;
					}
				}
				int noOfGaps = 0;
				for(int i = indexOfFirstX+1;i<indexOfLastX;i++)
				{
					if(attendanceRegex.charAt(i)=='O')
						noOfGaps++;
					else
					{
						int rank = windowPosition + i;
						hand[rank][suit]--;
					}
				}
				noOfCardsNeededToWin+=noOfGaps;
			}
				
				
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
