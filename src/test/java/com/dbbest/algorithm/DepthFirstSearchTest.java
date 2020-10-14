package com.dbbest.algorithm;

import com.dbbest.model.Pipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("DEPTH FIRST SEARCH ALGORITHM TEST")
class DepthFirstSearchTest {

  private final int NUMBER_OF_VERTEX = 8;
  private final List<Pipe> edges =
      Arrays.asList(
          Pipe.of(1, 2, 10),
          Pipe.of(3, 4, 30),
          Pipe.of(3, 5, 15),
          Pipe.of(2, 3, 20),
          Pipe.of(6, 7, 20));
  private final DepthFirstSearch dfs = new DepthFirstSearch(edges);
  boolean[] discovered = new boolean[NUMBER_OF_VERTEX];

  @Test
  @DisplayName("Dataset 1")
  void test1() {
    int src = 2, dest = 5;
    assertTrue(dfs.isPointsConnected(src, dest));
  }

  @Test
  @DisplayName("Dataset 1")
  void test2() {
    int src = 2, dest = 6;
    assertFalse(dfs.isPointsConnected(src, dest));
  }

  @Test
  @DisplayName("Dataset 1")
  void test3() {
    int src = 6, dest = 7;
    assertTrue(dfs.isPointsConnected(src, dest));
  }
}
