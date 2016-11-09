import javafx.application.Application;
import javafx.stage.Stage;

public class WindowExample extends Application
{
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage theStage)
  {
    theStage.setTitle("Canvas Example");

    Group root = new Group();
    Scene theScene = new Scene(root);
    theStage.setScene(theScene);
    Canvas canvas = new Canvas(400,200);
    root.getChildren().add(canvas);

    GraphicsContext gc = canvas.getGraphicsContext2D();

    gc.setFill(Color.RED);
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);
    Font theFont = theFont.font("Garamond", FontWeight.BOLD, 48);
    gc.setFont(theFont);
    gc.fillText("Hello World!", 60, 50);
    gc.strokeText("Hello World!", 60, 50);



    theStage.show();
  }
}
