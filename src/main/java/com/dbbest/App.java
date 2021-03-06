package com.dbbest;

import com.dbbest.dao.PipeDao;
import com.dbbest.dao.PipeDaoImpl;
import com.dbbest.model.Path;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/** JavaFX App */
public class App extends Application {

  private static Scene scene;

  private static final String APP_TITLE = "DBBest Water Pipeline System";
  private static final String DEFAULT_SCENE = "uploadPipelineSystem";

  // THIS SECTION FOR SHARING BETWEEN CONTROLLERS | STARTS
  public static PipeDao pipeDao = new PipeDaoImpl();
  private static List<Path> setOfPoints;
  private static String directoryPath;

  public static String getDirectoryPath() {
    return directoryPath;
  }

  public static void setDirectoryPath(String directoryPath) {
    App.directoryPath = directoryPath;
  }

  public static List<Path> getSetOfPoints() {
    return setOfPoints;
  }

  public static void setSetOfPoints(List<Path> setOfPoints) {
    App.setOfPoints = setOfPoints;
  }
  // THIS SECTION FOR SHARING BETWEEN CONTROLLERS | ENDS

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML(DEFAULT_SCENE), 480, 480);
    stage.setScene(scene);
    stage.setTitle(APP_TITLE);
    stage.show();
    scene.getStylesheets().add("css/flatBee.css");
  }

  public static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }

  public static void showAlert(String message){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Oops, something goes wrong!");
    alert.setHeaderText(message);
    alert.setContentText("Please try again!");
    alert.showAndWait();
  }

  public static void main(String[] args) {
    launch();
  }
}
