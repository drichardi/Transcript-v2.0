import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class CalcFX extends Application
{
  TextField txtnum1, txtnum2;
  Button btnadd, btnsub, btndiv, btnmul, btnclear;
  Label lblanswer;

  @Override
  public void start(Stage theStage)
  {
    //make controls
    txtnum1 = new TextField();
    txtnum2 = new TextField();
    btnadd = new Button("+");
    btnsub = new Button("-");
    btnmul = new Button("x");
    btndiv = new Button("/");
    btnclear = new Button("Clear");
    lblanswer = new Label("?");

    //center text in Label
    lblanswer.setAlignment(Pos.CENTER);
    //apply css-like style to Label

    lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

    //make container for app
    GridPane root = new GridPane();
    //put container in middle of scene
    root.setAlignment(Pos.CENTER);
    //set spacing between controls
    root.setHgap(10);
    root.setVgap(10);
    //add to grid, cell by cell
    root.add(btnadd, 0,0);
    root.add(btnsub, 1,0);
    root.add(btnmul, 0,1);
    root.add(btndiv, 1,1);
    root.add(txtnum1, 0,2);
    root.add(txtnum2, 1,2);
    //last 2 rows span across 2 columns
    //col, row, colspan, rowspan
    root.add(lblanswer, 0, 3, 2, 1);
    root.add(btnclear, 0, 4, 2, 1);
    //set widths of all controls in method
    setWidths();
    //attach buttons to code in method
    linkButtonFunctions();
    //usual stuff for apps
    Scene scene = new Scene(root, 300, 250);
    theStage.setTitle("Mathemagic 1.0");
    theStage.setScene(scene);
    theStage.show();
  }
    public void setWidths()
    {
      //set widths of all controls
      txtnum1.setPrefWidth(70);
      txtnum2.setPrefWidth(70);
      btnadd.setPrefWidth(70);
      btnsub.setPrefWidth(70);
      btnmul.setPrefWidth(70);
      btndiv.setPrefWidth(70);
      btnclear.setPrefWidth(150);
      lblanswer.setPrefWidth(150);
    }
    public void linkButtonFunctions()
    {
      //have each button run buttonFunctions when clicked
      btnadd.setOnAction(e -> buttonFunctions(e));
      btnsub.setOnAction(e -> buttonFunctions(e));
      btnmul.setOnAction(e -> buttonFunctions(e));
      btndiv.setOnAction(e -> buttonFunctions(e));
      btnclear.setOnAction(e -> buttonFunctions(e));
    }

    public void buttonFunctions(ActionEvent e)
    {
      int num1, num2, answer;
      char symbol;
      //e tells us which button was clicked "Event"
      if(e.getSource() == btnclear)
      {
        txtnum1.setText("");
        txtnum2.setText("");
        lblanswer.setText("?");
        txtnum1.requestFocus();
        return;
      }
      //read numbers in from textfields
      num1 = Integer.parseInt(txtnum1.getText());
      num2 = Integer.parseInt(txtnum2.getText());
      if(e.getSource() == btnadd)
      {
        symbol = '+';
        answer = num1 + num2;
      }
      else if(e.getSource() == btnsub)
      {
        symbol = '-';
        answer = num1 - num2;
      }
      else if(e.getSource() == btnmul)
      {
        symbol = 'x';
        answer = num1 * num2;
      }
      else
      {
        symbol = '/';
        answer = num1 / num2;
      }
      //display answer
      lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);

    }
    public static void main(String[] args) {
      launch(args);
    }

}
