package miniGolf;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GolfBall extends Circle{

	double y, x, yspeed, xspeed;

	GolfBall(){

		this(10, 10);

	}

	GolfBall(double xcoord, double ycoord){

		this.setRadius(10);
		this.setFill(Color.GREY);

		x = xcoord;
		y = ycoord;

	}

	public void update() {

		//edges();

		x += xspeed;
		y += yspeed;

		xspeed *= 0.98;
		yspeed *= 0.98;

		if (yspeed > 0 && yspeed < 0.01) {
			yspeed = 0;
		}
		if (yspeed < 0 && yspeed > -0.01) {
			yspeed = 0;
		}
		if (xspeed > 0 && xspeed < 0.01) {
			xspeed = 0;
		}
		if (xspeed < 0 && xspeed > -0.01) {
			xspeed = 0;
		}

		this.setTranslateX(x);
		this.setTranslateY(y);


	}

	public void shoot(double angle, double speed) {

		xspeed = speed * 2.5 * Math.cos(Math.toRadians(angle));
		yspeed = speed * 2.5 * Math.sin(Math.toRadians(angle));

	}

	public void edges() {

		if (y < 0) {
			yspeed *= -1;
			y += 5;
		}

		if (y > 600) {
			yspeed *= -1;
			y -= 5;
		}

		if (x < 0) {
			xspeed *= -1;
			x += 5;
		}

		if (x > 600) {
			xspeed *= -1;
			x -= 5;
		}


	}

	public void hit(Edge e) {

		if( this.y < e.y + e.height 	&&
				this.y > e.y			&&
				this.x < e.x + e.width 	&&
				this.x > e.x
				) {

			xspeed *= -1;
			yspeed *= -1;

		}


	}

}
