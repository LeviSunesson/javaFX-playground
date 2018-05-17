package blackJack;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Player extends Group{

	ArrayList<Card> hand = new ArrayList<Card>();

	Text value = new Text();
	Text name = new Text();
	Button hitButton = new Button("HIT");

	double x;
	double y;

	/**
	 * Creates a new player with a basic UI
	 */
	Player(){

		this(0, 0);

	}
	
	/**
	 * Creates a new player with a basic UI
	 * @param newName the name of the player
	 */
	Player(String newName){
		
		this(0, 0, newName);
		
	}

	/**
	 * Creates a new player with a basic UI
	 * @param x the x origin of the player on the screen
	 * @param y the y origin of the player on the screen
	 */
	Player(double x, double y){

		this(x, y, null);

	}
	
	/**
	 * Creates a new player with a basic UI
	 * @param x the x origin of the player on the screen
	 * @param y the y origin of the player on the screen
	 * @param newName the name of the player
	 */
	Player(double x, double y, String newName){
		
		name.setText(newName);
		
		this.x = x;
		this.y = y;

		this.setTranslateX(x);
		this.setTranslateY(y);

		//value.setRotate();
		value.setTranslateX(50);
		value.setTranslateY(70);
		value.setScaleX(3);
		value.setScaleY(3);

		name.setTranslateX(50);
		name.setTranslateY(30);
		name.setScaleX(3);
		name.setScaleY(3);
		
		hitButton.setStyle(
				  "-fx-background-color: rgba(0, 0, 0, 0.5);"
				+ "-fx-text-fill: black;"
				+ "-fx-background-radius: 0 0 0 0;"
				+ "-fx-border-radius:0 0 0 0;");
		hitButton.setTranslateX(50);
		hitButton.setTranslateY(120);
		hitButton.setScaleX(3);
		hitButton.setScaleY(3);

		Rectangle background = new Rectangle(0, 0, 300, 200);
		background.setFill(Color.hsb(Math.random()*360, .5, .5));
		this.getChildren().addAll(background, value, name, hitButton);

		hitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				hit(BlackJack.deck.draw());

			}
		});
		
	}
	
	/**
	 * Enables the hit button
	 */
	public void activateHit() {
		
		hitButton.setDisable(false);
		
	}
	
	/**
	 * Disables the hit button
	 */
	public void deactivateHit() {
		
		
		hitButton.setDisable(true);
		
	}

	/**
	 * 
	 * @return Name of player
	 */
	public String getName() {

		return name.getText();

	}

	/**
	 * Sets the name of the player
	 * @param name the new name of the player
	 */
	public void setName(String name) {

		this.name.setText(name);

	}

	/**
	 * Updates the player with all the new information accumulated
	 */
	public void update() {

		value.setText("Value: " + getScore());

		for(Card card: hand) {

			if (!this.getChildren().contains(card)) {
				this.getChildren().add(card);
			}

		}

		for (int i = 0; i < hand.size(); i++) {

			if (i < 5) {
				hand.get(i).setPos(175, 10 + i*25);
			}

			if (i >= 5) {
				hand.get(i).setPos(235, 10 + i*25 - 125 );
			}


		}

	}
	
	/**
	 *  Adds a card the the players hand
	 * @param card the card to be added
	 */
	public void hit(Card card) {	
		
		hand.add(card);
		
	}

	/**
	 * See hit()
	 * @param card 
	 */
	public void addCard(Card card) {

		hand.add(card);

	}
	
	/**
	 * Empties the players hand and clears all the cards
	 */
	public void reset() {
		
		for(Card card : hand) {
			
			if(this.getChildren().contains(card)) {
				
				this.getChildren().remove(card);
				
			}
			
		}
		
		hand.clear();
		
	}

	/**
	 * Returns the current score of the player
	 * @return player score
	 */
	public int getScore() {

		int score = 0;

		boolean containsEss = false;
		
		for(Card card: hand) {

			int temp = card.getValue();

			if (temp == 1) {
				temp = 11;
				containsEss = true;
			}else if (temp > 10) {
				temp = 10;
			}

			score += temp;

		}

		if ( score > 21 && containsEss) {
			score -= 10;
		}

		return score;

	}

}
