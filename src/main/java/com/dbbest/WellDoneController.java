package com.dbbest;

import javafx.fxml.FXML;

import java.io.IOException;

public class WellDoneController {

  @FXML
  private void goHome() throws IOException {
    App.setRoot("uploadPipelineSystem");
  }
}
