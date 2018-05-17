package cardDeck;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pile extends Group {

	private ArrayList<Card> pile = new ArrayList<Card>();

	public Pile(){
		
		Rectangle base = new Rectangle(45, 80);
		base.setFill(Color.rgb(0, 0, 0, 0.2));
		base.setStroke(Color.BLACK);
		base.setArcHeight(10);
		base.setArcWidth(10);
		
		this.getChildren().add(base);
		
	}
	
	public ArrayList<Card> getPile() {
		return pile;
	}

	public boolean addCard(Card card) {
		
		if (pile.size() == 0 ) {
			pile.add(card);
			card.setPos(0, 0);
			this.getChildren().add(card);
			return true;

		}else if (pile.get(pile.size()-1).getValue() == card.getValue()+1 ||
				pile.get(pile.size()-1).getValue() == card.getValue()-1 ) {

			pile.add(card);
			card.setPos(0, 0);
			this.getChildren().add(card);
			return true;

		}
		return false;	
	}
	
	public boolean forceAddCard(Card card) {
		
		pile.add(card);
		card.setPos(0, 0);
		this.getChildren().add(card);
		return true;
		
	}
	
	public void removeCard(Card card) {
		
		pile.remove(card);
		this.getChildren().remove(card);
		
	}

	public void setPos(double x, double y) {

		this.setTranslateX(x);
		this.setTranslateY(y);
		
	}
	
}
