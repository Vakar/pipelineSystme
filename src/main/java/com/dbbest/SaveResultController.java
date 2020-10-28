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
import java.util.stream.Collectors;

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
    List<Result> resultList = new ArrayList<>();
    ConnectionChecker checker = new DepthFirstSearch(pipeList);
    DistanceFinder distanceFinder = new DijkstraAlgorithm(pipeList);
    List<Path> flipPathSet =
        pathSet.stream()
            .map(path -> new Path(path.getToPoint(), path.getFromPoint()))
            .collect(Collectors.toList());
    for (int i = 0; i < pathSet.size(); i++) {
      Path directPath = pathSet.get(i);
      Path reversePath = flipPathSet.get(i);
      if (checker.isPointsConnected(directPath.getFromPoint(), directPath.getToPoint())) {
        int directDistance =
            distanceFinder.getDistance(directPath.getFromPoint(), directPath.getToPoint());
        int reverseDistance =
            distanceFinder.getDistance(reversePath.getFromPoint(), reversePath.getToPoint());
        int shortestDistance = Math.min(directDistance, reverseDistance);
        resultList.add(new Result(true, shortestDistance));
      } else {
        resultList.add(new Result(false, 0));
      }
    }
    return resultList;
  }
}
