//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[] length = new int[n];
        for (int i = 0; i < n; i++)
            length[i] = i+1;
        //Now we have 3 I/Ps. len, price, n
        
        int maxPrice = unboundedKnapsack(price, length, n, n);
        return maxPrice;
    }
    
        public int unboundedKnapsack(int[] val, int[] wt, int n, int w) {
        int[][] dp = new int[n+1][w+1];
        //Initialisation
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 0;

        //Choice Diag
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                //Max of (Taken(hence Unprocessed, so dp[i][...]), Not taken(hence Processed, so dp[i-1][j]))
                if (wt[i-1] <= j)
                    dp[i][j] = Math.max(val[i-1] + dp[i][j - wt[i-1]], dp[i-1][j]);

                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][w];
    }

}