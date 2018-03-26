package mVSz;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet extends Circle {

	double xspeed = 15;

	int r = 3;

	Bullet() {

		this(0, 0, 1);

	}

	Bullet(double x,double y, double direction) {

		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setRadius(r);
		this.setFill(Color.BLACK);
		this.xspeed *= direction;

	}

	public void update() {

		edges();
		this.setTranslateX(this.getTranslateX() + this.xspeed);

	}

	public void remove() {
		this.setOpacity(0);

	}

	public void edges() {

		if (this.getTranslateX() > Main.scene.getWidth()) {
			this.xspeed = 0;
			this.setOpacity(0);
		}

	}

	public boolean hit(Zombie z) {
		
		
		if (this.getTranslateX() == z.getTranslateX()) {		
			this.remove();
			this.xspeed = 0;
			this.setTranslateX(-1000);
			return true;
			
		}
		
		return false;
		
	}
	public double getOpac() {
		
		return this.getOpacity();
		
	}

}
