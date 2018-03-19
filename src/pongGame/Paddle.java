package pongGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle{

	double x;
	double h = 75;
	double y = Pong.HEIGHT/2 - h/2;
	double w = 10;
	
	double ychange = 0;
	
	Paddle(double x_) {
		
		this.x = x_;
		
		this.setHeight(h);
		this.setWidth(w);
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.setFill(Color.WHITE);
		
	}
	
	public void move(double steps) {
		
		ychange = steps;
		
	}
	
	private double constrain(double constrained, double min, double max) {
		
		if (constrained <= min) {
			
			constrained += Pong.step;
			
		}
		
		if (constrained >= max) {
			
			constrained -= Pong.step;
			
		}
		
		return constrained;
		
	}

	public void update() {
		y += this.ychange;
		y = constrain(y, 0, Pong.HEIGHT - h);
		ychange = 0;
		this.setTranslateY(y);
		
	}
	
}
