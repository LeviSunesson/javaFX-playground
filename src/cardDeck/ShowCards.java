package cardDeck;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShowCards extends Application{

	CardDeck deck = new CardDeck();

	short counter = (short) deck.get().size();

	boolean spawncard = true;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Group root = new Group();
		Scene scene = new Scene(root, 600, 800, Color.BLACK);

		primaryStage.setScene(scene);
		primaryStage.show();
		
		new AnimationTimer() {

			Card card = new Card(1,2);
			
			@Override
			public void handle(long arg0) {

				if (counter == 0) {
					spawncard = false;
					this.stop();
				}

				scene.setOnKeyPressed( event->{

					if (event.getCode() == KeyCode.SPACE && spawncard) {

						counter--;
						
						card = deck.draw();
						card.setPos(300, 300);
						card.setScaleX(8);
						card.setScaleY(8);

						root.getChildren().add(card);   

					}
					
					if (event.getCode() == KeyCode.B && spawncard) {
						
						card.flip();

					}	

				});

			}

		}.start();

	}

	public static void main(String[] args) {
		launch();
	}

}
