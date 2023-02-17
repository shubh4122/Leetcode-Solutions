//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.nthFaithfulNum(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long nthFaithfulNum(int n) {
       // code here
       //as, n is divided by 2 say, k times. so 2^k roughly equal to n. and n corresponds to k+1 bits
        //log2(n) = ln(n)/ln(2)
        int totalBits = (int) (Math.log(n)/Math.log(2) + 1);
        long ans = 0L;
        for (int i = 0; i < totalBits; i++) {
            int currentBit = n&1;//gives LSB
            ans += currentBit * Math.pow(7, i);
            n = n >> 1;//that discarding 1 bit at a time.
            //eg: gradually on right shifting -- 1011 -> 101 -> 10 -> 1
        }
        return ans;
    }
};