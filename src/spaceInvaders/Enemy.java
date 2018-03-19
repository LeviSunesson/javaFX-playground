package spaceInvaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Enemy extends Polygon{

	boolean alive = true;
	
	Enemy(int x, int y) {
		
		this.getPoints().addAll(
				0.0, 1.0,	//A
				1.0, 0.0,	//B
				4.0, 0.0,	//C
				5.0, 2.0,	//D
				6.0, 0.0,	//E
				9.0, 0.0,	//F
				10.0, 1.0,	//G
				10.0, 3.0,	//H
				9.0, 5.0,	//I
				8.0, 4.0,	//J
				7.0, 5.0,	//K
				6.0, 4.0,	//L
				5.0, 5.0,	//M
				4.0, 4.0,	//N
				3.0, 5.0,	//O
				2.0, 4.0,	//P
				1.0, 5.0,	//Q
				0.0, 3.0 	//R
				);
		
		this.setScaleX(7);
		this.setScaleY(7);
		double color = Math.random();
		
		if (color < 0.33) {
			this.setFill(Color.rgb(255, 0, 255));
		} else if (color > 0.66) {
			this.setFill(Color.rgb(255, 255, 102));
		} else {
			this.setFill(Color.rgb(0, 255, 255));
		}
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
	}
	
	public void kill() {
		
		alive = false;
		this.setOpacity(0);
		
	}
	
}
