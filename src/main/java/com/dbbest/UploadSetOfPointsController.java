package com.dbbest;

import com.dbbest.csv.CsvParser;
import com.dbbest.csv.CsvParserImpl;
import com.dbbest.csv.Delimiter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class UploadSetOfPointsController {

  private final CsvParser parser = new CsvParserImpl();

  @FXML
  private void uploadSetOfPoints(ActionEvent event) throws IOException {
    try {
      Window window = ((Node) (event.getSource())).getScene().getWindow();
      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
      File file = fileChooser.showOpenDialog(window);
      App.setSetOfPoints(parser.parsePathList(file, Delimiter.SEMICOLON));
      App.setRoot("selectOutputDirectory");
    } catch (Exception e){
      App.showAlert("Maybe you didn't peek a file or dataset invalid.");
      App.setRoot("uploadSetOfPoints");
    } finally{
      event.consume();
    }
  }
}
