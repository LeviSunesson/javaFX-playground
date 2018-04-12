package blackJack;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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

	int BOTvalue = 0;

	Text value = new Text();
	Text botvalue = new Text();
	
	Text endText = new Text();

	ArrayList<Card> cards = new ArrayList<Card>();
	ArrayList<Card> botCards = new ArrayList<Card>();

	@Override
	public void start(Stage arg0) throws Exception {

		arg0.setScene(scene);
		arg0.show();
		arg0.setResizable(false);

		setup();

		new AnimationTimer() {

			@Override
			public void handle(long arg0) {

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
	
	private void botUpdate() {
		
		for (Card c : botCards) {
			
			if (!root.getChildren().contains(c)) {
				root.getChildren().add(c);
			}
		}
		
		for (int i = 0; i < botCards.size(); i++) {

			botCards.get(i).setPos(i*100 + 500, 100);

		}

		botvalue.setText("Value: " + BOTvalue);
		
	}
	
	private boolean checkEnd() {
		
		if (VALUE > 21 ) {

			for(Card c : cards) {

				if (c.getValue() == 1) {
					VALUE -= 10;
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
			}

			if (temp > 10) {
				temp = 10;
			}

			VALUE += temp;

		}
		
	}

	private void setup() {

		Rectangle middleDiv = new Rectangle(400, 0, 10, 450);
		middleDiv.setFill(Color.BLACK);

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
		
		endText.setTranslateX(200);
		endText.setTranslateY(400);
		endText.setScaleX(5);
		endText.setScaleY(5);

		value.setTranslateX(100);
		value.setTranslateY(300);
		value.setScaleX(5);
		value.setScaleY(5);
		botvalue.setTranslateX(500);
		botvalue.setTranslateY(300);
		botvalue.setScaleX(5);
		botvalue.setScaleY(5);

		root.getChildren().addAll(value, endText, middleDiv, botvalue);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
