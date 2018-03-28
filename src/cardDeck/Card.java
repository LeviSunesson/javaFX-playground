package cardDeck;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Group{

	private String COLOR;
	private int VALUE;

	public void setPos(double x, double y) {
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
	}
	
	public Card(int a, int b) {

		
		if (a > 4) {
			a = 4;
		}
		if (a < 1) {
			a = 1;
		}
		if (b > 14) {
			b = 14;
		}
		if (b < 2) {
			b = 2;
		}
		this.VALUE = b;

		switch (a) {
		case 1:
			COLOR = "spades";
			break;
		case 2:
			COLOR = "hearts";
			break;
		case 3:
			COLOR = "clubs";
			break;
		case 4:
			COLOR = "diamonds";
			break;
		default:
			break;
		}
		
		Text color = new Text(COLOR);
		Text value = new Text(""+ VALUE);
		
		if (a == 2 || a == 4) {
			color.setStroke(Color.RED);
			value.setStroke(Color.RED);
			value.setFill(Color.RED);
		}else {
			color.setStroke(Color.BLACK);
			value.setStroke(Color.BLACK);
			value.setFill(Color.BLACK);
		}
		
		value.setTranslateX(22.5 - (value.getBoundsInLocal().getWidth()/2));
		value.setTranslateY(45);
		value.setScaleX(3.5);
		value.setScaleY(3.5);
		
		
		color.setTranslateX(22.5 - (color.getBoundsInLocal().getWidth()/2));
		color.setTranslateY(10);
		
		
		if (VALUE == 11) {
			value.setText("J");
		}
		if (VALUE == 12) {
			value.setText("Q");
		}
		if (VALUE == 13) {
			value.setText("K");
		}
		if (VALUE == 14) {
			value.setText("A");
		}
		
		Rectangle background = new Rectangle(0, 0, 45, 80);
		background.setFill(Color.WHITE);
		
		this.getChildren().addAll(background, color, value);
		
	}

}