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
        String[][] dpMems = new String[lx+1][ly+1];
        
        for (int i = 0; i < dpMems.length; i++)
            Arrays.fill(dpMems[i], "-1");

        return scs(lx, ly, x, y, dpMems).length();
    }
    
    public static String scs(int lx, int ly, String x, String y, String[][] dpMem) {
        //Step 1: Merge Both
        StringBuilder superSeq = new StringBuilder(x + y);

        //Step 2: Find lcs of x, y
        StringBuilder lcs = new StringBuilder( lcsPrintMy(lx, ly, x, y, dpMem) );

        //Step 3: Remove LCS from superSeq --> This will be scs
        int i = 0;
        while (lcs.length() > 0) {
            if (superSeq.charAt(i) == lcs.charAt(0)) {
                superSeq.deleteCharAt(i);
                lcs.deleteCharAt(0);
                i--;
            }
            i++;
        }

        //Step 4: By now we have Shortest common SuperSeq, RETURN it
        return superSeq.toString();
    }

    
    public static String lcsPrintMy(int lx, int ly, String x, String y, String[][] dpMems) {
        //NOTE: I DON'T KNOW IF THIS IS CORRECT. THIS IS MY SOLUTION AND IT WORKED FOR MANY TEST CASES. BUT CANT
        //CONFIDENTLY SAY IT WILL ALWAYS WORK. COZ THERE IS NO QUES FOR IT
        //https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem?isFullScreen=false
        //IT WORKS!!!!!! SO ITS A CORRECT SOLUTION!!!!!!!

        //BC:
        if (lx == 0 || ly == 0)
            return ""; //0 len when any one str gets finished. coz then there can be no common subseq

        //Memoization
        if (!dpMems[lx][ly].equals("-1"))
            return dpMems[lx][ly];

        //CHOICE DIAGRAM
        if (x.charAt(lx - 1) == y.charAt(ly - 1))
            return dpMems[lx][ly] = lcsPrintMy(lx - 1, ly - 1, x, y, dpMems) + x.charAt(lx-1);
        else {//last char doesn't matches
            String a = lcsPrintMy(lx, ly - 1, x, y, dpMems);
            String b = lcsPrintMy(lx - 1, ly, x, y, dpMems);
            return dpMems[lx][ly] = a.length() > b.length() ? a : b;
        }

    }
}