package com.dbbest;

import com.dbbest.csv.CsvParser;
import com.dbbest.csv.CsvParserImpl;
import com.dbbest.csv.Delimiter;
import com.dbbest.dao.PipeDao;
import com.dbbest.model.Pipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadPipelineSystemController {

  private final PipeDao pipeDao = App.pipeDao;
  private final CsvParser parser = new CsvParserImpl();

  @FXML
  private void uploadPipelineSystem(ActionEvent event) throws IOException {
    try {
      Window window = ((Node) (event.getSource())).getScene().getWindow();
      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
      File file = fileChooser.showOpenDialog(window);
      List<Pipe> pipeSet = parser.parsePipeSystem(file, Delimiter.SEMICOLON);
      pipeSet.forEach(
          pipe -> {
            if (!pipeDao.isExists(pipe.getStartPoint(), pipe.getEndPoint())) {
              pipeDao.save(pipe);
            }
          });
      App.setRoot("uploadSetOfPoints");
    } catch (Exception e) {
      App.showAlert("Maybe you didn't peek a file or dataset invalid.");
      App.setRoot("uploadPipelineSystem");
    } finally {
      event.consume();
    }
  }
}
