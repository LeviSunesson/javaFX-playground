package blackJack;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test2 extends Application{

	Group root = new Group();
	Group endGroup = new Group();

	Scene scene = new Scene(root, 800, 450, Color.WHITE);
	Scene endScene = new Scene(endGroup, 800, 450, Color.WHITE);

	Player player1 = new Player(50, 50);

	Dealer dealer = new Dealer(450, 50);

	boolean dealt = false;

	static CardDeck deck = new CardDeck();

	public static boolean dealerT = false;

	Stage stage;
	AnimationTimer AT;

	@Override
	public void start(Stage arg0) throws Exception {

		stage = arg0;

		player1.deactivateHit();
		dealer.deactivateHit();

		stage.setScene(scene);
		stage.show();
		stage.setTitle("test2");

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

		player1.setName("Player");

		root.getChildren().addAll(player1, dealer, dealButton);

		AT = new AnimationTimer() {

			@Override
			public void handle(long arg0) {

				if (dealerT || player1.getScore() >= 21) {
					dealerTurn();
				}

				player1.update();
				dealer.update();

			}

		};

		AT.start();

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

	private void endScene(Player winner) {

		endGroup.getChildren().clear();
		
		reset();
		dealt = false;
		player1.update();
		dealer.update();
		
		player1.deactivateHit();
		dealer.deactivateHit();

		Text winnerText = new Text(winner.getName() + " WON!");
		winnerText.setTranslateX(0);
		winnerText.setTranslateY(100);
		winnerText.setFont(new Font(100));

		Button playAgain = new Button("PLAY AGAIN");
		playAgain.setTranslateX(300);
		playAgain.setTranslateY(300);
		playAgain.setMinWidth(200);
		playAgain.setMinHeight(100);
		playAgain.setStyle(
				"-fx-background-color: rgba(0, 0, 0, 0.5);"
						+ "-fx-text-fill: black;"
						+ "-fx-background-radius: 0 0 0 0;"
						+ "-fx-border-radius:0 0 0 0;"
						+ "-fx-width: 200px;"
						+ "-fx-height: 100px;"
						+ "-fx-font-size: 50px;");

		playAgain.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				stage.setScene(scene);

			}
		});

		endGroup.getChildren().addAll(winnerText, playAgain);


	}

	private void checkWin(Player player, Dealer dealer) {

		if (player.getScore() == 21) {

			playerWon();

		}else if ((21-player.getScore()) < (21-dealer.getScore()) && player.getScore() < 21) {

			playerWon();

		}else if (player.getScore() < 21 && dealer.getScore() > 21) {

			playerWon();

		}else if((21-player.getScore()) > (21-dealer.getScore()) && player.getScore() < 21) {

			dealerWon();

		}else if (player.getScore() > 21 && dealer.getScore() < 21) {

			dealerWon();

		}else {
			
			dealerWon();

		}

	}

	private void reset() {

		deck.reset();
		player1.reset();
		dealer.reset();		
		
		deck.shuffle();

	}

	private void dealerWon() {

		AT.stop();
		endScene(dealer);
		stage.setScene(endScene);

	}

	private void playerWon() {

		AT.stop();
		endScene(player1);
		stage.setScene(endScene);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
