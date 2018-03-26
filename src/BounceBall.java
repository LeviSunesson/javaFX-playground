import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BounceBall extends Circle{

	double x, y;
	
	double angle = Math.random()*90+45;
	double speed = 10;
	
	double xspeed;
	double yspeed;
	
	double gravity = 0.2;
	
	BounceBall(){
		this.setRadius(Math.random()*25 + 25);
		
		int r = (int)(Math.random()*255);
		int g = (int)(Math.random()*255);
		int b = (int)(Math.random()*255);
		
		//this.setFill(Color.rgb(r, g, b, 0.8));
		this.setFill(Color.RED);
		this.setOpacity(0.8);
		this.setTranslateX(Math.random()*BounceCort.WIDTH);
		this.setTranslateY(Math.random()*BounceCort.HEIGHT/2);
		
		this.setRotate(angle);
		
	}

	public void update() {
		edges();
		fall();
		
		//this.setTranslateX(x);
		//this.setTranslateY(y);
		
	}
	
	private void fall() {
		
		double deg = this.getRotate();
		deg = Math.toRadians(deg);

		this.yspeed = Math.sin(deg)*speed;
		this.xspeed = Math.cos(deg)*speed;
		
		this.setTranslateY(this.getTranslateY() + yspeed);
		this.setTranslateX(this.getTranslateX() + xspeed);
		
		
	}
	
	private void edges() {
		
		if (this.getTranslateY() > BounceCort.HEIGHT ) {
			this.setRotate(360-this.getRotate());
		}
		if (this.getTranslateY() < 0) {
			this.setRotate(360-this.getRotate());
		}
		
		if (this.getTranslateX() > BounceCort.WIDTH) {
			this.setRotate(180-this.getRotate());
		}

		if (this.getTranslateX() < 0) {
			this.setRotate(180-this.getRotate());
		} 
		
	}
	
}