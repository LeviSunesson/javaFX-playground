import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class redmiddle extends Application{

	Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {

		scene = upg6();

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public Scene upg1() {

		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		Circle cir = new Circle(scene.getWidth()/2, scene.getHeight()/2, 100);
		cir.setFill(Color.RED);
		root.getChildren().add(cir);

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

		return scene;

	}
	
	public Scene upg7() {
		
		//Skapa och visa en Scene med en triangel som börjar på ett random ställe och faller till marken.
		
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		Polygon tri = new Polygon(0, 0, 100);
	
		
		

		return scene;
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
