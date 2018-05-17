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

public class BlackJack extends Application {

	private int WINS = 0;
	
	Group startGroup = new Group();
	static Group root = new Group();
	Group endGroup = new Group();

	Scene startScene = new Scene(startGroup, 800, 450, Color.WHITE);
	static Scene scene = new Scene(root, 800, 450, Color.WHITE);
	Scene endScene = new Scene(endGroup, 800, 450, Color.WHITE);

	Player player1 = new Player(50, 50, "PLAYER");

	Dealer dealer = new Dealer(450, 50);

	boolean dealt = false;

	static CardDeck deck = new CardDeck();

	public static boolean dealerT = false;

	Stage stage;
	AnimationTimer AT;

	@Override
	public void start(Stage arg0) throws Exception {

		//Basic setup
		
		stage = arg0;

		player1.deactivateHit();
		dealer.deactivateHit();

		startScene();

		mainScene();
		
		stage.setScene(startScene);
		stage.show();
		stage.setTitle("BlackJack");

	}

	/**
	 * Sets up the main scene for the game
	 */
	private void mainScene() {

		deck.shuffle();

		//Deal button for initializing the game, and styling
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

		//If button is pressed the deal cards and start game
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
					
					AT.start();
				}

			}
		});

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

	/**
	 * Calculates what to do based on current scores in the game
	 */
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

	/**
	 * Sets up the end scene
	 * @param winner the player who won
	 */
	private void endScene(Player winner) {

		endGroup.getChildren().clear();

		reset();
		dealt = false;
		player1.update();
		dealer.update();

		player1.deactivateHit();
		dealer.deactivateHit();

		//Text for number of wins, and styling
		Text totWins = new Text("wins: " + WINS);
		totWins.setFont(new Font(100));
		totWins.setTranslateX(scene.getWidth()/2 - totWins.getLayoutBounds().getWidth()/2);
		totWins.setTranslateY(200);
		
		//Text and styling for who won
		Text winnerText = new Text(winner.getName() + " WON!");
		winnerText.setFont(new Font(100));
		winnerText.setTranslateX(scene.getWidth()/2 - winnerText.getLayoutBounds().getWidth()/2);
		winnerText.setTranslateY(100);

		//Play again button, and styling
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

		//If button is pressed then start game again 
		playAgain.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				stage.setScene(scene);

			}
		});

		endGroup.getChildren().addAll(winnerText, playAgain, totWins);


	}
	
	/**
	 * Sets up the start scene of the game
	 */
	private void startScene() {

		//Text and styling
		Text welcomeText = new Text("Welcome to blackJack!");
		welcomeText.setTranslateX(0);
		welcomeText.setTranslateY(100);
		welcomeText.setFont(new Font(50));

		//Button and styling
		Button startButton = new Button("START");
		startButton.setTranslateX(300);
		startButton.setTranslateY(300);
		startButton.setMinWidth(200);
		startButton.setMinHeight(100);
		startButton.setStyle(
				"-fx-background-color: rgba(0, 0, 0, 0.5);"
						+ "-fx-text-fill: black;"
						+ "-fx-background-radius: 0 0 0 0;"
						+ "-fx-border-radius:0 0 0 0;"
						+ "-fx-width: 200px;"
						+ "-fx-height: 100px;"
						+ "-fx-font-size: 25px;");

		// If the button is pressed start the game scene
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				stage.setScene(scene);

			}
		});

		startGroup.getChildren().addAll(welcomeText, startButton);


	}
	
	/**
	 * Checks who won the game based on a series of rules
	 * @param player The player of the game
	 * @param dealer The dealer of the game
	 */
	private void checkWin(Player player, Dealer dealer) {

		if (player.getScore() == 21) {

			Winner(player);

		}else if ((21-player.getScore()) < (21-dealer.getScore()) && player.getScore() < 21) {

			Winner(player);

		}else if (player.getScore() < 21 && dealer.getScore() > 21) {

			Winner(player);

		}else if((21-player.getScore()) > (21-dealer.getScore()) && player.getScore() < 21) {

			Winner(dealer);

		}else if (player.getScore() > 21 && dealer.getScore() < 21) {

			Winner(dealer);

		}else {

			Player tie = new Player("NO ONE");
			
			Winner(tie);

		}

	}

	/**
	 * Resets the game to the start
	 */
	private void reset() {

		deck.reset();
		player1.reset();
		dealer.reset();		

		deck.shuffle();
		
		dealt = false;
		dealerT = false;

	}

	/**
	 * Stops the game and saves the score then proceeds to the end scene
	 * @param winner The player who won
	 */
	private void Winner(Player winner) {
		
		// If the player won the score goes up
		if (winner.getName().equals("PLAYER")) {
			WINS++;
		}
		
		// Wait for 0.75 sec
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Stop the game and proceed to the end
		AT.stop();
		endScene(winner);
		stage.setScene(endScene);
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
