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
    
    int mod = (int)1e9 + 7;
    Integer[][] dp;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp = new Integer[n+1][sum+1];
	    return f(arr, 0, sum);
	}
	
	private int f(int[] arr, int i, int sum) {
	    if(i == arr.length){//necessary as there might be 0s ahead, and will add to our subset
    	    if(sum == 0)    
    	        return 1;
    	        
	        return 0;
	    }
	    
	    if(dp[i][sum]!=null)
	        return dp[i][sum];
	        
        if(sum - arr[i] >= 0) {
            int take = f(arr, i+1, sum - arr[i]);
            int nt = f(arr, i+1, sum);
            
            return dp[i][sum] = (take%mod + nt%mod)%mod;
        }
        else
            return dp[i][sum] = f(arr, i+1, sum)%mod;
	}
}