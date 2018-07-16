package raket;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainRaket extends Application {

	public static final double WINDOW_WIDTH = 800;
	public static final double WINDOW_HEIGHT = 600;
	public static final double RAKET_SIZE = 75;

	public static final ArrayList<KeyCode> keys = new ArrayList<KeyCode>();

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();

		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.BLACK);

		Raket raket = new Raket(RAKET_SIZE);

		Rectangle bkg = new Rectangle(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		bkg.setFill(Color.RED);
		root.getChildren().add(bkg);
		
		root.getChildren().add(raket);

		scene.setOnKeyPressed(event -> {

			if (!keys.contains(event.getCode())) {
				keys.add(event.getCode());
			}

		});

		scene.setOnKeyReleased(event -> {

			if (keys.contains(event.getCode())) {

				keys.remove(event.getCode());
			}
			if (event.getCode().equals(KeyCode.SPACE)) {

				raket.boost = 1;
				raket.blackout();
			}
		});

		AnimationTimer at = new AnimationTimer() {

			@Override
			public void handle(long now) {

				//raket.update();
				
				for (int i = 0; i < keys.size(); i++) {

					KeyCode key = keys.get(i);

					switch (key) {
					
					case W:
						 raket.moveRight();
						if(keys.contains(KeyCode.SPACE)){
							raket.tuta();
							raket.changeColor();
							raket.boost();
						}
						break;
					case D:
						raket.setRotate(raket.getRotate() + 2);
						break;
					case A:
						raket.setRotate(raket.getRotate() - 2);
						break;						
					default:
						break;
					}

					if (raket.getTranslateX() > WINDOW_WIDTH) {
						raket.setTranslateX(raket.getTranslateX() - RAKET_SIZE);
					} else if (raket.getTranslateX() < 0) {
						raket.setTranslateX(raket.getTranslateX() + RAKET_SIZE);
					}

					if (raket.getTranslateY() > WINDOW_HEIGHT) {
						raket.setTranslateY(raket.getTranslateY() - RAKET_SIZE);
					} else if (raket.getTranslateY() < 0) {
						raket.setTranslateY(raket.getTranslateY() + RAKET_SIZE);
					}

				}

			}

			
			
		};

		at.start();

		primaryStage.setTitle("Rocket Mini-Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(true);

	}

}