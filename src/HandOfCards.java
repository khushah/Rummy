import java.util.ArrayList;

public class HandOfCards {

	int[][] hand = new int[14][4];
	public int NO_OF_SUITS = 4;

	private int noOfCardsNeededToWin = 0;
	int joker = 0;
	static String suits = "SHCD";

	public HandOfCards() {
		for (int r = 0; r < 14; r++) {
			for (int s = 0; s < 4; s++) {
				hand[r][s] = 0;
			}
		}
	}

	public void parseHand(int rank, char suit) {
		int suitIndex = suits.indexOf(suit);
		hand[rank][suitIndex]++;
	}

	public void displayHand() {
		for (int r = 0; r < 14; r++) {
			for (int s = 0; s < 4; s++) {
				System.out.print(hand[r][s]);
			}
			System.out.println();
		}
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

	public void findAndMeldRunForSuit(int suit) {
		findAndMeldRunForSuitWithSequenceLength(suit, 5);
		findAndMeldRunForSuitWithSequenceLength(suit, 4);
		findAndMeldRunForSuitWithSequenceLength(suit, 3);
	}

	private void findAndMeldRunForSuitWithSequenceLength(int suit, int runLength) {
		final int MAX_WINDOW_POSITION  = 15 - runLength;
		for (int windowPosition = 1; windowPosition <= MAX_WINDOW_POSITION; windowPosition++) {
			int noOfGapsInCurrentWindow = 0;
			for (int positionInCurrentWindow = 0; positionInCurrentWindow < runLength; positionInCurrentWindow++) {
				int rank = (windowPosition + positionInCurrentWindow)%13;
				if (hand[rank][suit] == 0)
					noOfGapsInCurrentWindow++;
			}
			if (noOfGapsInCurrentWindow <= 3) {
				noOfCardsNeededToWin += noOfGapsInCurrentWindow;
				for (int positionInCurrentWindow = 0; positionInCurrentWindow < runLength; positionInCurrentWindow++) {
					int rank = (windowPosition + positionInCurrentWindow)%13;
					if (hand[rank][suit] > 0)
						hand[rank][suit]--;
				}
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

};
