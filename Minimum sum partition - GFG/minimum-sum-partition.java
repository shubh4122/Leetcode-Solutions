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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minDifference(int arr[], int n) 
	{ 
	    
	    // Your code goes here
	    
	    int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        int halfSum = sum/2;
        
        int[][] dpMem = new int[n+1][halfSum+1];
        
        for (int i = 0; i < dpMem.length; i++)
            Arrays.fill(dpMem[i], -1);
            
        int sumPartition1 = maxSumNearestToHalfSum(arr, n, halfSum, dpMem);
        int sumPartition2 = sum - sumPartition1;

        return Math.abs(sumPartition2 - sumPartition1);
	} 
	
	//This function returns SUM nearest to given sum
    private static int maxSumNearestToHalfSum(int[] arr, int n, int sum, int[][] dpMem) {
        //BC
        if (sum == 0 || n == 0)   return 0;

        //Memoization
        if (dpMem[n][sum] != -1)
            return dpMem[n][sum];

        //CODE(Choice Diag)
        //Just like knapsack, Return Max Sum(profit there) nearest to Given SUM(W there)
        if (arr[n-1] <= sum)
            return dpMem[n][sum] = Math.max(arr[n-1] + maxSumNearestToHalfSum(arr, n-1, sum - arr[n-1], dpMem),
                                            maxSumNearestToHalfSum(arr, n-1, sum, dpMem));

        else return dpMem[n][sum] = maxSumNearestToHalfSum(arr, n-1, sum, dpMem);
    }
}
