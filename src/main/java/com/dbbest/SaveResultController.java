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
    List<Pipe> pipeList = pipeDao.findAll();
    List<Path> pathSet = App.getSetOfPoints();
    List<Result> resultList = calculateDistances(pipeList, pathSet);
    csvWriter.writeCsvFile(resultList, App.getDirectoryPath());
    App.setRoot("wellDone");
  }

  private List<Result> calculateDistances(List<Pipe> pipeList, List<Path> pathSet) {
    ConnectionChecker checker = new DepthFirstSearch(pipeList);
    DistanceFinder distanceFinder = new DijkstraAlgorithm(pipeList);
    List<Result> resultList = new ArrayList<>();
    for (Path path : pathSet) {
      if (checker.isPointsConnected(path.getFromPoint(), path.getToPoint())) {
        int distance = distanceFinder.getDistance(path.getFromPoint(), path.getToPoint());
        resultList.add(Result.of(true, distance));
      } else {
        resultList.add(Result.of(false, 0));
      }
    }
    return resultList;
  }
}
