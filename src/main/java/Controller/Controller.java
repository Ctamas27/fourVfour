package Controller;

import Main.MyApplication;
import Model.Table;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.io.FileWriter;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static javafx.scene.paint.Color.*;

public class Controller extends MyApplication {

    @FXML
    private Circle circle11;
    @FXML
    private Circle circle12;
    @FXML
    private Circle circle13;
    @FXML
    private Circle circle14;
    @FXML
    private Circle circle21;
    @FXML
    private Circle circle22;
    @FXML
    private Circle circle23;
    @FXML
    private Circle circle24;
    @FXML
    private Circle circle31;
    @FXML
    private Circle circle32;
    @FXML
    private Circle circle33;
    @FXML
    private Circle circle34;
    @FXML
    private Circle circle41;
    @FXML
    private Circle circle42;
    @FXML
    private Circle circle43;
    @FXML
    private Circle circle44;
    @FXML
    private Circle circle51;
    @FXML
    private Circle circle52;
    @FXML
    private Circle circle53;
    @FXML
    private Circle circle54;
    @FXML
    private Rectangle statusCircle;
    @FXML
    private javafx.scene.control.Button exit;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private javafx.scene.control.Button okButton1;
    @FXML
    private javafx.scene.control.Button okButton2;
    @FXML
    private Text name1;
    @FXML
    private Text name2;
    @FXML
    private Text winner;
    @FXML
    private Pane pane1;
    @FXML
    private javafx.scene.control.Button restart;



    Table table = new Table();
    Circle circle = null;
    String[][] tabla = Table.generateTable();
    boolean first = TRUE;

    public void clickActionEvent(MouseEvent event) {
        circle = (Circle) event.getSource();
        Paint color = circle.getFill();
        String Id = circle.getId();
        char x = Id.charAt(6);
        char y = Id.charAt(7);


        if(first)
        {
            table.setOldCoordinate(x, y);
            first = FALSE;
            System.out.println("lefutok");

        }

        table.setCoordinate(x, y);

        System.out.println(table.getOldCoordinateX() + " " + table.getOldCoordinateY());
        System.out.println(x + " " + y);

        if ((table.getOldCoordinateX() == Character.getNumericValue(x) - 1
                && table.getOldCoordinateY() == Character.getNumericValue(y))
                || (table.getOldCoordinateX() == Character.getNumericValue(x) + 1
                && table.getOldCoordinateY() == Character.getNumericValue(y))
                || (table.getOldCoordinateY() == Character.getNumericValue(y) + 1
                && table.getOldCoordinateX() == Character.getNumericValue(x))
                || (table.getOldCoordinateY() == Character.getNumericValue(y) - 1
                && table.getOldCoordinateX() == Character.getNumericValue(x))
                || (table.getOldCoordinateY() == Character.getNumericValue(y)
                && table.getOldCoordinateX() == Character.getNumericValue(x)))
            {
                statusCircle.setFill(table.getCurrentPlayer());
                if (color == table.getCurrentPlayer() || color == WHITE) {
                    if (color == RED || color == BLUE) {
                        table.setTable(Character.getNumericValue(y) - 1, Character.getNumericValue(x) - 1, tabla);
                        table.setCurrentColor(color);

                        if (color == RED) {
                            table.setCurrentPlayer(BLUE);
                        } else {
                            table.setCurrentPlayer(RED);
                        }
                        circle.setFill(WHITE);
                    } else {
                        circle.setFill(table.getCurrentColor());
                        table.setTable(Character.getNumericValue(y) - 1, Character.getNumericValue(x) - 1, tabla);
                        table.setCurrentColor(WHITE);
                        first = TRUE;
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
            }

        endGame(tabla);

        Table.showTable(tabla);

        table.move();

    }

    @FXML
    private void okButton1()
    {
        //textField();
        textField1.setVisible(false);
        okButton1.setVisible(false);



    }

    @FXML
    private void  textField()
    {


        String string1 = textField1.getText();
        JSONObject playerDetails1 = new JSONObject();
        playerDetails1.put("name", string1);

        JSONObject player1 = new JSONObject();
        player1.put("player", playerDetails1);

        String string2 = textField2.getText();
        JSONObject playerDetails2 = new JSONObject();
        playerDetails2.put("name", string2);

        JSONObject player2 = new JSONObject();
        player2.put("player", playerDetails2);

        JSONArray userList = new JSONArray();
        userList.add(player1);
        userList.add(player2);



        try (FileWriter file = new FileWriter("T:/Suli/Szoftverfejlesztes/fourVfour/src/main/resources/json/names.json")) {
            file.write(userList.toString());
        } catch(Exception e){
            System.out.println(e);

        }

        name1.setText(string1);
        name2.setText(string2);

    }

    @FXML
    private void okButton2()
    {
        textField();
        textField2.setVisible(false);
        okButton2.setVisible(false);
    }

    @FXML
    private void exit() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void initialize()
    {
        tabla = Table.generateTable();
        first = TRUE;
        circle11.setFill(RED);
        circle12.setFill(BLUE);
        circle13.setFill(RED);
        circle14.setFill(BLUE);
        circle21.setFill(WHITE);
        circle22.setFill(WHITE);
        circle23.setFill(WHITE);
        circle24.setFill(WHITE);
        circle31.setFill(WHITE);
        circle32.setFill(WHITE);
        circle33.setFill(WHITE);
        circle34.setFill(WHITE);
        circle41.setFill(WHITE);
        circle42.setFill(WHITE);
        circle43.setFill(WHITE);
        circle44.setFill(WHITE);
        circle51.setFill(BLUE);
        circle52.setFill(RED);
        circle53.setFill(BLUE);
        circle54.setFill(RED);
    }

    @FXML
    private void restart()
    {
        initialize();
        winner.setVisible(false);
    }

    //MyApplication myApplication = new MyApplication();

    public void endGame(String[][] tb)  {
        if(!Table.checkTable(tb))
        {
            if (table.getCurrentPlayer() == RED)
            {
                System.out.println("Kek NYERTEL");
                winner.setText("BLUE WON");
                winner.setFill(BLUE);
            }
            else
            {
                System.out.println("Piros NYERTEL");
                winner.setText("RED WON");
                winner.setFill(RED);
            }
            winner.setVisible(true);
            pane1.setVisible(true);
            restart.setVisible(true);

            //myApplication.start();
        }
    }
}
