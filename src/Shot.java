import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class Shot extends Circle{

	double xspeed = 0, yspeed = 0;
	
	int r = 3;

	Shot() {

		this(0, 0, 0, 0, 0, Color.RED);

	}

	Shot(double x,double y, double xspeed, double yspeed, double angle, Paint color) {

		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setRadius(r);
		this.setFill(color);


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
	
	public void edges() {
		
		if (this.getTranslateX() > rocketStart.WINDOW_WIDTH) {
			this.setTranslateX(0);
		} else if (this.getTranslateX() < 0) {
			this.setTranslateX(rocketStart.WINDOW_WIDTH);
		}

		if (this.getTranslateY() > rocketStart.WINDOW_HEIGHT) {
			this.setTranslateY(0);	
		} else if (this.getTranslateY() < 0) {
			this.setTranslateY(rocketStart.WINDOW_HEIGHT);
		}
		
	}

}
