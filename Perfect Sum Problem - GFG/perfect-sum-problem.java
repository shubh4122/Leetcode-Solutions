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
	    
        int[][] dpMem = new int[n+1][sum+1];
        for (int i = 0; i < dpMem.length; i++)
            Arrays.fill(dpMem[i], -1);
        return countSubsetsMem(arr, n, sum, dpMem);
	    
	} 
	
	public int countSubsetsMem(int[] arr, int n, int sum,int[][] dpMem) {
        //BC
        if (n == 0 && sum != 0)
            return 0; //No subset possible. hence count = 0

        if (n == 0 && sum == 0)
            return 1;//empty set possible

        //Memoization
        if (dpMem[n][sum] != -1)
            return dpMem[n][sum];

        //Main code (Choice Diag)
        if (arr[n-1] <= sum)
            return dpMem[n][sum] = mod1000000007(countSubsetsMem(arr, n-1, sum - arr[n-1], dpMem) //count of subsets equal to given sum, when including (n-1)th item in arr
                                +
                    countSubsetsMem(arr, n - 1, sum, dpMem)); // count of subsets whose sum = given sum, when not including (n-t)th elem

        else    return dpMem[n][sum] = mod1000000007(countSubsetsMem(arr, n - 1, sum, dpMem));
    }
    
        public static int mod1000000007(long n) {
        return (int)(n%(1e9+7));
    }
}