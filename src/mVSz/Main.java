package mVSz;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	private short bulletTime = 0;
	private short zombieTime = 0;

	private int scoreInt;

	private boolean alternate = false;

	public static Group root = new Group();

	public static Scene scene = new Scene(root, 1600, 900, Color.rgb(135,206,250));

	public static final ArrayList<KeyCode> keys = new ArrayList<KeyCode>();
	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public static ArrayList<Zombie> zombies = new ArrayList<Zombie>();

	@Override
	public void start(Stage primaryStage) throws Exception {


		Rectangle ground = new Rectangle(0, scene.getHeight()*3/4, scene.getWidth()*2, scene.getHeight());
		ground.setFill(Color.rgb(96, 128, 56));


		Text score = new Text("" + scoreInt);
		score.setTranslateX(50);
		score.setTranslateY(75);
		score.setStroke(Color.WHITE);
		score.setFill(Color.WHITE);
		score.setScaleX(10);
		score.setScaleY(10);

		root.getChildren().addAll(ground, score);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		Shooter shooter = new Shooter();

		root.getChildren().add(shooter);

		scene.setOnKeyPressed(event -> {

			if (!keys.contains(event.getCode())) {
				keys.add(event.getCode());
			}

		});

		scene.setOnKeyReleased(event -> {

			if (keys.contains(event.getCode())) {

				keys.remove(event.getCode());
			}
		});

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				score.setText("" + scoreInt);

				if (shooter.alive == false) {
					this.stop();
				}

				for(Bullet b : bullets) {

					if (!root.getChildren().contains(b)) {
						root.getChildren().add(b);
					}

					b.update();

				}

				if (zombieTime == 0) {
					zombieTime = (short) (50 + Math.random()*150);
					if(!alternate) {
						zombies.add(new Zombie());
						alternate = true;
					}	
					if (alternate) {
						zombies.add(new Zombie(-100, shooter.getDir()));
						alternate = false;
					}

					root.getChildren().add(zombies.get(zombies.size()-1));

				}

				for(Zombie z : zombies) {

					if (z.getTranslateX() == shooter.getTranslateX()) {
						shooter.die();
					}
					z.update();

					for(Bullet b : bullets) {

						if (b.hit(z)) {

							scoreInt++;
							z.kill();
							b.remove();

						}

					}

				}

				for (int i = zombies.size()-1 ; i > 0; i--) {

					if (zombies.get(i).getTranslateX() > scene.getWidth()+100) {
						zombies.remove(i);
					}

				}

				for (int i = bullets.size()-1 ; i > 0; i--) {

					if (bullets.get(i).getOpac() == 0) {
						bullets.remove(i);
					}

				}

				for (KeyCode key : keys) {

					if (key == KeyCode.ENTER && bulletTime == 0) {
						bulletTime = 30;

						double xcoord = shooter.gunpointX();

						if (shooter.getDir() < 0) {
							xcoord = shooter.gunpointX() - shooter.getWidth();
						}

						bullets.add(new Bullet(xcoord, shooter.gunpointY(), shooter.getDir()));

					}

					if (key == KeyCode.A) {

						shooter.turnLeft();

					}

					if (key == KeyCode.D) {

						shooter.turnRight();

					}

				}

				bTimer();
				zombieTimer();
			}
		}.start();

	}

	private void bTimer() {
		if (bulletTime == 0) {
			return;
		}else {
			bulletTime--;	
			return;	
		}
	}

	private void zombieTimer() {
		if (zombieTime == 0) {
			return;
		}else {
			zombieTime--;	
			return;	
		}
	}

	public static void main(String[] args) {
		launch();
	}

}
