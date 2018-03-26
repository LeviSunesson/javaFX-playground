import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class rocketStart extends Application{
	public static final double WINDOW_WIDTH = 1600;
	public static final double WINDOW_HEIGHT = 900;
	public static final double ROCKET_SIZE = 75;

	private short btime = 0;

	public static final ArrayList<KeyCode> keys = new ArrayList<KeyCode>();

	public ArrayList<Shot> shots  = new ArrayList<Shot>();
	public static ArrayList<Obstacle> obstacles  = new ArrayList<Obstacle>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();

		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.BLACK);

		for (int rows = 0; rows < 100; rows++) {
			for (int cols = 0; cols < 100; cols++) {
				if (Math.random() > 0.99) {
					Circle star = new Circle(WINDOW_WIDTH/100*rows, WINDOW_HEIGHT/100*cols, 1, Color.YELLOW);
					root.getChildren().add(star);
				}
			}
		}
		
		Rocket rocket = new Rocket(ROCKET_SIZE);

		root.getChildren().add(rocket);

		scene.setOnKeyPressed(event -> {

			if (!keys.contains(event.getCode())) {
				keys.add(event.getCode());
			}

		});

		scene.setOnKeyReleased(event -> {

			if (keys.contains(event.getCode())) {

				keys.remove(event.getCode());

				if (event.getCode().equals(KeyCode.SPACE)) {
					rocket.removeFlame();
				}
				if (event.getCode().equals(KeyCode.ENTER)) {
					rocket.removeGFlame();
				}
			}
		});
		
		for (int i = 0; i < 10; i++) {
			obstacles.add(new Obstacle());
			root.getChildren().add(obstacles.get(i));
		}

		AnimationTimer at = new AnimationTimer() {

			@Override
			public void handle(long now) {

				for(Obstacle o : obstacles) {
					for(Shot s : shots) {
						
						if (o.hit(s)) {
							s.remove();
							s.xspeed = 0;
							s.yspeed = 0;
						}
					}
				}
				
				

				for (Shot s : shots) {
					if (!root.getChildren().contains(s)) {
						root.getChildren().add(s);
					}
					s.update();
					
					//s.edges();
					
				}

				for (int i = 0; i < keys.size(); i++) {

					KeyCode key = keys.get(i);

					switch (key) {

					case ENTER:
						if (rocket.xspeed != 0 || rocket.yspeed != 0) {
							rocket.boost();							
						}

						break;
					case SPACE:
						rocket.moveForward();
						rocket.summonFlame();
						break;
					case E:
						rocket.setRotate(rocket.getRotate() + 2);
						break;
					case Q:
						rocket.setRotate(rocket.getRotate() - 2);
						break;
					case K:
						rocket.kaos();
						break;
					default:
						break;
					}
					if (keys.get(i) == KeyCode.B && btime == 0) {
						btime = 60/2;
						shots.add(new Shot(rocket.getTipX() , rocket.getTipY() , rocket.xspeed, rocket.yspeed, rocket.getRotate(), rocket.getColor()));
					}

					rocket.edges();

				}

				removeBullets();

				bTimer();

				rocket.update();

			}

		};

		at.start();

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private void removeBullets() {
		
		/*if (shots.size() > 5) {
			shots.get(0).remove();
			shots.remove(0);
			
		}
		
		/*/for (int i = shots.size()-1; i > 0; i--) {
			if (
					shots.get(i).getTranslateY() < 0 || 
					shots.get(i).getTranslateY() > WINDOW_HEIGHT ||
					shots.get(i).getTranslateX() < 0 ||
					shots.get(i).getTranslateX() > WINDOW_WIDTH
					) {
				shots.get(i).remove();
				shots.remove(shots.get(i));
			}
		}
	}

	private void bTimer() {
		if (btime == 0) {
			return;
		}else {
			btime--;	
			return;	
		}
	}


	public static void main(String[] args) {

		launch();

	}

}
