package cardDeck;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Solitaire extends Application{

	Group root = new Group();
	Scene scene = new Scene(root, 800, 450, Color.rgb(150, 190, 180));
	static Solitaire GAME;

	CardDeck deck;

	Foundation spadesF = new Foundation("spades");
	Foundation heartsF = new Foundation("hearts");
	Foundation clubsF = new Foundation("clubs");
	Foundation diamondsF = new Foundation("diamonds");

	@Override
	public void start(Stage primaryStage) throws Exception {
		Solitaire.GAME = this;
		deck = new CardDeck();
		System.out.println(Solitaire.GAME);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		setup();

		
		new AnimationTimer() {

			@Override
			public void handle(long now) {

				scene.setOnKeyPressed( event->{

					if (event.getCode() == KeyCode.SPACE) {

						Card card = deck.draw();
						card.setPos(300, 300);

						root.getChildren().add(card);   

					}

				});

				scene.setOnMouseClicked(event->{
					
					
					
				});
				
			}

		}.start();
	}

	public void moveCard(Card c) {
		
		root.getChildren().remove(c);
		
		if (c.getColorName().equals("spades")) {
			spadesF.addCard(c);
		}else if (c.getColorName().equals("hearts")) {
			heartsF.addCard(c);
		}else if (c.getColorName().equals("clubs")) {
			clubsF.addCard(c);
		}else if (c.getColorName().equals("diamonds")) {
			diamondsF.addCard(c);
		}
		
	}

	private void setup() {
		
		deck.shuffle();
		
		root.getChildren().add(spadesF);
		spadesF.setPos(715, 50);
		root.getChildren().add(heartsF);
		heartsF.setPos(715, 140);
		root.getChildren().add(clubsF);
		clubsF.setPos(715, 230);
		root.getChildren().add(diamondsF);
		diamondsF.setPos(715, 320);
	}

	public static void main(String[] args) {

		launch();

	}

	

}
