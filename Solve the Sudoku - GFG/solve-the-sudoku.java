//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static boolean SolveSudoku(int grid[][]) {
        return sudokuSolver(grid);
    }

    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][]){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]+" ");
            }
//            System.out.println(); ->  not required in GFG
        }
    }

    static boolean sudokuSolver(int[][] grid){
        //BC -> no such base case. required here!

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0){
                    //check for all 1 to 9 which can be fitted in this empty position
                    for (int elem = 1; elem <= 9; elem++) {
                        //backtracking.
                        if (noConflict(grid, i, j, elem)){
                            grid[i][j] = elem;//add
                            if (sudokuSolver(grid))//explore
                                return true;//if anytime we get a true from solver -> means there is atleast one path in recursive tree that successfully solves the Sudoku. so terminate recursion
                            grid[i][j] = 0;//abandon
                        }
                    }
                    return false;//we tried all 1 to 9 on given position. but if cant put any return false;
                }
            }
        }
        //why true? coz suppose at the last call, when every cell is filled up, then control will never go inside if(empty cell)
        //and hence function will neither return a T/F. so if grid is already filled. just return true;
        return true;
    }

    private static boolean noConflict(int[][] grid, int i, int j, int elem) {
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][j]==elem)
                return false;
        }

        for (int col = 0; col < grid.length; col++) {
            if (grid[i][col]==elem)
                return false;
        }

        //index of start of the smaller grid which contains the empty cell
        int id = 3* (i/3), jd = 3*(j/3);
        for (int row = id; row < id+3; row++) {
            for (int col = jd; col < jd+3; col++) {
                if (grid[row][col] == elem)
                    return false;
            }
        }
        return true;
    }
}