package com.dbbest;

import com.dbbest.algorithm.ConnectionChecker;
import com.dbbest.algorithm.DepthFirstSearch;
import com.dbbest.algorithm.DijkstraAlgorithm;
import com.dbbest.algorithm.DistanceFinder;
import com.dbbest.csv.CsvWriter;
import com.dbbest.csv.CsvWriterImpl;
import com.dbbest.dao.PipeDao;
import com.dbbest.model.Path;
import com.dbbest.model.Pipe;
import com.dbbest.model.Result;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveResultController {

  private final CsvWriter csvWriter = new CsvWriterImpl();
  private final PipeDao pipeDao = App.pipeDao;

  @FXML
  private void saveResultsToFile() throws IOException {
    try {
      List<Pipe> pipeList = pipeDao.findAll();
      List<Path> pathSet = App.getSetOfPoints();
      List<Result> resultList = calculateDistances(pipeList, pathSet);
      csvWriter.writeCsvFile(resultList, App.getDirectoryPath());
      App.setRoot(Rout.WELL_DONE.value);
    } catch (Exception e) {
      App.showAlert("There is an issue with file writing process.");
      App.setRoot(Rout.SAVE_RESULT.value);
    }
  }

  private List<Result> calculateDistances(List<Pipe> pipeList, List<Path> pathSet) {
    ConnectionChecker connectionChecker = new DepthFirstSearch(pipeList);
    DistanceFinder distanceFinder = new DijkstraAlgorithm(pipeList);
    List<Result> resultList = new ArrayList<>();
    for (Path path : pathSet) {
      if (isPointsConnected(connectionChecker, path)) {
        int shortestDistance = findShortestDistance(distanceFinder, path);
        resultList.add(new Result(true, shortestDistance));
      } else {
        resultList.add(new Result(false, 0));
      }
    }
    return resultList;
  }

  private boolean isPointsConnected(ConnectionChecker connectionChecker, Path path) {
    int from = path.getFromPoint();
    int to = path.getToPoint();
    return connectionChecker.isPointsConnected(from, to);
  }

  private int findShortestDistance(DistanceFinder distanceFinder, Path path) {
    int directDistance = findDistance(distanceFinder, path);
    int reverseDistance = findDistance(distanceFinder, flipPath(path));
    return Math.min(directDistance, reverseDistance);
  }

  private int findDistance(DistanceFinder distanceFinder, Path path) {
    int from = path.getFromPoint();
    int to = path.getToPoint();
    return distanceFinder.getDistance(from, to);
  }

  private Path flipPath(Path path) {
    int from = path.getFromPoint();
    int to = path.getToPoint();
    return new Path(to, from);
  }
}
