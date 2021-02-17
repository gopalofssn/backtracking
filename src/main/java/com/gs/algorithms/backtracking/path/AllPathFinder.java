package com.gs.algorithms.backtracking.path;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



// Time : 2^n , n = r*c
// Space : r + c
// issue : too many overlapping sub problems, can we use DP memoization?

public class AllPathFinder {
  
  private final int[][] grid;
  private final int totalRows;
  private final int totalColumns;
  private List<List<Integer>> paths;
  private final Cell[] directions = new Cell[] {new Cell(0, 1), new Cell(1, 0)};

  public AllPathFinder(int[][] grid) {
    this.grid = grid;
    this.totalRows = grid.length;
    this.totalColumns = grid[0].length;
    paths = new ArrayList<List<Integer>>();
  }

  public List<List<Integer>> findAllPath() {

    helper(new Cell(0, 0), new LinkedList<Integer>());
    return paths;
  }

  private void helper(Cell cell, LinkedList<Integer> current) {

    if (isOutOfBoundary(cell)) {
      return;
    }

    
    System.out.println(cell);
    current.addLast(grid[cell.row][cell.col]);

    if (isDestination(cell)) {
      paths.add(new ArrayList<Integer>(current));
    }

    for (Cell direction : directions) {
      Cell newCell = cell.nextCell(direction);
      helper(newCell, current);
    }

    current.removeLast();

  }

  private boolean isDestination(Cell cell) {
    return cell.row == totalRows - 1 && cell.col == totalColumns - 1;
  }

  private boolean isOutOfBoundary(Cell cell) {
    return cell.row >= totalRows || cell.row < 0 || cell.col >= totalColumns || cell.col < 0;
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    AllPathFinder allPathFinder = new AllPathFinder(grid);
    List<List<Integer>> result = allPathFinder.findAllPath();
    System.out.println("Total possible path " + result.size());
    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }

}
