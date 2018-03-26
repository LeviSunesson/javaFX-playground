import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class Rocket extends Group {

	double x = rocketStart.WINDOW_WIDTH / 4;

	double y = rocketStart.WINDOW_HEIGHT / 2;

	double xspeed = 0;
	double yspeed = 0;

	public Rocket() {
		this(75);
	}

	public Polygon flame = new Polygon(-4*15, -0.2*15, -4.8*15, 0*15, -4*15, 0.2*15);

	public Polygon greatFlame = new Polygon(-4*15, -0.5*15, -5*15, -0.2*15, -4.4*15, 0*15, -5*15, 0.2*15, -4*15, 0.5*15);

	public Polygon body = new Polygon(
			-4*15, -0.5*15,
			-5*15, -1*15,
			-5*15, -2*15,
			-3*15, -1*15,
			-1*15, -1*15,
			0*15, 0*15,
			-1*15, 1*15,
			-3*15, 1*15,
			-5*15, 2*15,
			-5*15, 1*15,
			-4*15, 0.5*15
			);

	public Rocket(double width) {

		body.setFill(Color.WHEAT);
		flame.setFill(Color.RED);
		flame.setOpacity(0);

		greatFlame.setFill(Color.ORANGE);
		greatFlame.setOpacity(0);

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

		this.yspeed = Math.sin(deg) * 2;
		this.xspeed = Math.cos(deg) * 2;

		for (Obstacle o : rocketStart.obstacles) {

			double minx = this.getBoundsInParent().getMinX();
			double miny = this.getBoundsInParent().getMinY();

			for (Node n : this.getChildren()) {
				minx += n.getBoundsInParent().getMinX();
				miny += n.getBoundsInParent().getMinY();
				double width = n.getBoundsInParent().getWidth();
				double height = n.getBoundsInParent().getHeight();

				if (o.getBoundsInParent().intersects(minx,miny,width,height)) {

					//System.out.println("x: " + minx + "      y: " + miny);
				}
			}
		}
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

		double lenthdiff = 2.5 * 15;

		double angle = Math.toRadians(this.getRotate());

		return this.x + Math.cos(angle) * lenthdiff;

	}

	public double getTipY() {


		double lenthdiff = 2.5 * 15;

		double angle = Math.toRadians(this.getRotate());

		return this.y + Math.sin(angle) * lenthdiff;

	}

	public void edges() {

		if (this.getTranslateX() > rocketStart.WINDOW_WIDTH) {
			this.x = 0;
		} else if (this.getTranslateX() < -rocketStart.ROCKET_SIZE) {
			this.x = rocketStart.WINDOW_WIDTH;
		}

		if (this.getTranslateY() > rocketStart.WINDOW_HEIGHT) {
			this.y = 0;
		} else if (this.getTranslateY() < -rocketStart.ROCKET_SIZE) {
			this.y = rocketStart.WINDOW_HEIGHT;
		}

	}

	public void kaos() {

		body.setFill(Color.hsb(Math.random() * 360, Math.random(), 1));

	}

	public Paint getColor() {

		return body.getFill();
	}

}
