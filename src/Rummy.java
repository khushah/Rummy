import java.util.ArrayList;


public class Rummy {
	static HandOfCards handOfCards =  new HandOfCards();
	public void generateHand(ArrayList<Card> hand){
		for(int i=0;i<13;i++){
			handOfCards.parseHand(hand.get(i).getRank(),hand.get(i).getSuit());
		}
		
	}

	    public static void main(String[] args){
	        Deck deck = new Deck();
	        ArrayList<Card> result = deck.getDeck();
	        Rummy rummy = new Rummy();
	        
	        for(int i=0;i<13;i++){
	        System.out.print(result.get(i).getSuit()+" "+result.get(i).getRank()+" ; ");       
	        }
	        result.add(new Card(3,'D'));
	        result.add(new Card(6,'H'));
	        result.add(new Card(11,'D'));
	        result.add(new Card(13,'S'));
	        result.add(new Card(4,'S'));
	        result.add(new Card(7,'H'));
	        result.add(new Card(10,'H'));
	        result.add(new Card(13,'C'));
	        result.add(new Card(9,'D'));
	        result.add(new Card(9,'D'));
	        result.add(new Card(12,'D'));
	        result.add(new Card(12,'C'));
	        result.add(new Card(3,'S'));
	        System.out.println();
	        rummy.generateHand(result);
	        handOfCards.displayHand();
	        System.out.println("======================================================");
	        System.out.println(handOfCards.meldCards());
	        handOfCards.displayHand();

	}

}
