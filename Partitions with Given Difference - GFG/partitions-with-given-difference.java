//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int n, int diff, int arr[]){
        // Code here
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        if((sum+diff)%2 != 0) return 0;

        int sumSubset1 = (sum+diff)/2;//Owing to 2 equations
        //now count how many subsets are there with this sum
        return countSubsetTabulationMY(arr, n, sumSubset1);
    }
    
    public static int countSubsetTabulationMY(int[] arr, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];
        //BC
        Arrays.fill(dp[0], 0);
        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++)
            for (int j = 0; j < sum + 1; j++)
                if (arr[i-1] <= j)
                    //count of subsets equal to given sum, when including (n-1)th item in arr
                    //+
                    // count of subsets whose sum = given sum, when not including (n-t)th elem
                    dp[i][j] = mod1000000007(dp[i-1][j - arr[i-1]] + dp[i-1][j]);

                else    dp[i][j] = dp[i-1][j];


        return dp[n][sum];
    }
    
     public static int mod1000000007(long n) {
        return (int)(n%(1e9+7));
    }
}