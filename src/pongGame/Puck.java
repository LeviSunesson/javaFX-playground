package pongGame;

//import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Puck extends Circle{

	double x = Pong.WIDTH/2;
	double y = Pong.HEIGHT/2;
	double xspeed;
	double yspeed;

	double r = 12;

	Puck(){

		this.setCenterX(x);
		this.setCenterY(y);
		this.setRadius(r);
		this.setFill(Color.WHITE);

		reset();

	}

	public void update() {
		// TODO Auto-generated method stub
		x = x + xspeed;
		y = y + yspeed;
		
		this.setCenterX(x);
		this.setCenterY(y);

	}

	public void reset() {

		x = Pong.WIDTH/2;
		y = Pong.HEIGHT/2;
		
		double angle = map(Math.random(), 0, 1, -1*Math.PI/4, Math.PI/4) ;
	    
	    xspeed = 5 * Math.cos(angle);
	    yspeed = 5 * Math.sin(angle);
	    
	    if (Math.random() < 0.5) {
	        xspeed *= -1;
	      }

	}

	public void edges() {

		if (y < 0 || y > Pong.HEIGHT) {
			yspeed *= -1;
		}

		if (x < 0) {
			Pong.rightScore++;
			reset();
		}
		
		if (x > Pong.WIDTH ) {
			Pong.leftScore++;
			reset();
		}

	}

	public void checkPaddleLeft(Paddle p) {
		if (
				this.y - r < p.y + p.h 	&&
				this.y + r > p.y 		&&
				this.x - r < p.x + p.w
				) {
			
		      if (x > p.x) {
		    	  
		    	  double diff = y - (p.y - p.h);
		          double rad = Math.toRadians(45);
		          double angle = map(diff, 0, p.h, -rad, rad);
		          xspeed = 5 * Math.cos(angle);
		          yspeed = 5 * Math.sin(angle);
		          x = p.x + p.w + r;
		    	  
				//xspeed *= -1;

			}			
		}
	}

	public void checkPaddleRight(Paddle p) {
		if (
				this.y - r < p.y + p.h 	&&
				this.y + r > p.y 		&&
				this.x + r > p.x
				
				) {
			if (x < p.x) {
				
				double diff = y - (p.y - p.h);
		        double angle = map(diff, 0, p.h, Math.toRadians(225), Math.toRadians(135));
		        xspeed = 5 * Math.cos(angle);
		        yspeed = 5 * Math.sin(angle);
		        x = p.x - r;
				
				//xspeed *= -1;
			}
		}
	}

	
	private double map(double value, double start1, double stop1, double start2, double stop2) {

		//	Re-maps a number from one range to another

		double R1 = stop1 - start1;
		
		double R2 = stop2 - start2;
		
		double procentsats = value/R1;
		
		double svar = R2*procentsats + ( start2 - R2);

		return svar;
	}

}
