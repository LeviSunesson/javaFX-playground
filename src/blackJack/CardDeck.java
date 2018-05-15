package blackJack;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	/**
	 * Creates a new CardDeck filled with each possible card
	 */
	CardDeck(){

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {

				cards.add(new Card(i, j));

			}
		}

	}

	/**
	 * Shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Draws the top card from the deck, and then removes it from the deck
	 * @return The card that is at the last place in the cards array
	 */
	public Card draw() {
		if (cards.size() == 0) {
			return null;
		}else {
			Card card = cards.get(0);
			cards.remove(0);
			return card;
		}

	}

	/**
	 * Empties the deck and refills it with new cards
	 */
	public void reset() {
		
		cards.clear();
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {

				cards.add(new Card(i, j));

			}
		}
		
	}
	
	/**
	 * 
	 * @return The array of cards which is the deck
	 */
	public ArrayList<Card> get() {

		return cards;

	}

}
