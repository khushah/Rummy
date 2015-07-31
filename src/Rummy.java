import java.util.ArrayList;


public class Rummy {
	public void generateHand(ArrayList<Card> hand){
		HandOfCards handOfCards =  new HandOfCards();
		for(int i=0;i<13;i++){
			handOfCards.parseHand(hand.get(i).getSuit(),hand.get(i).getValue());
		}
		
	}

	    public static void main(String[] args){
	        Deck deck = new Deck();
	        ArrayList<Card> result = deck.getDeck();
	        Rummy rummy = new Rummy();
	        rummy.generateHand(result);
	      /*  for(int i=0;i<13;i++){
	        System.out.println(result.get(i).getSuit()+" "+result.get(i).getValue());       
	        }*/

	}

}
