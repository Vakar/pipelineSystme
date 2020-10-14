package com.dbbest.algorithm;

import com.dbbest.model.Pipe;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraAlgorithmTest {

  private final List<Pipe> edges =
      Arrays.asList(
          Pipe.of(1, 2, 10),
          Pipe.of(2, 3, 20),
          Pipe.of(3, 4, 30),
          Pipe.of(3, 5, 15),
          Pipe.of(6, 7, 20));
  DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(edges);

  @Test
  public void test1() {
    assertEquals(35, dijkstra.getDistance(2, 5));
  }

  @Test
  public void test2() {
    assertEquals(-1, dijkstra.getDistance(2, 6));
  }

  @Test
  public void test3() {
    assertEquals(20, dijkstra.getDistance(6, 7));
  }
}
