package blackJack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Dealer extends Player{
	
	Dealer(){
		
		this(0, 0);
		
	}
	
	Dealer(double x, double y){
		
		super(x, y);
		setName("Dealer");
		
		hitButton.setText("Stand");
	
		hitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				dealerTurn();

			}
		});
		
	}
	
	public void hit(Card card) {
		
		super.hit(card);
		
		hand.get(0).flip();
		
	}
	
	private void dealerTurn() {
		
		Test2.dealerT = true;
		
	}
	
}
