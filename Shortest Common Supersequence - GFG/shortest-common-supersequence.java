//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String x,String y,int lx,int ly)
    {
        //Your code here
        int[][] dpMems = new int[lx+1][ly+1];
        
        for (int i = 0; i < dpMems.length; i++)
            Arrays.fill(dpMems[i], -1);

        return x.length() + y.length() - lcs(lx, ly, x, y, dpMems);
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