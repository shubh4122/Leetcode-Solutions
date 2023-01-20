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
        int ans = coinChange2TabulationSPACE_OPTIMISED(coins, n, sum);
            
        return ans >= Integer.MAX_VALUE -1 ? -1 : ans;
	} 
	
// 	public static int coinChange2Tabulation(int[] coins, int n, int sum) {
//         int[][] dp = new int[n+1][sum+1];
//         //Initialization - BC
//         Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
//         for (int i = 0; i < n + 1; i++)
//             dp[i][0] = 0;
//         //CAN ALSO traverse whole arr and Fill 3rd BC val too, but it works without that too. so leaving it
// //        for (int j = 1; j < sum + 1; j++) {
// //            if (j % coins[0] == 0)    dp[1][j] = j / coins[0];
// //            else                      dp[1][j] = Integer.MAX_VALUE - 1;
// //        }

//         //MAIN CODE
//         for (int i = 1; i < n + 1; i++) {// i = 2 when 3rd BC is used
//             for (int j = 1; j < sum + 1; j++) {
//                 if (coins[i-1] <= j)
//                     dp[i][j] = Math.min(1+dp[i][j - coins[i-1]], dp[i-1][j]);

//                 else
//                     dp[i][j] = dp[i-1][j];
//             }
//         }

//         return dp[n][sum];
//     }
    public static int coinChange2TabulationSPACE_OPTIMISED(int[] coins, int n, int sum) {
        //Using 2 1D arr instead of dp[][]. SAVES A LOT OF SPACE!
        int[] prevRow = new int[sum+1];// At initialization. This is row0
        int[] currRow = new int[sum+1];// At initialization. This is row1

        //Initialization - BC
        Arrays.fill(prevRow, Integer.MAX_VALUE - 1);//filling 0th row
        //Instead of filling 1st col, here we'll fill only 1st cell.
        prevRow[0] = 0;

        //MAIN CODE

        for (int i = 1; i < n + 1; i++) {// i = 2 when 3rd BC is used
            for (int j = 1; j < sum + 1; j++) {
                //All ...[i][*] -> curr[*]
                //all ...[i-1][*] -> prev[*]
                if (coins[i-1] <= j)
                    currRow[j] = Math.min(1+currRow[j-coins[i-1]], prevRow[j]);

                else
                    currRow[j] = prevRow[j];
            }
            //updating prev after current row done.
            prevRow = currRow;
        }

        return currRow[sum];
    }
}