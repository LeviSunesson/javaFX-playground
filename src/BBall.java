import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BBall extends Circle{

	double x, y, yspeed, xspeed;

	BBall() {

		this(Math.random()*25+25, Math.random()*BounceCort.WIDTH, BounceCort.HEIGHT/4);

	}

	BBall(double radius, double startX, double startY){

		this.setRadius(radius);

		this.setFill(Color.rgb((int) (Math.random()*128), (int) (Math.random()*128), (int) (Math.random()*128)));
		this.setOpacity(0.8);
		
		this.x = startX;
		this.y = startY;

		yspeed = Math.random()*10;
		xspeed = Math.random()*6-3;
	}

	public void update() {
		fall();
		wind();
		this.setTranslateX(x);
		this.setTranslateY(y);
	}

	public  void fall() {
		y += yspeed;
		double grav = 0.5;
		yspeed = yspeed + grav;
		if (y > BounceCort.HEIGHT) {
			yspeed *= -1;
			yspeed += .6;
			y -= 5;
		}	
	}

	public void wind() {

		x += xspeed;
		if (x > BounceCort.WIDTH || x < 0) {
			xspeed*= -1;
		}
	}
}