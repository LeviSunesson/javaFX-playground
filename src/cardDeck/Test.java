package cardDeck;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application {

	ArrayList<Card> cards = new ArrayList<Card>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		
		Scene scene =  new Scene(root, 1200, 800, Color.BLACK);
		
		primaryStage.setScene(scene);
		primaryStage.show();
			
//		Card card = new Card(3, 13);
//		
//		card.setScaleX(8);
//		card.setScaleY(8);
//		card.setPos(300, 300);
//		
//		root.getChildren().add(card);
		
		for (int i = 1; i <= 4; i++) {
			
			for (int j = 2; j <= 14; j++) {
				
				cards.add(new Card(i, j));
				
				cards.get(cards.size()-1).setPos(j*90 - 135, i*100-50);
				
				if (!root.getChildren().contains(cards.get(cards.size()-1))) {
					root.getChildren().add(cards.get(cards.size()-1));
				}
						
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
