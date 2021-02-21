package com.gs.algorithms.backtracking.path;

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
		
		Time : 2 ^ n
		Space : O(r + c)
		
		issue : too much time & several subproblems , dp works?
 */
public class FrogJump {

    private int[][] grid;
    private List<List<int[]>> result = new ArrayList<List<int[]>>();
    
	public  List<List<int[]>> findPath(int[][] grid) {
	    this.grid = grid;		
		findPathUtil(0, 0, new LinkedList<int[]>());
		return result;
	}
	
	private void findPathUtil(int row, int col, LinkedList<int[]> current) {
		if(isOutOfBoundary(row, col) || grid[row][col] == 0) return;
		
		
		if(hasReachedEnd( row, col)){
		    current.add(new int[]{row, col});
			result.add(new ArrayList<int[]>(current));
			current.removeLast();
			return;
		}
		
		current.addLast(new int[]{row, col});
		int totalJump = grid[row][col];
		for(int jump = 1; jump <=totalJump; jump++){
			findPathUtil(row + jump, col, current);
			findPathUtil(row, col + jump, current);
		}
		current.removeLast();
		
	}

	private boolean hasReachedEnd(int row, int col) {
		return (row == grid.length - 1) && (col == grid[0].length - 1);
	}

	private boolean isOutOfBoundary(int row, int col) {
		return (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length);
	}

	public static void main(String[] args) {
		int[][] grid ={
						{2, 1, 0, 0},
						{3, 0, 0, 1},
						{0, 1, 0, 1},
						{3, 0, 0, 1}
					  };
		List<List<int[]>> paths = new FrogJump().findPath(grid);
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
