package pongGame;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pong extends Application {

	public ArrayList<KeyCode> keys = new ArrayList<KeyCode>();

	public static double WIDTH = 600;
	public static double HEIGHT = 400;

	Group root = new Group();
	Scene SCENE = new Scene(root, WIDTH, HEIGHT, Color.BLACK);
	public Stage primaryStage;

	public static int leftScore = 0;
	public static int rightScore = 0;

	public static int step = 3;

	Puck puck = new Puck();

	Paddle left = new Paddle(0 + 10);

	Paddle right = new Paddle(SCENE.getWidth() - 10);

	Label leftS = new Label("" + leftScore);
	Label rightS = new Label("" + rightScore);
	
	private AnimationTimer anitimer = new AnimationTimer() {

		@Override
		public void handle(long now) {
			textUpdate();

			puck.checkPaddleRight(right);
			puck.checkPaddleLeft(left);

			puck.update();
			puck.edges();

			left.update();
			right.update();

			move();

			if (leftScore == 2) {
				SCENE = endScene(1);
				primaryStage.setScene(SCENE);
				primaryStage.show();

				return;
			}
			if (rightScore == 2) {
				SCENE = endScene(2);
				primaryStage.setScene(SCENE);
				primaryStage.show();

				return;

			}
		}
		
	};

	@Override
	public void start(Stage primaryStage) throws Exception {

		SCENE = startScene();

		this.primaryStage = primaryStage;
		primaryStage.setResizable(false);
		primaryStage.setScene(SCENE);	
		primaryStage.show();

	}

	private void textUpdate() {

		leftS.setText("" + leftScore);
		rightS.setText("" + rightScore);


	}

	private void move(){

		for (int i = 0; i < keys.size(); i++) {
			if ( keys.get(i) == KeyCode.W) {
				left.move(-step);
			}
			if ( keys.get(i) == KeyCode.S) {
				left.move(step);
			}
			if ( keys.get(i) == KeyCode.UP) {
				right.move(-step);
			}
			if ( keys.get(i) == KeyCode.DOWN) {
				right.move(step);
			}
		}

	}

	public Scene startScene() {

		Button start = new Button("START");

		start.setTranslateX(WIDTH/2 - 25);
		start.setTranslateY(HEIGHT/2 - 20);
		start.setScaleX(8);
		start.setScaleY(8);

		root.getChildren().add(start);		

		start.setOnAction(action -> {
			SCENE = playing();
			primaryStage.setScene(SCENE);
			primaryStage.show();

		});

		return SCENE;
	}

	public Scene playing() {

		Group root = new Group();
		Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);

		leftS.setTranslateX(30);
		leftS.setTranslateY(30);
		leftS.setTextFill(Color.WHITE);

		rightS.setTranslateX(WIDTH-30);
		rightS.setTranslateY(30);
		rightS.setTextFill(Color.WHITE);

		root.getChildren().addAll(puck, left, right, leftS, rightS);

		puck.reset();
		
		anitimer.start();

		scene.setOnKeyPressed( event->{

			if (!(keys.contains(event.getCode()))) {
				keys.add(event.getCode());	
			}	

		});

		scene.setOnKeyReleased( event->{

			keys.remove(event.getCode());			

		});

		return scene;

	}
	
	private Scene endScene(int player) {

		keys.clear();
		
		anitimer.stop();
		
		puck.xspeed = 0;
		puck.yspeed = 0;
		
		puck.x = WIDTH/2;
		puck.y = HEIGHT/2;
		
		leftScore = 0;
		rightScore = 0;

		Group root = new Group();
		Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);

		Label prompt = new Label("Player " + player + " Won!");

		prompt.setMinWidth(100);
		prompt.setMaxWidth(100);
		prompt.setTranslateX(WIDTH/2 - 30);
		prompt.setTranslateY(HEIGHT*0.2);
		prompt.setTextFill(Color.WHITE);
		prompt.setScaleX(5);
		prompt.setScaleY(5);

		Button playAgain = new Button("play again");

		playAgain.setMinWidth(100);
		playAgain.setMaxWidth(100);
		playAgain.setTranslateX(WIDTH/2 - 50);
		playAgain.setTranslateY(HEIGHT/2);
		playAgain.setScaleX(3);
		playAgain.setScaleY(3);

		root.getChildren().addAll(prompt, playAgain);

		playAgain.setOnAction(action -> {
			SCENE = playing();
			primaryStage.setScene(SCENE);
			primaryStage.show();
		});

		return scene;

	}

	public static void main(String[] args) {
		launch(args);
	}

}
