package blackJack;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	CardDeck(){

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {

				cards.add(new Card(i, j));

			}
		}

	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card draw() {
		if (cards.size() == 0) {
			return null;
		}else {
			Card card = cards.get(0);
			cards.remove(0);
			return card;
		}

	}

	public ArrayList<Card> get() {

		return cards;

	}

}
