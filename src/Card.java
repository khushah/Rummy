
public class Card {


	    private int rank;
	    private char suit;
	    public Card(int rank, char suit){
	    	this.suit=suit;
	    	this.rank=rank;
	    }
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		public char getSuit() {
			return suit;
		}
		public void setSuit(char suit) {
			this.suit = suit;
		}
	
	}

