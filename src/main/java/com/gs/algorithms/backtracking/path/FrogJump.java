package com.gs.backtracking;

import java.util.*;

/*
  IP : binary matrix , find path to reach end from src 0,0
     					{2, 1, 0, 0},
						{3, 0, 0, 1},
						{0, 1, 0, 1},
						{0, 0, 0, 1}
	0 - water
	non zero # are stone and frog can jump upto # times either horizontal or vertical
	
	OP : print solution path
		[[0,0], [1,0] , [1,3], [2,3] , [3, 3]]
 */
public class FrogJump {

	private static List<List<int[]>> findPath(int[][] grid) {
		List<List<int[]>> result = new ArrayList<List<int[]>>();
		findPathUtil(grid, 0, 0, new LinkedList<int[]>(), result);
		return result;
	}
	
	private static void findPathUtil(int[][] grid, int row, int col, LinkedList<int[]> current, List<List<int[]>> result) {
		if(isOutOfBoundary(grid, row, col) || grid[row][col] == 0) return;
		current.addLast(new int[]{row, col});
		if(hasReachedEnd(grid, row, col)){
			result.add(new ArrayList<int[]>(current));
		}else{
			//System.out.println("visiting cell (" + row + ", " + col + ")");
			int totalJump = grid[row][col];
			for(int jump = 1; jump <=totalJump; jump++){
				findPathUtil(grid, row + jump, col, current, result);
				findPathUtil(grid, row, col + jump, current, result);
			}
		}
		current.removeLast();
	}

	private static boolean hasReachedEnd(int[][] grid, int row, int col) {
		return (row == grid.length - 1) && (col == grid[0].length - 1);
	}

	private static boolean isOutOfBoundary(int[][] grid, int row, int col) {
		return (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length);
	}

	public static void main(String[] args) {
		int[][] grid ={
						{2, 1, 0, 0},
						{3, 0, 0, 1},
						{0, 1, 0, 1},
						{2, 0, 0, 1}
					  };
		List<List<int[]>> paths = findPath(grid);
		for (List<int[]> path : paths) {
			System.out.println(constructPath(path));
		}
	}

	private static String constructPath(List<int[]> path) {
		StringBuilder sb = new StringBuilder();
		for (int[] cell : path) {
			sb.append(Arrays.toString(cell));
		}
		return sb.toString();
	}


}
