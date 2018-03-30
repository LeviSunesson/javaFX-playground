package miniGolf;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class AngleSlider extends Group{
	
	double x, y;
	boolean switcher = true;
	
	AngleSlider() {
		
		this(50, 50);
		
	}
	
	AngleSlider(double xcoord, double ycoord){
		
		x = xcoord;
		y = ycoord;
		
		Rectangle shown = new Rectangle(1, 50);
		Rectangle hidden = new Rectangle(1, 50);
		
		Polygon arrow = new Polygon(
				
				0, 0,
				-5, 7,
				5, 7
				);
		
		arrow.setFill(Color.BLACK);
		
		
		shown.setTranslateX(0);
		shown.setTranslateY(0);
		shown.setFill(Color.BLACK);
		
		hidden.setTranslateX(0);
		hidden.setTranslateY(-50);
		hidden.setOpacity(0);
		
		this.getChildren().addAll(hidden, shown, arrow);
		
		
	}
	
	public void update(double comX, double comY) {
		
		x = comX;
		y = comY;
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		pulseSize();
		
	}
	
	private void pulseSize() {
		
		if (switcher) {
			this.setScaleY(this.getScaleY()*1.01);
			if (this.getScaleY() >= 2.0) {
				switcher = false;
			}
		}
		
		if (!switcher) {
			this.setScaleY(this.getScaleY()*0.99);
			if (this.getScaleY() <= 0.25) {
				switcher = true;
			}
		}
		
	
		
	}
	
	public void rotateCw() {
		
	
		this.setRotate(this.getRotate() + 5);
		
	}
	
	public void rotateCCw() {
		
		this.setRotate(this.getRotate() - 5);
		
	}

	public double getRot() {
		
		return this.getRotate() - 90;
		
	}
	
	public void hide() {
		
		this.setOpacity(0);
		
	}
	
	public void resetSize() {
		
		this.setScaleY(1);
		
	}
	
	public void show() {
		
		this.setOpacity(1);
		
	}
	
	public double getPower() {
		
		return this.getScaleY();
		
	}
	
}
