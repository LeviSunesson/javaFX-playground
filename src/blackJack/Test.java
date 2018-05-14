package blackJack;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application{

	Group root = new Group();
	
	Scene scene = new Scene(root, 800, 450, Color.WHITE);
	
	Player player1 = new Player(50, 125);
	static CardDeck deck = new CardDeck();
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
		arg0.setScene(scene);
		arg0.show();
		
		deck.shuffle();
		
		player1.setName("Pontus");
		
		root.getChildren().addAll(player1);
		
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {

				player1.update();
				
			}

		}.start();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * deal
	 * 
	 * dealer deals cards
	 * 
	 * while(!stand && player.points < 21){
	 * 	hit/stand
	 * }
	 * 
	 * play again?
	 * 
	*/
}
