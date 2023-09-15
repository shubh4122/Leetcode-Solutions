//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    Set<List<List<Integer>>> set;
    int baseI, baseJ;
    List<List<Integer>> shape;
    int countDistinctIslands(int[][] grid) {
        int islandCount = 0;
        set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                shape = new ArrayList<>();

                if (grid[i][j] != 0) {
                    baseI = i;
                    baseJ = j;
                    dfsDistinctIsland(grid, i, j);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    //basically this functions SINKS the visited islands.
    private void dfsDistinctIsland(int[][] grid, int i, int j) {
        //mark current cell as visited - SINK THIS Part of island
        grid[i][j] = 0;
        shape.add(Arrays.asList(i-baseI, j-baseJ));
        
        for (int k = 0; k < 4; k++) {
            int nextI = i + dx[k];
            int nextJ = j + dy[k];

            if (validIndex(grid.length, grid[0].length, nextI, nextJ))
                if (grid[nextI][nextJ] != 0)
                    dfsDistinctIsland(grid, nextI, nextJ);
        }
    }

    private boolean validIndex(int row, int col, int i, int j) {
        return i >= 0 && j >= 0 && i < row && j < col;
    }
}
