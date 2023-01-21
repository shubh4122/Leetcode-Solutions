//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String x, String y, int lx, int ly){
        //table
        int[][] dp = new int[lx+1][ly+1];

        //Initialization
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < lx + 1; i++)
            dp[i][0] = 0;

        //Choice Diagram
        for (int i = 1; i < lx + 1; i++) {
            for (int j = 1; j < ly + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else //last char doesn't matches
                    dp[i][j] = 0;
            }
        }

        //Now, here we need to find what is the MAX val in Matrix
        //Here we dont simply return dp[lx][ly]
        int maxLen = -1;
        for (int i = 0; i < lx + 1; i++) 
            for (int j = 0; j < ly + 1; j++) 
                if (maxLen < dp[i][j])
                    maxLen = dp[i][j];
        
        return maxLen;
    }
    
}