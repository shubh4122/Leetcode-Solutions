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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int lx = str.length();
        int[][] dpMem = new int[lx+1][lx+1];
        return lrp(str, lx, dpMem);
    }
    
    
    public static int lrp(String x, int lx, int[][] dp) {
        //Step 1: Create 2nd Str
        String y = x;
        int ly = y.length();

        //Step 2: Find **LCS** of a, b. Only MINOR change is, skip when i == j
        //Initialization
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < lx + 1; i++)
            dp[i][0] = 0;

        //Choice Diagram
        for (int i = 1; i < lx + 1; i++) {
            for (int j = 1; j < ly + 1; j++) {
                //ONLY DIFFERENCE IN LRP & LCS

                if (x.charAt(i - 1) == y.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else //last char doesn't matches
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[lx][ly];
    }
}