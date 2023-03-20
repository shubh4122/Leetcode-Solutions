//{ Driver Code Starts
//Initial template for JAVA

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n = matrix.length;

        for (int via = 0; via < n; via++) {
            for (int src = 0; src < n; src++) {
                for (int dest = 0; dest < n; dest++) {

                    if (matrix[via][dest] == -1)
                        continue;
                    else if (matrix[src][via] == -1)
                        break;

                    int newDist = matrix[src][via] + matrix[via][dest];
                    if (newDist < matrix[src][dest] || matrix[src][dest] == -1)
                        matrix[src][dest] = newDist;
                }
            }
        }
    }
}