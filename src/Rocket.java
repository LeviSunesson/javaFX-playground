import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Rocket extends Group{

	double x = rocketStart.WINDOW_WIDTH/2;

	double y = rocketStart.WINDOW_HEIGHT/2;

	double xspeed = 0;
	double yspeed = 0;

	public Rocket() {
		this(75);
	}

	public Polygon flame = new Polygon(
			-4, -0.2,
			-4.8, 0,
			-4, 0.2
			);

	public Polygon greatFlame = new Polygon(
			-4, -0.5,
			-5, -0.2,
			-4.4, 0,
			-5, 0.2,
			-4, 0.5
			);

	public Rocket(double width) {

		Polygon body = new Polygon(
				-4, -0.5,
				-5, -1,
				-5, -2,
				-3, -1,
				-1, -1,
				
				0, 0,
				
				-1, 1,
				-3, 1,
				-5, 2,
				-5, 1,
				-4, 0.5
				);

		body.setFill(Color.WHEAT);
		flame.setFill(Color.RED);
		flame.setOpacity(0);

		greatFlame.setFill(Color.ORANGE);
		greatFlame.setOpacity(0);

		body.setScaleX(width/5);
		body.setScaleY(width/5);

		greatFlame.setTranslateX(flame.getTranslateX()-width/5*2+2);
		flame.setTranslateX(flame.getTranslateX()-width/5*2+2);

		greatFlame.setScaleX(width/5);
		greatFlame.setScaleY(width/5);

		flame.setScaleX(width/5);
		flame.setScaleY(width/5);
		this.getChildren().addAll(greatFlame, body, flame);

	}

	public void update() {

		x += this.xspeed;
		xspeed = 0;
		this.setTranslateX(x);

		y += this.yspeed;
		yspeed = 0;
		this.setTranslateY(y);

	}

	public void moveForward() {
		double deg = this.getRotate();
		deg = Math.toRadians(deg);

		this.yspeed = Math.sin(deg)*2;
		this.xspeed = Math.cos(deg)*2;
	}

	public void summonFlame() {

		flame.setOpacity(0.7);

	}

	public void removeFlame() {

		flame.setOpacity(0);

	}

	public void removeGFlame() {

		greatFlame.setOpacity(0);

	}

	public void boost() {
		yspeed *= 4;
		xspeed *= 4;

		greatFlame.setOpacity(0.7);

	}

	public double getTipX() {

		double scale = rocketStart.ROCKET_SIZE/5;

		double lenthdiff = 2.5*scale;

		double angle = Math.toRadians(this.getRotate());

		return this.x + Math.cos(angle)*lenthdiff;
		

	}

	public double getTipY() {

		double scale = rocketStart.ROCKET_SIZE/5;

		double lenthdiff = 2.5*scale;
		
		double angle = Math.toRadians(this.getRotate());

		return this.y + Math.sin(angle)*lenthdiff;
		

	}

}
