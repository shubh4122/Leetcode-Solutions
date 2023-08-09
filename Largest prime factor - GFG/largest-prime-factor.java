//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    //O(n) approach
    static long largestPrimeFactor(int N) {
        // code here
        int maxPf = 0;
        if(isPrime(N))
            return N;
        
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N%i == 0) {
                //then Factors of N are:
                // int factor1 = i;
                int factor2 = N/i;
                
                if(isPrime(factor2))
                    return factor2;
                    
                else if(isPrime(i)) {
                    maxPf = Math.max(maxPf, i);
                }
            }
        }
        return maxPf;
    }
    
    static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0)
            return false;
        }
        return true;
    }
    
    
}