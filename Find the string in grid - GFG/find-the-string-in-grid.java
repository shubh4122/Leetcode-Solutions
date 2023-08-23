//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   public int[][] searchWord(char[][] grid, String word) {
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (check(grid, i, j, word))
                    list.add(new int[]{i,j});
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private boolean check(char[][] grid, int i, int j, String word) {
        //top, bottom, left, right, dTopLeft, dTopRight, dBottomLeft, dBottomRight
        int[][] directions = {{-1,0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int d = 0; d < 8; d++) {
            if (move(grid, i, j, word, directions[d][0], directions[d][1]))
                return true;
        }

        return false;//when none of the 8 directions could yield a true!
    }

    private boolean move(char[][] grid, int i, int j, String word, int changeI, int changeJ) {

        int newI = i, newJ = j;
        for (int idx = 0; idx < word.length(); idx++) {
            if(validIdx(grid, newI, newJ)) {
                if (word.charAt(idx) == grid[newI][newJ]) {
                    newI = newI + changeI;//update indices
                    newJ = newJ + changeJ;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    private boolean validIdx(char[][] grid, int nextI, int nextJ) {
        return nextI >= 0 && nextI < grid.length && nextJ >=0 && nextJ < grid[0].length;
    }
}