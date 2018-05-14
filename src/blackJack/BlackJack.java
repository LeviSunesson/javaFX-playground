package blackJack;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BlackJack extends Application{

	Group root = new Group();

	Scene scene = new Scene(root, 800, 450, Color.WHITE);

	CardDeck deck = new CardDeck();

	int VALUE = 0;
	boolean removed = false;

	int BOTvalue = 0;
	boolean spawncard = false;

	Text value = new Text();
	Text botvalue = new Text();

	Text endText = new Text();
	Button nextTurn = new Button("Next Turn");
	Button spawnCardButton = new Button("Draw Card");

	ArrayList<Card> cards = new ArrayList<Card>();
	ArrayList<Card> botCards = new ArrayList<Card>();

	Player player1 = new Player();
	
	@Override
	public void start(Stage arg0) throws Exception {

		arg0.setScene(scene);
		arg0.show();
		arg0.setResizable(false);

		setup();

		new AnimationTimer() {

			@Override
			public void handle(long arg0) {

				nextTurn.setOnAction(new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent e) {

						if (spawncard == true) {
							spawnCard(KeyCode.SPACE);
							spawncard = false;
						}
						
						botDrawCard();

					}
				});
				spawnCardButton.setOnAction(new EventHandler<ActionEvent>(){
					@Override public void handle(ActionEvent d) {
						spawncard = true;
					}
				});

				botUpdate();

				for(Card c : cards) {

					if (!root.getChildren().contains(c)) {
						root.getChildren().add(c);
					}

				}
				for (int i = 0; i < cards.size(); i++) {

					cards.get(i).setPos(i*100 + 100, 100);

				}



				value.setText("Value: " + VALUE);

				scene.setOnKeyPressed(event ->{

					spawnCard(event.getCode());

				});

				if (checkEnd()) {
					this.stop();
				}

			}

		}.start();

	}
	
	private void botDrawCard() {
		
		if (BOTvalue < 21) {
			botCards.add(deck.draw());
			
			int temp = botCards.get(botCards.size()-1).getValue();

			if (temp == 1) {
				temp = 11;
			}else if (temp > 10) {
				temp = 10;
			}

			BOTvalue += temp;
			
		}
		
	}

	private void botUpdate() {
		
		for (Card c : botCards) {

			if (!root.getChildren().contains(c)) {
				root.getChildren().add(c);
			}
		}

		for (int i = 0; i < botCards.size(); i++) {

			botCards.get(i).setPos(i*100 + 100, 225+45);

		}

		botvalue.setText("Value: " + BOTvalue);

	}

	private boolean checkEnd() {

		if (VALUE > 21 && 21 < BOTvalue) {

			for(Card c : cards) {


				if (c.getValue() == 1 && !removed) {
					VALUE -= 10;
					removed = true;
				}

			}


			if (VALUE > 21) {
				endText.setText("You're FAT");
				return true;
			}

		}
		if (VALUE == 21) {
			endText.setText("You WON!");
			return true;
		}

		return false;

	}

	private void spawnCard(KeyCode kc) {

		if (kc == KeyCode.SPACE) {

			cards.add(deck.draw());


			int temp = cards.get(cards.size()-1).getValue();

			if (temp == 1) {
				temp = 11;
			}else if (temp > 10) {
				temp = 10;
			}

			VALUE += temp;

		}

	}

	private void setup() {

		Rectangle middleDiv = new Rectangle(0, 225, 800, 5);
		middleDiv.setFill(Color.BLACK);

		nextTurn.setTranslateX(scene.getWidth()/2 - nextTurn.getWidth());
		nextTurn.setTranslateY(scene.getHeight()/2 - nextTurn.getHeight());

		spawnCardButton.setTranslateX(scene.getWidth()/2 - spawnCardButton.getWidth()-100);
		spawnCardButton.setTranslateY(scene.getHeight()/2 - spawnCardButton.getHeight());


		deck.shuffle();

		root.setTranslateX(5);
		root.setTranslateY(5);

		cards.add(deck.draw());
		cards.add(deck.draw());

		botCards.add(deck.draw());
		botCards.add(deck.draw());

		for(Card c: cards) {

			int temp = c.getValue();
			if (temp == 1) {
				temp = 11;
			}else if (temp > 10) {
				temp = 10;
			}

			VALUE += temp;

		}

		for(Card c: botCards) {

			int temp = c.getValue();
			if (temp == 1) {
				temp = 11;
			}else if (temp > 10) {
				temp = 10;
			}

			BOTvalue += temp;

		}

		endText.setTranslateX(400);
		endText.setTranslateY(50);
		endText.setScaleX(5);
		endText.setScaleY(5);

		value.setTranslateX(100);
		value.setTranslateY(50);
		value.setScaleX(5);
		value.setScaleY(5);
		botvalue.setTranslateX(100);
		botvalue.setTranslateY(400);
		botvalue.setScaleX(5);
		botvalue.setScaleY(5);

		root.getChildren().addAll(value, endText, middleDiv, nextTurn, spawnCardButton, botvalue);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
