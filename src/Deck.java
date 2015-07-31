import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	
	    ArrayList<Card> cards = new ArrayList<Card>();

	    int[] ranks = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	    char[] suits = {'S', 'H', 'C', 'D'};

	    public Deck(){
	    	for(int k=0 ; k < 3 ; k++){
	    	this.cards.add(new Card(14,' '));
	        for (int i = 0; i<suits.length; i++) {
	            for(int j=0; j<ranks.length; j++){
	                this.cards.add(new Card(ranks[j],suits[i]));
	            }
	        }
	    	}
	    		
	           Collections.shuffle(this.cards);

	    }

	    public ArrayList<Card> getDeck(){
	        return cards;
	    }
	    }
