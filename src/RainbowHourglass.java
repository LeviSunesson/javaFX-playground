import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RainbowHourglass extends Application {

	ArrayList<Line> lines = new ArrayList<Line>();

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();

		primaryStage.setScene(new Scene(root, 600, 400, Color.BLACK));
		primaryStage.show();

		for (int i = 0; i < 400; i++) {
			lines.add(new Line( 600-i*1.5, 400-i, 0, 400 ));
			lines.get(lines.size()-1).setStroke( Color.hsb(map(i, 0, 400, 360, 0), 0.9, 1) );	
			lines.add(new Line( 600-i*1.5, 400-i, 600, 0 ));
			lines.get(lines.size()-1).setStroke( Color.hsb(map(i, 0, 400, 360, 0), 0.9, 1) );	
		}

		for(Line l : lines) {
			l.setStrokeWidth(3);
			if (!root.getChildren().contains(l)) {
				root.getChildren().add(l);
			}
			
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	public double map(double value, double start1, double stop1, double start2, double stop2) {

		return (stop2 - start2) * (value/(stop1 - start1)) + ( start2 - (stop2 - start2));
		
	}

}