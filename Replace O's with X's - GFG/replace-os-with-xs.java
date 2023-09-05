//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static char[][] fill(int n, int m, char[][] a) {

        for (int j = 0; j < a[0].length; j++) {
            if (a[0][j] == 'O'){
                a[0][j] = 'B';
                dfs(a, 0, j);//make all O's reachable through this Boundary O/B as B
            }
            if (a[a.length-1][j] == 'O'){
                a[a.length-1][j] = 'B';
                dfs(a, a.length-1, j);
            }
        }

        for (int i = 1; i < a.length-1; i++) {
            if (a[i][0] == 'O'){
                a[i][0] = 'B';
                dfs(a, i, 0);
            }
            if (a[i][a[0].length-1] == 'O'){
                a[i][a[0].length-1] = 'B';
                dfs(a, i, a[0].length-1);
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 'B')
                    a[i][j] = 'O';
                else
                    a[i][j] = 'X';
            }
        }

        return a;
    }

    private static void dfs(char[][] a, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nextI = i + dx[k];
            int nextJ = j + dy[k];

            if (validIndices(nextI, nextJ, a)) {
                if (a[nextI][nextJ] == 'O') {
                    a[nextI][nextJ] = 'B';
                    dfs(a, nextI, nextJ);
                }
            }
        }
    }

    private static boolean validIndices(int nexI, int nexJ, char[][] a) {
        return nexI >= 0 && nexI < a.length && nexJ >= 0 && nexJ < a[0].length;
    }
}