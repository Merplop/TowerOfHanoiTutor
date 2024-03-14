package com.mirohaap.towerofhanoitutor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowController {
    @FXML
    private TextFlow tutorText;
    private int index = 0;

    @FXML
    public AnchorPane hanoiworld;

    @FXML
    protected void onRestartButtonClick() throws IOException {
        TowerController tc = new TowerController();
        index = 0;
        if (Tutor.getTutor().isEnabled()){
            Tutor.getTutor().toggleEnabled();
        }

        // add towers to game

        for (int i=0;i<3;i++) {
            hanoiworld.getChildren().add(tc.towers[i].frontEnd);
        }

        // TODO: Add drag and drop behaviour here once discs are implemented

        Stage stage = (Stage) tutorText.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Window.class.getResource("hanoi-tower.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 790, 620);
        stage.setScene(scene);
    }
    @FXML
    protected void onTutorToggled() {
        Tutor.getTutor().toggleEnabled();
        tutorText.getChildren().clear();
        if (Tutor.getTutor().isEnabled()){
            Text test = new Text(Tutor.getTutor().getBestMoves().get(index).toString());
            tutorText.getChildren().add(test);
            index += 1;
        }
    }
}