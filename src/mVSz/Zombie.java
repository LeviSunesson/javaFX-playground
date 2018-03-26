package mVSz;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Zombie extends Group{

	double xspeed = 2;

	Zombie() {
		
		this(Main.scene.getWidth()+100, 1);
		
	}
	
	Zombie(double xcoord, double dir) {

		Circle head = new Circle(8, 4, 3.6);
		head.setFill(Color.rgb(0, 102, 0));

		Line torso = new Line(8, 8, 8, 20);

		Line leftLegTop= new Line(8, 20, 6, 26);

		Line leftLegBot = new Line(6, 32, 6, 26);

		Line rightLegTop = new Line(8, 20, 8, 26);

		Line rightLegBot = new Line(10, 32, 8, 26);

		Line armTop = new Line(8, 10, 4, 12);

		Line armBot = new Line(0, 12, 4, 12);

		this.getChildren().addAll(
				head,
				torso,
				leftLegTop,
				leftLegBot,
				rightLegTop,
				rightLegBot,
				armTop,
				armBot
				);

		this.setScaleX(10);
		this.setScaleY(10);
		this.setTranslateX(xcoord);
		
		xspeed *= dir;
		
		this.setTranslateY(Main.scene.getHeight()*3/4-100);


	}
	
	public void turn() {
		
		this.setScaleX(-10);
		
	}

	public void update() {

		this.setTranslateX(this.getTranslateX()-xspeed);

	}

	public void kill() {
		this.setTranslateX(Main.scene.getWidth()+1000);
		
	}

}
