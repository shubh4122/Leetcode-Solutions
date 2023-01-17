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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n+1][sum+1];
        int count0 = 0;

        //Initialization - row0 -> F = 0, col0 -> T = 1
        Arrays.fill(dp[0], 0);//row0 filled
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            if (arr[i-1] == 0)  count0++;
            dp[i][0] = (int)Math.pow(2, count0); // col0 filled
        }

        //Choice Diag code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j)
                    dp[i][j] = mod1000000007(dp[i - 1][j - arr[i - 1]] + dp[i - 1][j]);//||(or) replaced by +
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return mod1000000007(dp[n][sum]);
	} 
	
	
    public static int mod1000000007(long n) {
        return (int)n%1000000007;
    }
}