//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int n, int sum) 
	{ 
	    // Your code goes here
        int[][] dpMem = new int[n+1][sum+1];
        for (int i = 0; i < dpMem.length; i++)
            Arrays.fill(dpMem[i], -1);
            
        int ans = coinChange2(coins, n, sum, dpMem);
            
        return ans == Integer.MAX_VALUE -1 ? -1 : ans;
	} 
	
	public static int coinChange2(int[] coins, int n, int sum, int[][] dpMem) {
        //HYPOTHESIS of this method : --> V IMP
        //  It returns the Min Number of coins req to give sum.

        //BC
        //???? see when sum = 0 and n=0 then what to return?
        if (n == 0 && sum != 0) return Integer.MAX_VALUE - 1; //because when no possible way, then num of coins UNDEFINED
        if (sum == 0)   return 0;
        // seee if any other bc?
        if (n == 1) return sum % coins[n-1] == 0 ? sum/coins[n-1] : Integer.MAX_VALUE -1;

        //Memoization
        if (dpMem[n][sum] != -1)
            return dpMem[n][sum];

        //Choice diag
        if (coins[n-1] <= sum)
            return dpMem[n][sum] = Math.min(1+coinChange2(coins, n, sum - coins[n-1], dpMem), coinChange2(coins, n-1, sum, dpMem));
        else
            return dpMem[n][sum] = coinChange2(coins, n-1, sum, dpMem);


    }
}