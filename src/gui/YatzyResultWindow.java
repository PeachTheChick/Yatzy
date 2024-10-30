package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jdk.jfr.Event;
import models.YatzyResultCalculator;

public class YatzyResultWindow extends Stage {
    private boolean[] heldScores = new boolean[15];
    private final YatzyGui yatzyGui = new YatzyGui();
    TextField enereText = new TextField();
    TextField toeretext = new TextField();
    TextField treeretext = new TextField();
    TextField fieretext = new TextField();
    TextField femeretext = new TextField();
    TextField sekseretext = new TextField();
    TextField sumtext = new TextField();
    TextField bonustext = new TextField();
    TextField treEnstext = new TextField();
    TextField etPartext = new TextField();
    TextField toppartext = new TextField();
    TextField lilleStraighttext = new TextField();
    TextField fireEnstext = new TextField();
    TextField storeStraighttext = new TextField();
    TextField fuldtHustext = new TextField();
    TextField tottaltext = new TextField();
    TextField chancetext = new TextField();
    TextField yatzytext = new TextField();


    public YatzyResultWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label enere = new Label("1'ere");
        pane.add(enere, 0, 0);

        pane.add(enereText, 1, 0);

        Label toere = new Label("2'ere");
        pane.add(toere, 0, 1);

        pane.add(toeretext, 1, 1);

        Label treere = new Label("3'ere");
        pane.add(treere, 0, 2);

        pane.add(treeretext, 1, 2);

        Label fiere = new Label("4'ere");
        pane.add(fiere, 0, 3);

        pane.add(fieretext, 1, 3);

        Label femere = new Label("5'ere");
        pane.add(femere, 0, 4);

        pane.add(femeretext, 1, 4);

        Label seksere = new Label("6'ere");
        pane.add(seksere, 0, 5);

        pane.add(sekseretext, 1, 5);

        Label sum = new Label("Sum");
        pane.add(sum, 2, 6);

        pane.add(sumtext, 3, 6);

        Label bonus = new Label("bonus");
        pane.add(bonus, 2, 7);

        pane.add(bonustext, 3, 7);

        Label etPar = new Label("Et par");
        pane.add(etPar, 0, 8);

        pane.add(etPartext, 1, 8);

        Label topar = new Label("To par");
        pane.add(topar, 0, 9);

        pane.add(toppartext, 1, 9);

        Label treEns = new Label("3 Ens");
        pane.add(treEns, 0, 10);

        pane.add(treEnstext, 1, 10);

        Label fireEns = new Label("Fire ens");
        pane.add(fireEns, 0, 11);

        pane.add(fireEnstext, 1, 11);

        Label lilleStraight = new Label("Lille straight");
        pane.add(lilleStraight, 0, 12);

        pane.add(lilleStraighttext, 1, 12);

        Label storeStraight = new Label("Store straight");
        pane.add(storeStraight, 0, 13);

        pane.add(storeStraighttext, 1, 13);

        Label fuldtHus = new Label("Fuldt hus");
        pane.add(fuldtHus, 0, 14);

        pane.add(fuldtHustext, 1, 14);

        Label chance = new Label("Chance");
        pane.add(chance, 0, 15);

        pane.add(chancetext, 1, 15);

        Label yatzy = new Label("Yatzy");
        pane.add(yatzy, 0, 16);

        pane.add(yatzytext, 1, 16);

        Label total = new Label("Total");
        pane.add(total, 2, 17);

        pane.add(tottaltext, 3, 17);

        heldScoreField(enereText, 0);
        heldScoreField(toeretext, 1);
        heldScoreField(treeretext, 2);
        heldScoreField(fieretext, 3);
        heldScoreField(femeretext, 4);
        heldScoreField(sekseretext, 5);
        heldScoreField(treEnstext, 6);
        heldScoreField(fireEnstext, 7);
        heldScoreField(fuldtHustext, 8);
        heldScoreField(lilleStraighttext, 9);
        heldScoreField(storeStraighttext, 10);
        heldScoreField(yatzytext, 11);
        heldScoreField(chancetext, 12);
        heldScoreField(etPartext, 13);
        heldScoreField(toppartext, 14);

    }

    public void setScore(YatzyResultCalculator resultCalculator) {
        enereText.setText(String.valueOf(resultCalculator.upperSectionScore(1)));
        toeretext.setText(String.valueOf(resultCalculator.upperSectionScore(2)));
        treeretext.setText(String.valueOf(resultCalculator.upperSectionScore(3)));
        fieretext.setText(String.valueOf(resultCalculator.upperSectionScore(4)));
        femeretext.setText(String.valueOf(resultCalculator.upperSectionScore(5)));
        sekseretext.setText(String.valueOf(resultCalculator.upperSectionScore(6)));

        etPartext.setText(String.valueOf(resultCalculator.onePairScore()));
        toppartext.setText(String.valueOf(resultCalculator.twoPairScore()));
        treEnstext.setText(String.valueOf(resultCalculator.threeOfAKindScore()));
        fireEnstext.setText(String.valueOf(resultCalculator.fourOfAKindScore()));
        lilleStraighttext.setText(String.valueOf(resultCalculator.smallStraightScore()));
        storeStraighttext.setText(String.valueOf(resultCalculator.largeStraightScore()));
        fuldtHustext.setText(String.valueOf(resultCalculator.fullHouseScore()));
        chancetext.setText(String.valueOf(resultCalculator.chanceScore()));
        yatzytext.setText(String.valueOf(resultCalculator.yatzyScore()));
    }
    // Method to hold score/point TextFields and stop them from updating
    private void heldScoreField(TextField textField, int index) {
        textField.setOnMouseClicked(event -> {
            if (!heldScores[index]) {
                heldScores[index] = true;

                textField.setEditable(false);
                textField.setStyle("-fx-background-color: lightgray;");


                resetResults();
                this.close();


            }
        });
    } // Method to reset all fields in the result window except held fields
    public void resetResults() {
        for (int i = 0; i < heldScores.length; i++) {
            if (!heldScores[i]) { // Only reset unheld scores
                switch (i) {
                    case 0:
                        enereText.clear();
                        break;
                    case 1:
                        toeretext.clear();
                        break;
                    case 2:
                        treeretext.clear();
                        break;
                    case 3:
                        fieretext.clear();
                        break;
                    case 4:
                        femeretext.clear();
                        break;
                    case 5:
                        sekseretext.clear();
                        break;
                    case 6:
                        treEnstext.clear();
                        break;
                    case 7:
                        fireEnstext.clear();
                        break;
                    case 8:
                        fuldtHustext.clear();
                        break;
                    case 9:
                        lilleStraighttext.clear();
                        break;
                    case 10:
                        storeStraighttext.clear();
                        break;
                    case 11:
                        yatzytext.clear();
                        break;
                    case 12:
                        chancetext.clear();
                        break;
                    case 13:
                        etPartext.clear();
                        break;
                    case 14:
                        toppartext.clear();
                        break;
                }
            }
        }
    }


}
