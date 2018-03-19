
package spaceInvaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet extends Circle{

	int r = 3;
	
	Bullet(double x,double y) {
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setRadius(r);
		this.setFill(Color.RED);
		
	}
	
	public void update() {
		
		this.setTranslateY(this.getTranslateY()-10);
		
	}
	
	public boolean hit(Enemy enemy) {
		
		if (this.getTranslateX()+45 >= enemy.getTranslateX() && this.getTranslateX()+45 <= enemy.getTranslateX() + 70) {
			if (this.getTranslateY() <= enemy.getTranslateY() + 35) {
				return true;
			}
		}
		return false;
	}

	public void remove() {
		this.setOpacity(0);
		
	}
	
}
