//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static int mod = 1000000007;
    static long countWays(int n)
    {
        // add your code here
        Long[] dp = new Long[n+1];
        return backtracking(n, dp);
    }
    
    static long backtracking(int n, Long[] dp) {
        if(n < 0)
            return 0;
            
        if(n == 0)
            return 1;
            
            
        if(dp[n] != null)
            return dp[n];
            
        long count = 0L;
        for(int i = 1; i <= 3; i++){
            n = n-i;
            count = (count%mod + backtracking(n, dp)%mod)%mod;
            n = n+i;
        }
        
        return dp[n] = count;
    }
    
}

