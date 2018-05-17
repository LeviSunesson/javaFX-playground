package cardDeck;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Solitaire extends Application{

	public static boolean CARDHL = false;

	Group root = new Group();
	Scene scene = new Scene(root, 800, 450, Color.BLACK);
	static Solitaire GAME;

	CardDeck deck;

	Foundation spadesF = new Foundation("spades");
	Foundation heartsF = new Foundation("hearts");
	Foundation clubsF = new Foundation("clubs");
	Foundation diamondsF = new Foundation("diamonds");

	Pile pile1 = new Pile();
	Pile pile2 = new Pile();
	Pile pile3 = new Pile();
	Pile pile4 = new Pile();
	Pile pile5 = new Pile();
	Pile pile6 = new Pile();
	Pile pile7 = new Pile();

	ArrayList<Pile> piles = new ArrayList<Pile>();
	ArrayList<Foundation> foundations = new ArrayList<Foundation>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Solitaire.GAME = this;
		deck = new CardDeck();
		root.setTranslateX(5);
		root.setTranslateY(5);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		setup();

		new AnimationTimer() {

			@Override
			public void handle(long now) {

				scene.setOnKeyPressed( event->{

					

				});

			}

		}.start();
	}



	public void moveCard(Card c) {

		CARDHL = true;
		c.highlight();

		scene.setOnMouseClicked(event->{

			double mouseX = event.getSceneX();
			double mouseY = event.getSceneY();

			if (mouseX >= 665) {
				if (c.getColorName().equals("spades")) {
					if (spadesF.addCard(c)) {

						root.getChildren().remove(c);
						CARDHL = false;
						c.deHl();

					}

				}else if (c.getColorName().equals("hearts")) {
					if (heartsF.addCard(c)) {

						root.getChildren().remove(c);
						CARDHL = false;
						c.deHl();

					}
				}else if (c.getColorName().equals("clubs")) {
					if (clubsF.addCard(c)) {

						root.getChildren().remove(c);
						CARDHL = false;
						c.deHl();

					}
				}else if (c.getColorName().equals("diamonds")) {
					if (diamondsF.addCard(c)) {

						root.getChildren().remove(c);
						CARDHL = false;
						c.deHl();

					}
				}
			}else if (
					pile1.getBoundsInParent().getMinX() < mouseX &&
					pile1.getBoundsInParent().getMaxX() > mouseX &&
					pile1.getBoundsInParent().getMinY() < mouseY &&
					pile1.getBoundsInParent().getMaxY() > mouseY
					) {

				if (pile1.addCard(c)) {

					root.getChildren().remove(c);
					CARDHL = false;
					c.deHl();

				}

			}else if (
					pile2.getBoundsInParent().getMinX() < mouseX &&
					pile2.getBoundsInParent().getMaxX() > mouseX &&
					pile2.getBoundsInParent().getMinY() < mouseY &&
					pile2.getBoundsInParent().getMaxY() > mouseY
					) {
				
				if (pile2.addCard(c)) {

					root.getChildren().remove(c);
					CARDHL = false;
					c.deHl();

				}

			}else if (
					pile3.getBoundsInParent().getMinX() < mouseX &&
					pile3.getBoundsInParent().getMaxX() > mouseX &&
					pile3.getBoundsInParent().getMinY() < mouseY &&
					pile3.getBoundsInParent().getMaxY() > mouseY
					) {

				if (pile3.addCard(c)) {

					root.getChildren().remove(c);
					CARDHL = false;
					c.deHl();

				}

			}else if (
					pile4.getBoundsInParent().getMinX() < mouseX &&
					pile4.getBoundsInParent().getMaxX() > mouseX &&
					pile4.getBoundsInParent().getMinY() < mouseY &&
					pile4.getBoundsInParent().getMaxY() > mouseY
					) {

				if (pile4.addCard(c)) {

					root.getChildren().remove(c);
					CARDHL = false;
					c.deHl();

				}

			}else if (
					pile5.getBoundsInParent().getMinX() < mouseX &&
					pile5.getBoundsInParent().getMaxX() > mouseX &&
					pile5.getBoundsInParent().getMinY() < mouseY &&
					pile5.getBoundsInParent().getMaxY() > mouseY
					) {

				if (pile5.addCard(c)) {

					root.getChildren().remove(c);
					CARDHL = false;
					c.deHl();

				}

			}else if (
					pile6.getBoundsInParent().getMinX() < mouseX &&
					pile6.getBoundsInParent().getMaxX() > mouseX &&
					pile6.getBoundsInParent().getMinY() < mouseY &&
					pile6.getBoundsInParent().getMaxY() > mouseY
					) {

				if (pile6.addCard(c)) {

					root.getChildren().remove(c);
					CARDHL = false;
					c.deHl();

				}

			}else if (
					pile7.getBoundsInParent().getMinX() < mouseX &&
					pile7.getBoundsInParent().getMaxX() > mouseX &&
					pile7.getBoundsInParent().getMinY() < mouseY &&
					pile7.getBoundsInParent().getMaxY() > mouseY
					) {

				if (pile7.addCard(c)) {

					root.getChildren().remove(c);
					CARDHL = false;
					c.deHl();

				}

			}

		});

	}

	private void setup() {

		Rectangle background = new Rectangle(0, 0, 800, 450);
		background.setFill(Color.rgb(150, 190, 180));
		root.getChildren().add(background);

		deck.shuffle();

		Rectangle foundationBack = new Rectangle(665, 0, 135, 450);
		foundationBack.setFill(Color.rgb(140, 170, 160, 1));
		root.getChildren().add(foundationBack);

		Rectangle SideMenuBackground = new Rectangle(0, 0, 135, 450);
		SideMenuBackground.setFill(Color.rgb(140, 170, 160, 1));
		root.getChildren().add(SideMenuBackground);

		piles.add(pile1);
		piles.add(pile2);
		piles.add(pile3);
		piles.add(pile4);
		piles.add(pile5);
		piles.add(pile6);
		piles.add(pile7);
		foundations.add(heartsF);
		foundations.add(clubsF);
		foundations.add(spadesF);
		foundations.add(diamondsF);

		for (Card c: deck.get()) {
			
			c.setPos(45, 45);
			root.getChildren().add(c);
			
		}
		
		for(Pile p : piles)root.getChildren().add(p);

		for(Foundation found : foundations)root.getChildren().add(found);

		pile1.setPos(152.5, 17.5);
		pile2.setPos(227.5, 17.5);
		pile3.setPos(302.5, 17.5);
		pile4.setPos(377.5, 17.5);
		pile5.setPos(452.5, 17.5);
		pile6.setPos(527.5, 17.5);
		pile7.setPos(602.5, 17.5);

		spadesF.setPos(715, 50);
		heartsF.setPos(715, 140);
		clubsF.setPos(715, 230);
		diamondsF.setPos(715, 320);

	}

	public static void main(String[] args) {

		launch();

	}



}
