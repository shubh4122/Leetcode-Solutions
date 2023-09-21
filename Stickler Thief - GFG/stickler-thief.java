//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    Integer[] dp;
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        dp = new Integer[n+1];
        return rob(arr, 0);
    }
    
    private int rob(int[] arr, int i) {
        if( i >= arr.length)
            return 0;//0 money looted when no house left
            
        if(dp[i] != null)
            return dp[i];
        
        int take = arr[i] + rob(arr, i+2);
        int nt = rob(arr, i+1);
        
        return dp[i] = Math.max(take, nt);
    }
}