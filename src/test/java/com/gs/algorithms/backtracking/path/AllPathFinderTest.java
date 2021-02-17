package com.gs.algorithms.backtracking.path;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AllPathFinderTest {

  private AllPathFinder allPathFinder;
 
  @Test
  public void test4X4Grid() {
    int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    allPathFinder = new AllPathFinder(grid);
    List<List<Integer>> result = allPathFinder.findAllPath();
    assertEquals(20, result.size());
    List<Integer> expected = Arrays.asList(1, 2, 6, 10, 11, 12, 16);
    assertTrue(result.contains(expected));
  }
  
  @Test
  public void test3X3Grid() {
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    allPathFinder = new AllPathFinder(grid);
    List<List<Integer>> result = allPathFinder.findAllPath();
    assertEquals(6, result.size());
    List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9);
    assertTrue(result.contains(expected));
  }
  
}
