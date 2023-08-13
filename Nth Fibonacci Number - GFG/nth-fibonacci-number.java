//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    //1 1 2 3 5 8 ...
    static int mod = 1000000007;
    static int nthFibonacci(int n){
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fib(n, dp);
    }
    
    static int fib(int n, int[] dp) {
        // code here
        if(n == 1)
            return 1;
        
        if(n==2)
            return 1;
            
        if(dp[n] != -1)
        return dp[n];
            
        return dp[n] = (fib(n-1, dp)%mod + fib(n-2, dp)%mod)%mod;
    } 
}