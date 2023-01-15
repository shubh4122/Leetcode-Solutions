//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {
        // code here
        //Return 1. For true.
        //Step 1: Find Total sum of arr
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        //Step 2: If sum - Odd, then no partition can be done, If Even - partition MAY BE possible
        if (sum%2 != 0) //odd sum
            return 0;   //Partition NOT possible

        //Step 3: Now Start DP.
        boolean[][] dp = new boolean[n+1][(sum/2)+1];
        //Initialization
        Arrays.fill(dp[0], false);//row0 filled
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = true; // col0 filled

        //Choice Diag code ----------_ BE VERY CAREFULLLLL!!!!  i and j start from 1 !!!!!!!!!!!!!!
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < (sum / 2) + 1; j++) {
                if (arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];

                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum/2] ? 1 : 0;
    }
}