package com.pk.frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class MainScreenController {

  @FXML
  private Button checkButton;
  @FXML
  private TextField infoInput;
  @FXML
  private Label errorLabel;

  @FXML
  public void initialize(){
    errorLabel.setVisible(false);

  }

  public void calculate() {
    if (!infoInput.getText().isEmpty()) {
      errorLabel.setVisible(false);

    }
    else {
      errorLabel.setVisible(true);
    }
  }
}
