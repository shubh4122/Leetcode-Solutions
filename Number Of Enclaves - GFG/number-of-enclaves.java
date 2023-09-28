//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid[0].length;
        int m = grid.length;
        
        for(int j = 0; j < n; j++){
            if(grid[0][j]==1)
                q.add(new int[]{0,j});
                
            if(grid[m-1][j] == 1)
                q.add(new int[]{m-1,j});
        }
        
        for(int i = 1; i < m-1; i++){
            if(grid[i][0]==1)
                q.add(new int[]{i,0});
                
            if(grid[i][n-1] == 1)
                q.add(new int[]{i, n-1});
        }
        
        bfs(grid, q);
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==1)
                    count++;
            }
        }
        
        return count;
    }
    
    private void bfs(int[][] grid, Queue<int[]> q) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        
        
        while(!q.isEmpty()){
            int[] pop = q.remove();
            int i = pop[0];
            int j = pop[1];
            
            grid[i][j] = 0;//sink these land pieces.
            
            for(int k = 0; k < 4; k++){
                int newI = i + dx[k];
                int newJ = j + dy[k];
                
                if(validIdx(newI, newJ, grid) && grid[newI][newJ] == 1) {
                    q.add(new int[]{newI, newJ});
                }
            }
        }
    }
    
    private boolean validIdx(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
