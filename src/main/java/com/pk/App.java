package com.pk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  public static Stage stage;

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainScreen.fxml"));
    primaryStage.setTitle("Error detection");
    primaryStage.setScene(new Scene(root, 800, 800));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
