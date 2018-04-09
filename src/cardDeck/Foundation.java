package cardDeck;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Foundation extends Group{

	private ArrayList<Card> foundation = new ArrayList<Card>();
	
	private String color = "";
	
	Foundation(String color){
		
		this.color = color;
		
		Rectangle base = new Rectangle(45, 80);
		base.setFill(Color.rgb(0, 0, 0, 0.2));
		base.setStroke(Color.BLACK);
		base.setArcHeight(10);
		base.setArcWidth(10);
		
		this.getChildren().add(base);
		
	}
	
	// ---------- Functions for the foundations ---------- //

	public boolean addCard(Card card) {

		if (card.getColorName().equals(color) && card.getValue() == foundation.size() + 2) {
			foundation.add(card);
			this.getChildren().add(card);
			return true;
		}

		return false;

	}

	public void setPos(float x, float y) {

		this.setTranslateX(x);
		this.setTranslateY(y);
		
	}

}
