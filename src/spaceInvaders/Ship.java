package spaceInvaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Ship extends Polygon{

	double xspeed = 0;
	
	double x = SpaceInvaders.WIDTH/2-30;

	Ship() {

		this.getPoints().addAll(
				30.0, 10.0,	//A
				10.0, 30.0,	//B
				10.0, 00.0,	//C
				05.0, 00.0,	//D
				05.0, 35.0,	//E
				00.0, 40.0,	//F
				00.0, 50.0,	//G
				60.0, 50.0,	//H
				60.0, 40.0,	//I
				55.0, 35.0,	//J
				55.0, 00.0,	//K
				50.0, 00.0,	//L
				50.0, 30.0	//M
				);

		this.setFill(Color.WHITE);

		this.setTranslateX(x);
		this.setTranslateY(SpaceInvaders.HEIGHT-100);
	}

	public void update() {

		x += this.xspeed;
		x = constrain(x, 0, SpaceInvaders.WIDTH - 60);
		xspeed = 0;
		this.setTranslateX(x);

	}

	public void fly(double steps) {

		xspeed = steps;

	}

	public double canon() {

		return this.getTranslateX() + 7.5;

	}

	private double constrain(double constrained, double min, double max) {

		if (constrained <= min) {

			constrained += SpaceInvaders.step;

		}

		if (constrained >= max) {

			constrained -= SpaceInvaders.step;

		}

		return constrained;

	}

}
