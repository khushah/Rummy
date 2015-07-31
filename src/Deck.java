import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	
	    ArrayList<Card> cards = new ArrayList<Card>();

	    String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	    String[] suit = {"C", "S", "D", "H"};

	    public Deck(){
	    	for(int k=0 ; k < 3 ; k++){
	    	this.cards.add(new Card("Joker",""));
	        for (int i = 0; i<suit.length; i++) {
	            for(int j=0; j<values.length; j++){
	                this.cards.add(new Card(suit[i],values[j]));
	            }
	        }
	    	}
	    		
	           Collections.shuffle(this.cards);

	    }

	    public ArrayList<Card> getDeck(){
	        return cards;
	    }
	    }
