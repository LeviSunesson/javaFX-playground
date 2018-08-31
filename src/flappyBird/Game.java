package flappyBird;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application{

	Group root = new Group();
	
	ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene mainScene = new Scene(root, 450, 800, Color.LIGHTBLUE);
		
		Rectangle ground = new Rectangle(0, 500, mainScene.getWidth(), mainScene.getHeight()-500);
		ground.setFill(Color.GREEN);
		root.getChildren().add(ground);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
		primaryStage.setTitle("Flappy Bird");
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	private void pipeHandler() {
		
		
		
		
		
	}
	
	private void setup() {
		
		for (int i = 0; i < 10; i++) {
			
			pipes.add(new Pipe(i*200,0));
			
		}
		
		for (Pipe pipe : pipes) {
			root.getChildren().add(pipe);
		}
		
	}
	
}
