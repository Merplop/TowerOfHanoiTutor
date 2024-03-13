package com.mirohaap.towerofhanoitutor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class Window extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Window.class.getResource("hanoi-tower.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 790, 620);
        stage.setTitle("Hanoi Tower");
        stage.setScene(scene);
        Tutor tutor = Tutor.getTutor();
        tutor.speak("Welcome to Hanoi Tutor!");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}