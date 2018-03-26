import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Obstacle extends Circle{

	public Obstacle() {
		
		this.setRadius(50+Math.random()*25);
		
		this.setTranslateX(this.getRadius()+(rocketStart.WINDOW_WIDTH-this.getRadius())*Math.random());
		this.setTranslateY(this.getRadius()+(rocketStart.WINDOW_HEIGHT-this.getRadius())*Math.random());
		
		this.setFill(Color.LIGHTGRAY);
		
	}
	
	public boolean hit(Shot shot) {
		
		if (this.getRadius() < 10) {
			this.setOpacity(0);
			return false;
		}
		
		if ( 
				Math.pow((shot.getTranslateX() - this.getTranslateX()), 2) +
				Math.pow((shot.getTranslateY() - this.getTranslateY()), 2) < Math.pow(this.getRadius(), 2)
				) {
			
			this.setRadius(this.getRadius() - 5);
			return true;		
		}else {
			
			return false;
			
		}
		//(x - center_x)^2 + (y - center_y)^2 < radius^2
		
	}
	
	public void getOpac() {
		
		
		
	}
	
}
