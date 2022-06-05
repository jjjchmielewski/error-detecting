package com.pk.frontend;

import com.pk.backend.Berger;
import com.pk.backend.Hamming;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Scanner;

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
  @FXML
  private Button chooseFileButton;
  @FXML
  private Label raportCreatedLabel;

  FileChooser fileChooser = new FileChooser();
  File file;

  private Mode mode;

  @FXML
  public void initialize() {
    infoInput.setVisible(false);
    errorLabel.setVisible(false);
    checkButton.setVisible(false);
    infoWordLengthInput.setVisible(false);
    successLabel.setVisible(false);
    chooseFileButton.setVisible(false);
    raportCreatedLabel.setVisible(false);
  }

  public void chooseFile() {
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
    fileChooser.setInitialDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString()));
    file = fileChooser.showOpenDialog(successLabel.getScene().getWindow());
    while(!file.exists()){

    }
    chooseFileButton.setText(file.getName());
  }

  public void calculate() throws FileNotFoundException {
    errorLabel.setVisible(false);
    successLabel.setVisible(false);
    raportCreatedLabel.setVisible(false);
    if(file != null && file.exists()) {
      PrintWriter printWriter = new PrintWriter("Raport-" + mode.name() + "-" + System.currentTimeMillis() + ".txt");
      Scanner scanner = new Scanner(file);
      String line;
      while(scanner.hasNextLine()) {
        line = scanner.nextLine();
        switch (mode) {
          case CRC -> {
          }
          case Berger -> {
            if (Berger.check(line)) {
              printWriter.println(line + " - SUCCESS");
            } else {
              printWriter.println(line + " - ERROR");
            }
          }
          case Hamming -> {
            if (Hamming.check(line)) {
              printWriter.println(line + " - SUCCESS");
            } else {
              printWriter.println(line + " - ERROR");
            }
          }

        }
      }
      raportCreatedLabel.setVisible(true);
      printWriter.close();
      scanner.close();
      chooseFileButton.setText("Wybierz plik");
      file = null;
    } else if (!infoInput.getText().isEmpty()) {
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
          if (Hamming.check(infoInput.getText())) {
            successLabel.setVisible(true);
          } else {
            errorLabel.setVisible(true);
          }
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
    chooseFileButton.setVisible(true);
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
    infoInput.setVisible(true);
    checkButton.setVisible(true);
    chooseFileButton.setVisible(true);
  }
}
