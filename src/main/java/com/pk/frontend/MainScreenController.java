package com.pk.frontend;

import com.pk.backend.Berger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
  private TextField infoWordLengthInput;
  @FXML
  private RadioButton bergerRadio;
  @FXML
  private RadioButton crcRadio;
  @FXML
  private RadioButton hammingRadio;
  @FXML
  private Label successLabel;

  private Mode mode;

  @FXML
  public void initialize() {
    infoInput.setVisible(false);
    errorLabel.setVisible(false);
    checkButton.setVisible(false);
    infoWordLengthInput.setVisible(false);
    successLabel.setVisible(false);
  }

  public void calculate() {
    if (!infoInput.getText().isEmpty()) {
      errorLabel.setVisible(false);
      successLabel.setVisible(false);
      switch (mode) {
        case CRC -> {
        }
        case Berger -> {
          if (Berger.check(infoInput.getText())) {
            successLabel.setVisible(true);
          } else {
            errorLabel.setVisible(true);
          }
        }
        case Hamming -> {
        }

      }
    } else {
      errorLabel.setVisible(true);
    }
  }

  public void showBerger() {
    mode = Mode.Berger;
    crcRadio.setSelected(false);
    hammingRadio.setSelected(false);
    infoInput.setVisible(true);
    checkButton.setVisible(true);
  }

  public void showCRC() {
    mode = Mode.CRC;
    bergerRadio.setSelected(false);
    hammingRadio.setSelected(false);
  }

  public void showHamming() {
    mode = Mode.Hamming;
    bergerRadio.setSelected(false);
    crcRadio.setSelected(false);
  }
}
