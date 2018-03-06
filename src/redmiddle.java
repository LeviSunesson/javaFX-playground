import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class redmiddle extends Application{

	Scene scene;

	Group root = new Group();
	Scene startUp = new Scene(root, 500, 500);
	public Stage primaryStage;
	public static int direction = 10;

	public ArrayList<KeyCode> keys = new ArrayList<KeyCode>();

	public static int intAnswer = 0;

	public static boolean restart = false;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		primaryStage.setScene(startUp);	
		primaryStage.show();

		Label question = new Label("Vilken uppgift? ( 1 - 8 ) ");
		question.setTranslateX(10);
		question.setTranslateY(10);

		Button button1 = new Button("uppgift 1");
		button1.setTranslateX(000);
		button1.setTranslateY(50);

		Button button2 = new Button("uppgift 2");
		button2.setTranslateX(100);
		button2.setTranslateY(50);

		Button button3 = new Button("uppgift 3");
		button3.setTranslateX(200);
		button3.setTranslateY(50);

		Button button4 = new Button("uppgift 4");
		button4.setTranslateX(300);
		button4.setTranslateY(50);

		Button button5 = new Button("uppgift 5");
		button5.setTranslateX(000);
		button5.setTranslateY(100);
		
		Button button6 = new Button("uppgift 6");
		button6.setTranslateX(100);
		button6.setTranslateY(100);

		Button button7 = new Button("uppgift 7");
		button7.setTranslateX(200);
		button7.setTranslateY(100);

		Button button8 = new Button("uppgift 8");
		button8.setTranslateX(300);
		button8.setTranslateY(100);

		root.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8);
		root.getChildren().add(question);

		button1.setOnAction(action -> {
			scene = upg1();
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		button2.setOnAction(action -> {
			scene = upg2();
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		button3.setOnAction(action -> {
			scene = upg3();
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		button4.setOnAction(action -> {
			scene = upg4();
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		button5.setOnAction(action -> {
			scene = upg5();
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		button6.setOnAction(action -> {
			scene = upg6();
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		button7.setOnAction(action -> {
			scene = upg7();
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		button8.setOnAction(action -> {
			scene = upg8();
			primaryStage.setScene(scene);
			primaryStage.show();

		});

	}

	public Scene upg1() {

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		Circle cir = new Circle(scene.getWidth()/2, scene.getHeight()/2, 100);
		cir.setFill(Color.RED);
		root.getChildren().add(cir);

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			return startUp;
		}

		return scene;

	}

	public Scene upg2() {

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		for (int i = 0; i < 50; i++) {
			Circle cir = new Circle(scene.getWidth()*Math.random(), scene.getHeight()*Math.random(), 10);
			cir.setFill(Color.BLACK);
			root.getChildren().add(cir);
		}

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			return startUp;
		}

		return scene;

	}

	public Scene upg3() {

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		int size = 150;

		Rectangle rect1 = new Rectangle(0, 0, size, size);
		Rectangle rect2 = new Rectangle(0, scene.getHeight()-size, size, size);
		Rectangle rect3 = new Rectangle(scene.getWidth()-size, 0, size, size);
		Rectangle rect4 = new Rectangle(scene.getWidth()-size, scene.getHeight()-size, size, size);

		rect1.setFill(Color.RED);
		rect3.setFill(Color.BLUE);
		rect4.setFill(Color.GREEN);
		rect2.setFill(Color.PURPLE);

		root.getChildren().addAll(rect1,rect2,rect3,rect4);

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			return startUp;
		}

		return scene;

	}

	public Scene upg4() {

		Group root = new Group();
		Scene scene = new Scene(root, 1600, 1000, Color.YELLOW);

		Rectangle rect1 = new Rectangle(0, 0, 500, 400);
		Rectangle rect2 = new Rectangle(0, scene.getHeight()-400, 500, 400);
		Rectangle rect3 = new Rectangle(scene.getWidth()-900, 0, 900, 400);
		Rectangle rect4 = new Rectangle(scene.getWidth()-900, scene.getHeight()-400, 900, 400);

		rect1.setFill(Color.BLUE);
		rect3.setFill(Color.BLUE);
		rect4.setFill(Color.BLUE);
		rect2.setFill(Color.BLUE);

		root.getChildren().addAll(rect1,rect2,rect3,rect4);

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			return startUp;
		}

		return scene;

	}

	public Scene upg5() {

		//Skapa och visa en Scene med en rektangel som man kan styra med piltangenterna

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		Rectangle rect = new Rectangle(scene.getWidth()/2, scene.getHeight()/2, 100, 50);

		scene.setOnKeyPressed( event->{

			if ( event.getCode() == KeyCode.W) {
				rect.setTranslateY(rect.getTranslateY()-10);
			}
			if ( event.getCode() == KeyCode.D) {
				rect.setTranslateX(rect.getTranslateX()+10);
			}
			if ( event.getCode() == KeyCode.A) {
				rect.setTranslateX(rect.getTranslateX()-10);
			}
			if ( event.getCode() == KeyCode.S) {
				rect.setTranslateY(rect.getTranslateY()+10);
			}

		});

		root.getChildren().add(rect);

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			return startUp;
		}

		return scene;

	}

	public Scene upg6() {

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		int size = 50;

		Circle rect = new Circle(0, 0, size);

		rect.setTranslateX(scene.getWidth()/2);
		rect.setTranslateY(scene.getHeight()/2);

		scene.setOnKeyPressed( event->{

			if ( event.getCode() == KeyCode.W && !(rect.getTranslateY() < 0)) {
				rect.setTranslateY(rect.getTranslateY()-15);
			}
			if ( event.getCode() == KeyCode.D && !(rect.getTranslateX() > scene.getWidth()-size)) {
				rect.setTranslateX(rect.getTranslateX()+15);
			}
			if ( event.getCode() == KeyCode.A && !(rect.getTranslateX() < 0)) {
				rect.setTranslateX(rect.getTranslateX()-15);
			}
			if ( event.getCode() == KeyCode.S && !(rect.getTranslateY() > scene.getHeight()-size)) {
				rect.setTranslateY(rect.getTranslateY()+15);
			}

		});

		root.getChildren().add(rect);

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			return startUp;
		}

		return scene;

	}

	public Scene upg7() {

		//Skapa och visa en Scene med en triangel som börjar på ett random ställe och faller till marken.

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		Polygon tri = new Polygon(0, 100, 100, 100, 50, 50);
		tri.setTranslateX((scene.getWidth()-100)*Math.random());
		tri.setTranslateY((scene.getHeight()/2)*Math.random());
		tri.setFill(Color.RED);

		new AnimationTimer() {
			@Override
			public void handle(long now) {

				if (!(tri.getTranslateY() > scene.getHeight()-100)) {
					tri.setTranslateY(tri.getTranslateY()+15);
				}

			}
		}.start();

		root.getChildren().add(tri);

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			System.out.println("success");
			return startUp;
		}

		return scene;

	}

	public Scene upg8() {
		//Skapa och visa en Scene med en stutsande cirkel som kan flyttas i sidled och inte kan gå utanför din Scene.

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		int size = 10;

		Circle ball = new Circle(0, 0, size);
		ball.setTranslateX(scene.getHeight()*(int) (Math.random()));
		ball.setTranslateY(scene.getHeight()*(int) (Math.random()));
		ball.setFill(Color.RED);

		new AnimationTimer() {
			@Override
			public void handle(long now) {

				if (!(ball.getTranslateY() > scene.getHeight()-size)) {
					ball.setTranslateY(ball.getTranslateY()+direction);
				}

				if(ball.getTranslateY() == scene.getHeight() || ball.getTranslateY() == 0) {

					ball.setTranslateY(ball.getTranslateY()-direction);

					direction *= -1;

				}

				for (int i = 0; i < keys.size(); i++) {
					if ( keys.get(i) == KeyCode.D && !(ball.getTranslateX() > scene.getWidth()-size)) {
						ball.setTranslateX(ball.getTranslateX()+15);

						System.out.println(keys);

					}
					if ( keys.get(i) == KeyCode.A && !(ball.getTranslateX() < size)) {
						ball.setTranslateX(ball.getTranslateX()-15);

						System.out.println(keys);
					}	
				}


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



		root.getChildren().add(ball);

		Button button = new Button("back");
		button.setTranslateX(10);
		button.setTranslateY(10);

		button.setOnAction(action -> {
			this.primaryStage.setScene(startUp);
		});

		root.getChildren().add(button);

		if (restart) {
			return startUp;
		}

		return scene;

	}

	public static void main(String[] args) {
		launch(args);
	}

}
