package cardDeck;

import java.util.ArrayList;

public class Piles {

	private ArrayList<Card> pile1 = new ArrayList<Card>();
	private ArrayList<Card> pile2 = new ArrayList<Card>();
	private ArrayList<Card> pile3 = new ArrayList<Card>();
	private ArrayList<Card> pile4 = new ArrayList<Card>();
	private ArrayList<Card> pile5 = new ArrayList<Card>();
	private ArrayList<Card> pile6 = new ArrayList<Card>();
	private ArrayList<Card> pile7 = new ArrayList<Card>();

	// ---------- Functions for the piles ---------- // 
	
	public ArrayList<Card> getPile1() {
		return pile1;
	}

	public ArrayList<Card> getPile2() {
		return pile2;
	}

	public ArrayList<Card> getPile3() {
		return pile3;
	}

	public ArrayList<Card> getPile4() {
		return pile4;
	}

	public ArrayList<Card> getPile5() {
		return pile5;
	}

	public ArrayList<Card> getPile6() {
		return pile6;
	}

	public ArrayList<Card> getPile7() {
		return pile7;
	}

	public boolean addTo1(Card card) {

		if (pile1.size() == 0 ) {
			pile1.add(card);

			return true;

		}else if (pile1.get(pile1.size()-1).getValue() == card.getValue()+1 ||
				  pile1.get(pile1.size()-1).getValue() == card.getValue()-1 ) {

			pile1.add(card);
			return true;

		}
		return false;	
	}
	
	public boolean addTo2(Card card) {

		if (pile2.size() == 0 ) {
			pile2.add(card);

			return true;

		}else if (pile2.get(pile2.size()-1).getValue() == card.getValue()+1 ||
				  pile2.get(pile2.size()-1).getValue() == card.getValue()-1 ) {

			pile2.add(card);
			return true;

		}
		return false;	
	}
	
	public boolean addTo3(Card card) {

		if (pile3.size() == 0 ) {
			pile3.add(card);

			return true;

		}else if (pile3.get(pile3.size()-1).getValue() == card.getValue()+1 ||
				  pile3.get(pile3.size()-1).getValue() == card.getValue()-1 ) {

			pile3.add(card);
			return true;

		}
		return false;	
	}
	
	public boolean addTo4(Card card) {

		if (pile4.size() == 0 ) {
			pile4.add(card);

			return true;

		}else if (pile4.get(pile4.size()-1).getValue() == card.getValue()+1 ||
				  pile4.get(pile4.size()-1).getValue() == card.getValue()-1 ) {

			pile4.add(card);
			return true;

		}
		return false;	
	}
	
	public boolean addTo5(Card card) {

		if (pile5.size() == 0 ) {
			pile5.add(card);

			return true;

		}else if (pile5.get(pile5.size()-1).getValue() == card.getValue()+1 ||
				  pile5.get(pile5.size()-1).getValue() == card.getValue()-1 ) {

			pile5.add(card);
			return true;

		}
		return false;	
	}
	
	public boolean addTo6(Card card) {

		if (pile6.size() == 0 ) {
			pile6.add(card);

			return true;

		}else if (pile6.get(pile6.size()-1).getValue() == card.getValue()+1 ||
				  pile6.get(pile6.size()-1).getValue() == card.getValue()-1 ) {

			pile6.add(card);
			return true;

		}
		return false;	
	}
	
	public boolean addTo7(Card card) {

		if (pile7.size() == 0 ) {
			pile7.add(card);

			return true;

		}else if (pile7.get(pile7.size()-1).getValue() == card.getValue()+1 ||
				  pile7.get(pile7.size()-1).getValue() == card.getValue()-1 ) {

			pile7.add(card);
			return true;

		}
		return false;	
	}
	
}
