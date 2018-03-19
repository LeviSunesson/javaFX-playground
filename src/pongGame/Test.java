package pongGame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		double WIDTH = 600;
		double HEIGHT = 400;
		
		Group root = new Group();
		Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);

		Label prompt = new Label("Player " + 1 + " Won!");
		
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
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
