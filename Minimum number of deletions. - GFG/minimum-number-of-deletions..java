//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String s, int n)
    {
        // code here
        return n - longestPalindromicSubseq(s);
    }
    
    public int longestPalindromicSubseq(String a)
    {
        //code here
        //Step 1: Find 2nd HIDDEN string
        String revA = new StringBuilder(a).reverse().toString();
        int lx = a.length();
        int ly = revA.length();
        
        int[][] dpMem = new int[lx+1][ly+1];
        for (int i = 0; i < dpMem.length; i++)
            Arrays.fill(dpMem[i], -1);
        
        
        //Step 2: Call LCS for the above 2. That will be the final ANS!!!!!
        return lcs(a.length(), revA.length(), a, revA, dpMem);
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