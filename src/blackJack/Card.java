package blackJack;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Group{

	private String COLOR;
	private int VALUE;
	private int COLOUR;
	

	private Rectangle backside = new Rectangle(45, 80, Color.GREY);

	/**
	 * Changes the position of the card to x, y
	 * @param x new x coordinate
	 * @param y new y coordinate
	 */
	public void setPos(double x, double y) {

		this.setTranslateX(x);
		this.setTranslateY(y);

	}

	/**
	 * 
	 * @return The value of the color of the card as a number
	 */
	public int getColorValue() {

		return COLOUR;

	}

	/**
	 * 
	 * @return The name of the color of the card as a String
	 */
	public String getColorName() {

		return COLOR;

	}

	/**
	 * 
	 * @return The value of the card
	 */
	public int getValue() {

		return VALUE;

	}
	
	/**
	 * Flips the card so you only see a grey square instead of the front of the card
	 */
	public void flip() {

		if (backside.getOpacity() < 0.5 ) {
			backside.setOpacity(1);
		}else if (backside.getOpacity() > 0.5) {
			backside.setOpacity(0);
		}

	}

	/**
	 * Creates a new card from a color (a) and a value (b)
	 * @param a the color of the new card
	 * @param b the value of the new card
	 */
	public Card(int a, int b) {


		this.getChildren().add(backside);
		
		backside.setOpacity(0);
		backside.setArcHeight(10);
		backside.setArcWidth(10);
		
		this.setOnMouseClicked(event->{

		});
		
		COLOUR = a;

		// Limits the values acquired
		if (a > 4)a = 4;
		if (a < 1)a = 1;
		if (b > 13)b = 13;
		if (b < 1) b = 1;
		this.VALUE = b;

		Text value = new Text(" " + VALUE);

		value.setTranslateX(30);
		value.setTranslateY(13);

		if (VALUE == 10) {
			value.setText("10");
		}
		if (VALUE == 11) {
			value.setText(" J");
		}
		if (VALUE == 12) {
			value.setText(" Q");
		}
		if (VALUE == 13) {
			value.setText(" K");
		}
		if (VALUE == 1) {
			value.setText(" A");
		}

		Rectangle background = new Rectangle(0, 0, 45, 80);
		Rectangle top = new Rectangle(0, 20, 45, 60);

		background.setArcHeight(10);
		background.setArcWidth(10);

		top.setArcHeight(10);
		top.setArcWidth(10);

		background.setFill(Color.DARKGREY);
		top.setFill(Color.LIGHTGRAY);

		this.getChildren().addAll(background, top, value);

		// This switch case controls the shield of the card
		switch (a) {
		case 1:
			COLOR = "spades";
			value.setStroke(Color.BLACK);
			value.setFill(Color.BLACK);

			Polygon spades = new Polygon( 20, 0,
					40, 20, 40, 25, 35, 30,
					25, 30, 22, 27, 22, 34,
					25, 40, 15, 40, 18, 34,
					18, 27,15, 30, 5,  30,
					0, 25, 0, 20 );
			spades.setFill(Color.BLACK);
			spades.setTranslateX(2.5);
			spades.setTranslateY(30);

			Polygon spades2 = new Polygon( 5, 0,
					10, 5, 10, 6.25, 8.75, 7.5,
					6.25, 7.5, 5.5, 6.75, 5.5, 8.5,
					6.25, 10, 3.75, 10, 4.5, 8.5,
					4.5, 6.75, 3.75, 7.5, 1.25,  7.5,
					0, 6.25, 0, 5 );
			spades2.setFill(Color.BLACK);
			spades2.setTranslateX(3);
			spades2.setTranslateY(3);

			this.getChildren().addAll(spades, spades2);
			break;
		case 2:
			COLOR = "hearts";
			value.setStroke(Color.RED);
			value.setFill(Color.RED);

			Polygon hearts = new Polygon( 20, 40, 40, 18,
					40, 8, 32, 0, 28, 0, 20, 8,
					12, 0, 8, 0, 0, 8, 0, 18 );
			hearts.setFill(Color.RED);
			hearts.setTranslateX(2.5);
			hearts.setTranslateY(30);

			Polygon hearts2 = new Polygon( 5, 10, 10, 4.5,
					10, 2, 8, 0, 7, 0, 5, 2,
					3, 0, 2, 0, 0, 2, 0, 4.5 );
			hearts2.setFill(Color.RED);
			hearts2.setTranslateX(3);
			hearts2.setTranslateY(3);

			this.getChildren().addAll(hearts, hearts2);

			break;
		case 3:
			COLOR = "clubs";
			value.setStroke(Color.BLACK);
			value.setFill(Color.BLACK);

			Polygon clubs = new Polygon( 40, 20,
					40, 25, 35, 30, 28.5, 30,
					25, 27, 24, 28, 27.5, 40,
					12.5, 40, 16, 28, 15, 27,
					11.5, 30, 5, 30, 0, 25,
					0, 20, 5, 15, 11.5, 15,
					15, 18, 16, 17, 12.5, 14,
					12.5, 5, 17.5, 0, 22.5, 0,
					27.5, 5, 27.5, 14, 24, 17,
					25, 18, 28.5, 15, 35, 15);

			clubs.setFill(Color.BLACK);
			clubs.setTranslateX(2.5);
			clubs.setTranslateY(30);

			Polygon clubs2 = new Polygon( 10, 5,
					10, 6.25, 8.75, 7.5, 7.125, 7.5,
					6.25, 6.75, 6, 7.125, 6.875, 10,
					3.125, 10, 4, 7, 3.75, 6.75,
					2.875, 7.5, 1.25, 7.5, 0, 6.25,
					0, 5, 1.25, 3.75, 2.875, 3.75,
					3.75, 4.5, 4, 4.25, 3.125, 3.5,
					3.125, 1.25, 4.375, 0, 5.625, 0,
					6.875, 1.25, 6.875, 3.5, 6, 4.25,
					6.25, 4.5, 7.125, 3.75, 8.75, 3.75);

			clubs2.setFill(Color.BLACK);
			clubs2.setTranslateX(3);
			clubs2.setTranslateY(3);

			this.getChildren().addAll(clubs, clubs2);

			break;
		case 4:
			COLOR = "diamonds";
			value.setStroke(Color.RED);
			value.setFill(Color.RED);

			Polygon diamonds = new Polygon(20, 0, 40, 20, 20, 40, 0, 20);
			diamonds.setFill(Color.RED);
			diamonds.setTranslateX(2.5);
			diamonds.setTranslateY(30);

			Polygon diamonds2 = new Polygon(5, 0, 10, 5, 5, 10, 0, 5);
			diamonds2.setFill(Color.RED);
			diamonds2.setTranslateX(3);
			diamonds2.setTranslateY(3);

			this.getChildren().addAll(diamonds, diamonds2);

			break;
		default:
			break;
		}

	}

}