package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Die;
import models.RaffleCup;
import models.YatzyResultCalculator;


public class YatzyGui extends Application {
    private final TextField txfDice1 = new TextField();
    private final TextField txfDice2 = new TextField();
    private final TextField txfDice3 = new TextField();
    private final TextField txfDice4 = new TextField();
    private final TextField txfDice5 = new TextField();
    private final RaffleCup raffleCup = new RaffleCup();
    private int kastTilbage = 3;
    Label kastTilbagelbl = new Label("kast tilbage " + kastTilbage);
    Button kastTerninger = new Button("Kast terniger");
    public boolean[] held =  new boolean[5];

    private YatzyResultWindow yatzyResultWindow;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        yatzyResultWindow = new YatzyResultWindow("yazy result", primaryStage);

    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        String squareStyle = "-fx-min-width: 50px; -fx-min-height: 50px; " +
                "-fx-max-width: 50px; -fx-max-height: 50px; " +
                "-fx-alignment: center; -fx-border-color: black; -fx-font-size: 18px;";
        // Set Styling / CSS
        txfDice1.setStyle(squareStyle);
        txfDice2.setStyle(squareStyle);
        txfDice3.setStyle(squareStyle);
        txfDice4.setStyle(squareStyle);
        txfDice5.setStyle(squareStyle);

        heldDiceField(txfDice1,0);
        heldDiceField(txfDice2,1);
        heldDiceField(txfDice3,2);
        heldDiceField(txfDice4,3);
        heldDiceField(txfDice5,4);

        // Store held points




        // Dice Display
        pane.add(txfDice1, 1, 0, 1, 4);
        pane.add(txfDice2, 2, 0, 1, 4);
        pane.add(txfDice3, 3, 0, 1, 4);
        pane.add(txfDice4, 4, 0, 1, 4);
        pane.add(txfDice5, 5, 0, 1, 4);

        pane.add(kastTilbagelbl, 0, 6);

        pane.add(kastTerninger, 6, 6);
        GridPane.setMargin(kastTerninger, new Insets(10, 10, 0, 10));
        kastTerninger.setOnAction(event -> this.yatzyresultaction());

        Button indsætPoint = new Button("åbn point");
        pane.add(indsætPoint,6,7);
        GridPane.setMargin(indsætPoint, new Insets(10, 10, 0, 10));
        indsætPoint.setOnAction(event -> this.indsætPointAction());

    }

    private void indsætPointAction() {

        YatzyResultCalculator resultCalculator = new YatzyResultCalculator(raffleCup.getDice());
        yatzyResultWindow.setScore(resultCalculator);

        yatzyResultWindow.showAndWait();
        resetDie();


    }

    private void yatzyresultaction() {


        raffleCup.throwDice();
        Die[] dice = raffleCup.getDice();
        txfDice1.setText(Integer.toString(dice[0].getEyes()));
        txfDice2.setText(Integer.toString(dice[1].getEyes()));
        txfDice3.setText(Integer.toString(dice[2].getEyes()));
        txfDice4.setText(Integer.toString(dice[3].getEyes()));
        txfDice5.setText(Integer.toString(dice[4].getEyes()));



            kastTilbage--;
        kastTilbagelbl.setText("kast tilbage " + kastTilbage);
        if (kastTilbage == 0){
            kastTerninger.setDisable(true);


        }
    }
    // Hold method with Styling / CSS
    public void heldDiceField(TextField textField, int index) {
        textField.setOnMouseClicked(event -> {
            held[index] = !held[index];
            raffleCup.switchDice(index);
            // Debugger print
            System.out.println("Dice " + (index + 1) + " held state: " + held[index]);

            if (held[index]) {
                textField.setStyle("-fx-min-width: 50px; -fx-min-height: 50px; " +
                        "-fx-max-width: 50px; -fx-max-height: 50px; " +
                        "-fx-alignment: center; -fx-border-color: black; -fx-font-size: 18px;-fx-background-color: lightgray;");
            } else {
                textField.setStyle("-fx-min-width: 50px; -fx-min-height: 50px; " +
                        "-fx-max-width: 50px; -fx-max-height: 50px; " +
                        "-fx-alignment: center; -fx-border-color: black; -fx-font-size: 18px;");
            }
        });
    }// Reset dice and non-held points with the same styling
    public void resetDie() {
        // Styling / CSS
        String squareStyle = "-fx-min-width: 50px; -fx-min-height: 50px; " +
                "-fx-max-width: 50px; -fx-max-height: 50px; " +
                "-fx-alignment: center; -fx-border-color: black; " +
                "-fx-font-size: 18px;";
        kastTerninger.setDisable(false);
        {
        // Reset all held states
        for (int i = 0; i < 5; i++) {
                txfDice1.setText("");
                txfDice2.setText("");
                txfDice3.setText("");
                txfDice4.setText("");
                txfDice5.setText("");
            }
        }

        // Set Styling / CSS for all dice
        txfDice1.setStyle(squareStyle);
        txfDice2.setStyle(squareStyle);
        txfDice3.setStyle(squareStyle);
        txfDice4.setStyle(squareStyle);
        txfDice5.setStyle(squareStyle);

        // Reset the kastTilbage counter
        kastTilbage = 3;
        kastTilbagelbl.setText("kast tilbage " + kastTilbage);
    }


    public boolean[] getHeld() {
        return held;
    }
}
