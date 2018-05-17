package blackJack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Dealer extends Player{
	
	/**
	 * Creates a new dealer with a basic UI
	 */
	Dealer(){
		
		this(0, 0);
		
	}
	
	/**
	 * Creates a new dealer with a basic UI
	 * @param x the x origin of the dealer on the screen
	 * @param y the y origin of the dealer on the screen
	 */
	Dealer(double x, double y){
		
		super(x, y);
		setName("DEALER");
		
		hitButton.setText("Stand");
	
		hitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				dealerTurn();

			}
		});
		
	}
	
	/**
	 * Adds a card to the dealers hand
	 */
	public void hit(Card card) {
		
		super.hit(card);
		
		hand.get(0).flip();
		
	}

	/**
	 * Activates the dealersTurn in the main game class
	 */
	private void dealerTurn() {
		
		BlackJack.dealerT = true;
		
	}
	
}
