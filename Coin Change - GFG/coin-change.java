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
    public long count(int coins[], int n, int sum) {
        // code here.
        long[][] dpMem = new long[n+1][sum+1];
        for (int i = 0; i < dpMem.length; i++)
            Arrays.fill(dpMem[i], -1l);
            
        return coinChange1(coins, n, sum, dpMem);
    }
    
    public long coinChange1(int[] coins, int n, int sum, long[][] dpMem) { //Max no. of ways
        //same as countSubsets--> with given sum. Just that it'll be unbounded here
        //BC
        // if (sum == 0) return 1; // Empty set. i.e. No coins can sum upto 0
        // if (n == 0)   return 0; // this will execute when sum != 0

        
        if (n == 0 && sum != 0) return 0; // Empty set. i.e. No coins can sum upto 0
        if (n == 0 && sum == 0)   return 1;

        //Memoization
        if (dpMem[n][sum] != -1l)
            return dpMem[n][sum];

        //Main Code - Choice Diagram
        if (coins[n-1] <= sum)
            //return Take(don't decrease coin array size coz UNBOUNDED, i.e. pass call(n) and not n-1) + Not take
            return dpMem[n][sum] = (coinChange1(coins, n, sum - coins[n-1], dpMem) + coinChange1(coins, n-1, sum, dpMem));

        else
            return dpMem[n][sum] = coinChange1(coins, n-1, sum, dpMem);
    }
    
    public static int mod1000000007(long n) {
        return (int)(n%(1e9+7));
    }
}