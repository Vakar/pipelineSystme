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

  private final List<Pipe> edges =
      Arrays.asList(
          new Pipe(1, 2, 10),
          new Pipe(3, 4, 30),
          new Pipe(3, 5, 15),
          new Pipe(2, 3, 20),
          new Pipe(6, 7, 20));
  private final DepthFirstSearch dfs = new DepthFirstSearch(edges);

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
