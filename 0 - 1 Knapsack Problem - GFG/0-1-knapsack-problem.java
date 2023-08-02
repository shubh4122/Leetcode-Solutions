//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n)
    {
        //dp[w+1][n]
        int[][] dp = new int[w+1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return ks(w, wt, val, n, 0, dp);
    }

    private static int ks(int w, int[] wt, int[] val, int n, int idx, int[][] dp) {
        if (w==0 || idx == n)
            return 0;//0 val can be obtained from ks

        //Memoization
        if (dp[w][idx]!=-1)
            return dp[w][idx];
        
        if (w-wt[idx] >= 0){
            int take = val[idx] + ks(w-wt[idx], wt, val, n, idx+1, dp);
            int notTake = ks(w, wt, val, n, idx+1, dp);
            return dp[w][idx] = Math.max(take, notTake);
        }
        else{//not take coz the wt of curr elem doesnt fit KS capacity
            return dp[w][idx] = ks(w, wt, val, n, idx+1, dp);
        }
    }
}


