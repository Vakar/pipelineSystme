package com.dbbest.algorithm;

import com.dbbest.model.Pipe;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch implements ConnectionChecker {

  private final List<List<Integer>> connectedPipes;
  private final int MAX_NUMBER_OF_VERTEX = Short.MAX_VALUE;

  public DepthFirstSearch(List<Pipe> pipeList) {
    connectedPipes = new ArrayList<>();
    for (int i = 0; i < MAX_NUMBER_OF_VERTEX; i++) {
      connectedPipes.add(new ArrayList<>());
    }
    for (Pipe edge : pipeList) {
      connectedPipes.get(edge.getStartPoint()).add(edge.getEndPoint());
    }
  }

  boolean isConnected(int startPoint, int endPoint, boolean[] discovered) {
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

  @Override
  public boolean isPointsConnected(int pointA, int pointB) {
    boolean[] discovered = new boolean[MAX_NUMBER_OF_VERTEX];
    return isConnected(pointA, pointB, discovered);
  }
}
