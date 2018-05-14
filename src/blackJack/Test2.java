package blackJack;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test2 extends Application{

	Group root = new Group();

	Scene scene = new Scene(root, 800, 450, Color.WHITE);

	Player player1 = new Player(50, 50);

	Dealer dealer = new Dealer(450, 50);

	boolean dealt = false;

	static CardDeck deck = new CardDeck();

	public static boolean dealerT = false;
	
	@Override
	public void start(Stage arg0) throws Exception {

		player1.deactivateHit();
		dealer.deactivateHit();
		
		arg0.setScene(scene);
		arg0.show();
		arg0.setTitle("test2");

		deck.shuffle();

		Button dealButton = new Button("DEAL");
		dealButton.setTranslateX(300);
		dealButton.setTranslateY(300);
		dealButton.setMinWidth(200);
		dealButton.setMinHeight(100);
		dealButton.setStyle(
				  "-fx-background-color: rgba(0, 0, 0, 0.5);"
				+ "-fx-text-fill: black;"
				+ "-fx-background-radius: 0 0 0 0;"
				+ "-fx-border-radius:0 0 0 0;"
				+ "-fx-width: 200px;"
				+ "-fx-height: 100px;"
				+ "-fx-font-size: 50px;");

		dealButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				if (!dealt) {
					
					player1.activateHit();
					dealer.activateHit();
					
					player1.hit(deck.draw());
					player1.hit(deck.draw());

					dealer.hit(deck.draw());
					dealer.hit(deck.draw());
					
					dealt = true;
				}



			}
		});

		player1.setName("BaoK");

		root.getChildren().addAll(player1, dealer, dealButton);

		new AnimationTimer() {

			@Override
			public void handle(long arg0) {

				if (dealerT || player1.getScore() >= 21) {
					dealerTurn();
				}
				
				player1.update();
				dealer.update();
				
			}

		}.start();

	}

	public void dealerTurn() {
		
		player1.deactivateHit();
		
		if (player1.getScore() > 21) {
			checkWin(player1, dealer);
		}else if (dealer.getScore() < 17) {
			dealer.hit(deck.draw());
		}else if (dealer.getScore() > 16) {
			checkWin(player1, dealer);
		}
		
	}

	private void checkWin(Player player, Dealer dealer) {

		if (player.getScore() == 21) {
			
			/*
			 * new scene
			 * player won
			 * play again?
			 */
			
			System.out.println("player won");
		}else if ((21-player.getScore()) < (21-dealer.getScore()) && player.getScore() < 21) {
			
			/*
			 * new scene
			 * player won
			 * play again?
			 */
			
			System.out.println("player won");
		}else if((21-player.getScore()) > (21-dealer.getScore()) && player.getScore() < 21) {
			
			/*
			 * new scene
			 * dealer won
			 * play again?
			 */
			
			System.out.println("dealer won");
		}else if (player.getScore() > 21 && dealer.getScore() < 21) {
			
			System.out.println("dealer won");
			
		}else if (player.getScore() < 21 && dealer.getScore() > 21) {
			
			System.out.println("player won");
			
		}else {
			
			/*
			 * new scene
			 * dealer won
			 * play again?
			 */
			
			System.out.println("dealer won");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
