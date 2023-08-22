//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    // static int mod = (int)1e9+7;
    
    
    public static int findCatalan(int n) {
        // code here
        if(n==0 || n==1){
            return 1;
        }
        
        long dp[]=new long[n+1],mod=(long)(1e9)+7;
        // Initializing dp[0] and dp[1] as 1
        dp[0]=dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                dp[i] = (dp[i]+(dp[j]*dp[i-j-1])%mod)%mod;
            }
        }
        
        //returning the nth catalan number.
        return (int)dp[n];
    }
    
    
    
    // public static int findCatalan(int n) {
    //     long[] dp = new long[n+1];
    //     Arrays.fill(dp, -1);
        
    //     return (int)findCatalan(n, dp);
    // }
    
//     public static int findCatalan(int N) {
//         if(N==0 || N == 1)
//         return 1;
//         long[] dp = new long[N+1];
//         dp[0] = 1; dp[1] = 1; //BC
        
//         for(int n = 2; n <= N; n++){//this loop replaces recursion.
//         //but recursion also has 1 for loop inside so:
//             dp[n] = 0;
//             for(int i = 1; i <= n; i++){
//                 long r = dp[n-i];
//                 long l = dp[i-1];
//                 dp[n] = (dp[n]%mod + (l*r)%mod)%mod;
//             }
//             // dp[n] = ans%mod;
//         }
//         return (int)dp[N];
        
//         // for(int n = 2; n <= N; n++){//this loop replaces recursion.
//         // //but recursion also has 1 for loop inside so:
//         //     long ans = 0;
//         //     for(int i = n; i>=1; i--) {
//         //         long r = dp[n-i];
//         //         long l = dp[i-1];
//         //         ans = (ans%mod + (l*r)%mod)%mod;
//         //     }
//         //     dp[n] = ans%mod;
//         // }
//         // return dp[N];
//     }
    
    
    
//     // public static long findCatalan(int n, long[] dp) {
//     //     //Quick hack: nthCatalan num = 1/(n+1)* 2nCn
//     //     //above formula wont work. as MODULAR division cant be done ALWAYS!
        
//     //     //using method used in Umique BST count. Let all nums be root. and calc.
        
//     //     if(n==0||n==1)
//     //         return 1;
            
//     //     if(dp[n] != -1)
//     //         return dp[n];
            
//     //     long ans=0;
//     //     for(int i = 1; i <= n; i++){
//     //         //let i be the root. nums less than i will be LHS, and greater RHS
//     //         long r = findCatalan(n-i, dp)%mod;
//     //         long l = findCatalan(i-1, dp)%mod;

//     //         ans = (ans%mod + (l*r)%mod)%mod;
//     //     }
//     //     return dp[n] = ans%mod;
//     // }
}
        




// class Solution {
//     static int mod = (int)1e9+7;
    
//     public static int findCatalan(int n) {
//         long[] dp = new long[n+1];
        
//         return (int)findCatalan(n, dp);
//     }
    
//     public static long findCatalan(int n, long[] dp) {
//         //Quick hack: nthCatalan num = 1/(n+1)* 2nCn
//         //above formula wont work. as MODULAR division cant be done ALWAYS!
        
//         //using method used in Umique BST count. Let all nums be root. and calc.
        
//         if(n==0||n==1)
//             return 1;
            
//         if(dp[n] != 0)
//             return dp[n];
            
//         // long ans=0;
//         for(int i = n; i >= 1; i--){
//             //let i be the root. nums less than i will be LHS, and greater RHS
//             long r = findCatalan(n-i, dp)%mod;
//             long l = findCatalan(i-1, dp)%mod;
            
//             l = l==0?1:l;
//             r = r==0?1:r;
//             dp[n] = (dp[n]%mod + (l*r)%mod)%mod;
//         }
//         return dp[n];
//     }
// }
        
