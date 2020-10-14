package com.dbbest.algorithm;

import com.dbbest.model.Pipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

  private final List<List<Integer>> connectedPipes;

  public DepthFirstSearch(List<Pipe> pipeList) {
    connectedPipes = new ArrayList<>();
    int numberOfPoints = findNumberOfPoints(pipeList);
    for (int i = 0; i < numberOfPoints; i++) {
      connectedPipes.add(new ArrayList<>());
    }
    for (Pipe edge : pipeList) {
      connectedPipes.get(edge.getStartPoint()).add(edge.getEndPoint());
    }
  }

  private int findNumberOfPoints(List<Pipe> pipeList) {
    Set<Integer> pointSet = new HashSet<>();
    for (Pipe pipe : pipeList) {
      pointSet.add(pipe.getStartPoint());
      pointSet.add(pipe.getEndPoint());
    }
    return pointSet.size();
  }

  public boolean isConnected(int startPoint, int endPoint, boolean[] discovered) {
    discovered[startPoint] = true;
    if (startPoint == endPoint) {
      return true;
    }
    for (int i : connectedPipes.get(startPoint)) {
      if (!discovered[i]) {
        if (isConnected(i, endPoint, discovered)) {
          return true;
        }
      }
    }
    return false;
  }
}
