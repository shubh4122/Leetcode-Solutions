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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String s){
        // code here
        int[][] dpMem = new int[s.length()+1][s.length()+1];

        for (int i = 0; i < dpMem.length; i++)
            Arrays.fill(dpMem[i], -1);
            
        return minInsertionsToPalindrome(s, dpMem);
    }
    
    
    public static int minInsertionsToPalindrome(String s, int[][] dp) {
        //Step 1: Reverse s and make new string
        String revS = new StringBuilder(s).reverse().toString();
        
        //Step 2: Find Lcs
        int lcs = lcs(s.length(), revS.length(), s, revS, dp);
        
        //Step 3: Ans = len(s) - lcs
        return s.length() - lcs;
    }
    
    
    public static int lcs(int lx, int ly, String x, String y, int[][] dpMem) {
//        Hypothesis --> lcs returns the len of common subsequence between
//                       2 given strings. And we ensure it is the longest.
        //BC:
        if (lx == 0 || ly == 0)
            return 0; //0 len when any one str gets finished. coz then there can be no common subseq

        //Memoization
        if (dpMem[lx][ly] != -1)
            return dpMem[lx][ly];

        //CHOICE DIAGRAM
        if (x.charAt(lx - 1) == y.charAt(ly - 1))
            return dpMem[lx][ly] = 1 + lcs(lx - 1, ly - 1, x, y, dpMem);
        else //last char doesn't matches
            return dpMem[lx][ly] = Math.max(lcs(lx,ly - 1, x, y, dpMem), lcs(lx - 1,ly, x, y, dpMem));

//        https://leetcode.com/problems/longest-common-subsequence/
//        https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
    }
}