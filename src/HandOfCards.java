
public class HandOfCards {

	int[][] hand;

	public static void HandParse(){}
	
	public static void isRun(){}
	
	public static void isCanasta(int[][] hand){
		
		final int CARDS_IN_CANASTA = 3;
		for(int suit = 0; suit < 4; suit++){
			for(int rank = 1; rank <= 13; rank++){
				if(hand[suit][rank] == CARDS_IN_CANASTA){
					updateCards(CARDS_IN_CANASTA);
				}
			}
		}
	}
	
	private static void updateCards(int numberOfCards) {}

	public static void isSet(){}
	
};
