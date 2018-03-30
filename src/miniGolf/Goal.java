package miniGolf;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Goal extends Circle{

	public Goal(float x, float y) {

		this.setRadius(14);

		this.setFill(Color.BLACK);

		this.setTranslateX(x);
		this.setTranslateY(y);


	}

	public boolean hit(GolfBall gb) {

		if (
				gb.x > this.getTranslateX() - 9 &&
				gb.x < this.getTranslateX() + 9 &&
				gb.y > this.getTranslateY() - 9 &&
				gb.y < this.getTranslateY() + 9
				) {

			return true;

		}

		return false;

	}

}
