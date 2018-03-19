import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Shot extends Circle{

	double xspeed = 0, yspeed = 0;

	int r = 3;

	Shot() {

		this(0, 0, 0, 0, 0);

	}

	Shot(double x,double y, double xspeed, double yspeed, double angle) {

		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setRadius(r);
		this.setFill(Color.RED);


		if (xspeed == 0 && yspeed == 0) {
			double deg = Math.toRadians(angle);
			this.yspeed = Math.sin(deg)*2.5;
			this.xspeed = Math.cos(deg)*2.5;
		}else {
			this.yspeed = yspeed * 1.5;
			this.xspeed = xspeed * 1.5;
		}

	}

	public void update() {

		this.setTranslateX(this.getTranslateX() + this.xspeed);

		this.setTranslateY(this.getTranslateY() + this.yspeed);

	}

	public void remove() {
		this.setOpacity(0);

	}

}
