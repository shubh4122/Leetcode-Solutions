//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    long[][] dp;
    public long count(int coins[], int N, int sum) {
        // code here.
        dp = new long[N+1][sum+1];
        for(long[] row : dp)
            Arrays.fill(row, -1);
        return countWays(coins, N, sum);
    }
    
    public long countWays(int coins[], int n, int sum) {
        if(sum==0)
            return 1;//take no elem. this is 1 way
        
        if(n==0)
            return 0;//ways
        
        if(dp[n][sum]!= -1)
            return dp[n][sum];
            
        if(sum - coins[n-1]>= 0){
            long t = countWays(coins, n, sum-coins[n-1]);
            long nt = countWays(coins, n-1, sum);
            
            return dp[n][sum] = t+nt;
        }
        else{
            return dp[n][sum] = countWays(coins, n-1, sum);
        }
    }
}