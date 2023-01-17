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
            
        int sumPartition1 = ksMem(arr, arr, halfSum, n, dpMem);
        int sumPartition2 = sum - sumPartition1;

        return Math.abs(sumPartition2 - sumPartition1);
	} 
	
    
        public static int ksMem(int[] val, int[] wt, int w, int n, int[][] dpMem) {
        //BC
        if (n == 0 || w == 0)
            return 0;

        //Just Recursive solution Takes too much time. so use MEMOIZATION
        if (dpMem[n][w] != -1)
            return dpMem[n][w];

        //Choice Diag
        if (wt[n-1] <= w)
            return dpMem[n][w] = Math.max(val[n-1] + ksMem(val, wt, w - wt[n-1], n-1, dpMem),
                    ksMem(val, wt, w, n-1, dpMem));

        else //if wt[n-1] > w
            return dpMem[n][w] = ksMem(val, wt, w, n-1, dpMem);
    }
}
