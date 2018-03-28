package miniGolf;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraphicalOut extends Application {

	ArrayList<KeyCode> keys = new ArrayList<KeyCode>();

	GolfBall golfball = new GolfBall(300, 500);
	AngleSlider angleSlider = new AngleSlider(golfball.x, golfball.y);

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, 600, 600, Color.LIGHTBLUE);

		root.getChildren().addAll(golfball, angleSlider);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		scene.setOnKeyPressed( event->{

			if (!(keys.contains(event.getCode()))) {
				keys.add(event.getCode());	
			}	

		});

		scene.setOnKeyReleased( event->{

			keys.remove(event.getCode());			

		});

		new AnimationTimer() {

			@Override
			public void handle(long arg0) {

				golfball.update();
				angleSlider.update(golfball.x, golfball.y);

				for(KeyCode k : keys) {
					switch (k) {
					case Q:
						angleSlider.rotateCCw();
						break;
					case E:
						angleSlider.rotateCw();
						break;
					case SPACE:
						if (golfball.xspeed == 0 && golfball.yspeed == 0) {
							
							golfball.shoot(angleSlider.getRot(), angleSlider.getPower());
							
							angleSlider.hide();

						}
						break;
					default:
						break;
					}
				}
				
				if (golfball.xspeed == 0  && golfball.yspeed == 0 ) {
					
					angleSlider.show();

				}
				
			}

		}.start();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
