//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        
        int[][] dp = new int[arr.length+1][arr.length+1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);

        return mcm(arr, 1, N - 1, dp);
    }
    
    
    public static int mcm(int[] arr, int i, int j, int[][] dp) {
        //BC
        if (i >= j) //1st INVALID I/P. = used coz, when i=j only one cell remains, and its not valid
            return 0;

        //Memoization
        if (dp[i][j] != -1)
            return dp[i][j];

        //breaking on k
        int min = Integer.MAX_VALUE;
        int tempAns = -1;

        for (int k = i; k <= j-1; k++) { //same as k<j
            tempAns = mcm(arr, i, k, dp) + (arr[i-1]*arr[k]*arr[j]) + mcm(arr, k+1, j, dp);

            min = Math.min(min, tempAns);
        }

        return dp[i][j] = min;
    }
}