package spaceInvaders;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SpaceInvaders extends Application{

	public static final double WIDTH = 1000;
	public static final double HEIGHT = 750;

	public Group root = new Group();
	public Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);

	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	ArrayList<KeyCode> keys = new ArrayList<KeyCode>();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	Ship ship = new Ship();

	private short btime = 0;

	public static int step = 3;
	private boolean alternateCanon = false;
	private int offset = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		for (int rows = 0; rows < 6; rows++) {
			for (int cols = 0; cols < 4; cols++) {
				Enemy enemy = new Enemy((int) (WIDTH/6)/2 + rows * (int) (WIDTH/6), (int) (WIDTH/12) + cols*100);
				enemies.add(enemy);
				root.getChildren().add(enemy);
			}
		}
		primaryStage.setScene(scene);
		primaryStage.show();

		root.getChildren().addAll(ship);

		new AnimationTimer() {
			@Override
			public void handle(long now) {


				for( Bullet b : bullets) {

					if (!root.getChildren().contains(b)) {
						root.getChildren().add(b);
					}
					b.update();

				}

				for(Enemy enemy : enemies) {
					for(int i = bullets.size()-1; i > 0 ; i--) {
						if (enemy.alive == true && bullets.get(i).hit(enemy)) {
							enemy.kill();
							bullets.get(i).remove();
							bullets.remove(bullets.get(i));
						}
					}			
				}

				removeBullets();

				ship.update();

				bTimer();
				move();

			}
		}.start();

		scene.setOnKeyPressed( event->{

			if (!(keys.contains(event.getCode()))) {
				keys.add(event.getCode());	
			}	

		});

		scene.setOnKeyReleased( event->{

			keys.remove(event.getCode());			

		});


	}

	private void removeBullets() {
		for (int i = bullets.size()-1; i > 0; i--) {
			if (bullets.get(i).getTranslateY() < 0) {
				bullets.remove(bullets.get(i));
			}
		}
	}

	private void move(){

		for (KeyCode i : keys) {
			switch(i) {

			case A:
			case LEFT:
				ship.fly(-step);
				break;

			case D:
			case RIGHT:
				ship.fly(step);
				break;
			default:
				break;
			}
			if (i == KeyCode.SPACE && btime == 0) {

				if (alternateCanon == true) {
					offset = 45;
					alternateCanon = false;
				}else if (alternateCanon == false) {
					offset = 0;
					alternateCanon = true;
				}

				btime = 15;
				bullets.add(new Bullet(ship.canon() + offset, ship.getTranslateY()));

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
