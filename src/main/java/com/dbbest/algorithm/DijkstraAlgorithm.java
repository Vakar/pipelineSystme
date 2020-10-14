package com.dbbest.algorithm;

import com.dbbest.model.Pipe;

import java.util.*;

public class DijkstraAlgorithm {

  private final List<Pipe> edges;
  private Set<Integer> settledNodes;
  private Set<Integer> unSettledNodes;
  private Map<Integer, Integer> distance;

  public DijkstraAlgorithm(List<Pipe> edges) {
    this.edges = new ArrayList<>(edges);
  }

  public void execute(Integer source) {
    settledNodes = new HashSet<>();
    unSettledNodes = new HashSet<>();
    distance = new HashMap<>();
    distance.put(source, 0);
    unSettledNodes.add(source);
    while (!unSettledNodes.isEmpty()) {
      Integer node = getMinimum(unSettledNodes);
      settledNodes.add(node);
      unSettledNodes.remove(node);
      findMinimalDistances(node);
    }
  }

  private void findMinimalDistances(Integer node) {
    List<Integer> adjacentNodes = getNeighbors(node);
    for (Integer target : adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node) + getDistance(node, target));
        unSettledNodes.add(target);
      }
    }
  }

  private int getDistance(Integer node, Integer target) {
    for (Pipe edge : edges) {
      if (edge.getStartPoint().equals(node) && edge.getEndPoint().equals(target)) {
        return edge.getLength();
      }
    }
    throw new IllegalStateException("Should not happen");
  }

  private List<Integer> getNeighbors(Integer node) {
    List<Integer> neighbors = new ArrayList<>();
    for (Pipe edge : edges) {
      if (edge.getStartPoint().equals(node) && !isSettled(edge.getEndPoint())) {
        neighbors.add(edge.getEndPoint());
      }
    }
    return neighbors;
  }

  private Integer getMinimum(Set<Integer> vertexes) {
    Integer minimum = null;
    for (Integer vertex : vertexes) {
      if (minimum == null) {
        minimum = vertex;
      } else {
        if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
          minimum = vertex;
        }
      }
    }
    return minimum;
  }

  private boolean isSettled(Integer vertex) {
    return settledNodes.contains(vertex);
  }

  private int getShortestDistance(Integer destination) {
    Integer d = distance.get(destination);
    if (d == null) {
      return Integer.MAX_VALUE;
    } else {
      return d;
    }
  }

  public int getDistance(Integer vertex){
    return distance.getOrDefault(vertex, -1);
  }
}
