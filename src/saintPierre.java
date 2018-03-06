import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class saintPierre extends Application{

	Group root = new Group();
	Scene startUp = new Scene(root, 100, 100);

	Scene scene;

	Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		this.primaryStage = primaryStage;
		primaryStage.setScene(startUp);	
		primaryStage.show();
		/*

		Button button = new Button("GENERATE FLAG");
		button.setTranslateX(10);
		button.setTranslateY(10);

		root.getChildren().add(button);

		button.setOnAction(action -> {*/
		scene = saintPierreFlag();
		primaryStage.setScene(scene);
		primaryStage.show();
		/*});
		 */

	}

	public Scene saintPierreFlag() {

		Group root = new Group();
		Scene scene = new Scene(root, 900, 600, Color.BLACK);

		// ----- Övre vänstra hörnet

		Rectangle rect1 = new Rectangle(0, 0, 200, 200);
		Line greenCross1 = new Line(0, 0, 200, 200);
		Line greenCross2 = new Line(0, 200, 200, 0);

		greenCross1.setStroke(Color.GREEN);
		greenCross2.setStroke(Color.GREEN);

		greenCross1.setStrokeWidth(25);
		greenCross2.setStrokeWidth(25);

		Line whiteCross1 = new Line(0, 100, 200, 100);
		Line whiteCross2 = new Line(100, 0, 100, 200);

		whiteCross1.setStroke(Color.WHITE);
		whiteCross2.setStroke(Color.WHITE);

		whiteCross1.setStrokeWidth(25);
		whiteCross2.setStrokeWidth(25);


		rect1.setFill(Color.RED);

		root.getChildren().addAll(rect1, greenCross1, greenCross2, whiteCross1, whiteCross2);

		// ----- Mitten vänster

		Rectangle rect2 = new Rectangle(0, 200, 200, 200);
		rect2.setFill(Color.WHITE);

		int scale = 10;

		Line top = new Line(10*scale, 0*scale, 10*scale, 9*scale);
		Line left = new Line(0*scale, 10*scale, 9*scale, 10*scale);
		Line right = new Line(20*scale, 10*scale, 11*scale, 10*scale);	
		Polygon bottom = new Polygon(10*scale, 10*scale, 15*scale, 25*scale, 10*scale, 30*scale, 5*scale, 25*scale);

		left.setStroke(Color.BLACK);
		right.setStroke(Color.BLACK);
		bottom.setFill(Color.BLACK);
		top.setStroke(Color.BLACK);
		
		left.setStrokeWidth(scale);
		right.setStrokeWidth(scale);
		top.setStrokeWidth(scale);

		root.getChildren().addAll(left, right, top, bottom);

		// ----- Botten vänstra hörnet

		Rectangle rect3 = new Rectangle(0, 400, 200, 200);
		rect3.setFill(Color.RED);

		// ----- Stora båt bilden

		Rectangle rect4 = new Rectangle(200, 0, 700, 600);
		rect4.setFill(Color.LIGHTBLUE);

		root.getChildren().addAll(rect2 ,rect3 ,rect4 );

		return scene;

	}

	public static void main(String[] args) {
		launch(args);
	}
}
