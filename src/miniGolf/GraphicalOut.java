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

	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	GolfBall golfball = new GolfBall(300, 500);
	AngleSlider angleSlider = new AngleSlider(golfball.x, golfball.y);
	Goal goal = new Goal(300, 50);
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, 600, 600, Color.LIGHTBLUE);
		
		for (int i = 0; i <= 600; i += 10) {
			
			edges.add(new Edge(i, 0));
			edges.add(new Edge(i, 600));
			edges.add(new Edge(0, i));
			edges.add(new Edge(600, i));
			
		}
		
		for(Edge e : edges) {
			
			if (!root.getChildren().contains(e)) {
				root.getChildren().add(e);
			}
			
		}
		
		root.getChildren().addAll(goal, golfball, angleSlider);

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

				for(Edge e : edges) {
					
					golfball.hit(e);
					
				}
				
				if(goal.hit(golfball)) {
					
					golfball.xspeed = 0;
					golfball.yspeed = 0;
					golfball.x = goal.getTranslateX();
					golfball.y = goal.getTranslateY();
					
					angleSlider.hide();
					
					this.stop();
					
				}
				
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
				
				if (golfball.xspeed != 0 && golfball.yspeed != 0) {

					angleSlider.resetSize();
					
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
