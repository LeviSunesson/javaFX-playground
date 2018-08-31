package flappyBird;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pipe extends Group{

	Pipe(double x, double y){
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		Rectangle top = new Rectangle(0, 0, 60, 20);
		top.setFill(Color.DARKGREEN);
		top.setStroke(Color.BLACK);
		top.setStrokeWidth(4);
		
		Rectangle main = new Rectangle(30-25, 20, 50, 200);
		main.setFill(Color.DARKGREEN);
		main.setStroke(Color.BLACK);
		main.setStrokeWidth(2);
		
		this.getChildren().addAll(top, main);
		
	}
	
}
