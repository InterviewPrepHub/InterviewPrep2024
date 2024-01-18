package com.series.InterviewPrep2024.Design;

public class SolveSudoko {

    public static void main(String[] args) {

        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (sudokoSolver(grid))
            print(grid);
        else
            System.out.println("No Solution exists");
    }

    public void sudokoSolver(int[][] grid) {
        helper(grid, 0, 0);
    }

    private boolean helper(int[][] grid, int row, int col) {

        int new_row = 0, new_col = 0;
        if(col!= grid.length-1) {
            new_row = row;
            new_col = col+1;
        } else {
            new_row = row+1;
            new_col = 0;
        }

        if (grid[row][col]!=0) {
            helper(grid, new_row, new_col);
            return true;
        } else {
            for (int num = 0; num <=9; num++) {
                if(isSafe(grid, row, col, num)) {
                    grid[row][col] = num;
                    if (helper(grid, new_row, new_col)) {
                        return true;
                    } else {
                        grid[row][col] = 0;
                    }
                }
            }
            return false;
        }

    }

    private boolean isSafe(int[][] grid, int row, int col, int num) {

        for (int x = 0; x <= 9; x++) {
            if (grid[row][x] == num) {
                return false;
            }
        }

        for (int y = 0; y <= 9; y++) {
            if (grid[y][col] == num) {
                return false;
            }
        }

        int matRow = row - row%3;
        int matCol = col - col%3;

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if(grid[i+matRow][j+matCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+",");
            }
            System.out.println();
        }
    }

}
