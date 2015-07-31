import java.util.ArrayList;

public class HandOfCards {

	int[][] hand = new int[14][4];
	public int NO_OF_SUITS = 4;
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
			if(suitsWithCardsOfCurrentRank.size()>=3)
			{
				for(Integer suit : suitsWithCardsOfCurrentRank)
					hand[rank][suit]--;
			}
		}
	}
	
	public void isNaturalSet(){}
	
};
