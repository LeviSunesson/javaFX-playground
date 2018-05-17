package miniGolf;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Edge extends Group {

	float width = 10, height = 10;
	
	public float x, y;
	
	public Edge(float x, float y) {
		
		this.x = x;
		this.y = y;
		
		Rectangle body = new Rectangle(this.x, this.y, width, height);
		body.setFill(Color.BLACK);
		
		this.getChildren().add(body);
		
	}
	
}
