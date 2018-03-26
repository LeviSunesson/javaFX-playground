package mVSz;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class Shooter extends Group{

	protected boolean alive = true;

	Shooter() {
		
		Circle head = new Circle(4, 4, 3.6);
		head.setFill(Color.BLACK);
		
		Line torso = new Line(4, 8, 4, 20);
		
		Line leftLegTop= new Line(4, 20, 2, 26);

		Line leftLegBot = new Line(2, 32, 2, 26);

		Line rightLegTop = new Line(4, 20, 6, 26);

		Line rightLegBot = new Line(6, 32, 6, 26);
		
		Line armTop = new Line(4, 10, 6, 14);

		Line armBot = new Line(12, 14, 6, 14);
		
		Polygon gun = new Polygon(
				11, 13,
				16, 13,
				16, 14, 
				12, 14,
				12, 16,
				11, 16,
				11, 13
				);
		
		
		this.getChildren().addAll(
				head,
				torso,
				leftLegTop,
				leftLegBot,
				rightLegTop,
				rightLegBot,
				armTop,
				armBot,
				gun
				);
		
		this.setScaleX(10);
		this.setScaleY(10);
		this.setTranslateX(Main.scene.getWidth()/2);
		this.setTranslateY(Main.scene.getHeight()*3/4-100);
		
	}
	
	public double gunpointX() {
			
		return this.getTranslateX()+80;
		
	}
	
	public double gunpointY() {
		
		return this.getTranslateY()-15;
		
	}
	
	public double getDir() {
		
		if (this.getScaleX() < 0) {
			return -1;
		}else {
			return 1;
		}
	}
	
	public void turnLeft() {
		
		this.setScaleX(-10);
		
	}
	
	public double getWidth() {

		return 120;
		
	}
	
	public void turnRight() {
		
		this.setScaleX(10);
		
	}
	
	public void die() {
		
		alive = false;
		
	}
	
}
