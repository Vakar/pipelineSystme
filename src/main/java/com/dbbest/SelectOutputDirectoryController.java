package com.dbbest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class SelectOutputDirectoryController {

  @FXML
  private void selectOutputDirectory(ActionEvent event) throws IOException {
    Window window = ((Node) (event.getSource())).getScene().getWindow();
    DirectoryChooser directoryChooser = new DirectoryChooser();
    File selectedDirectory = directoryChooser.showDialog(window);
    App.setDirectoryPath(selectedDirectory.getAbsolutePath());
    event.consume();
    App.setRoot("saveResult");
  }
}
