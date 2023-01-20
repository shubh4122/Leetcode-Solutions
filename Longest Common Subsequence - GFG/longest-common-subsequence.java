//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int lx, int ly, String x, String y)
    {
        // your code here
        
        int[][] dpMem = new int[lx+1][ly+1];
        for (int i = 0; i < dpMem.length; i++)
            Arrays.fill(dpMem[i], -1);

        return lcs1(lx, ly, x, y, dpMem);
    }
    
        public static int lcs1(int lx, int ly, String x, String y, int[][] dpMem) {
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
            return dpMem[lx][ly] = 1 + lcs1(lx - 1, ly - 1, x, y, dpMem);
        else //last char doesn't matches
            return dpMem[lx][ly] = Math.max(lcs1(lx,ly - 1, x, y, dpMem), lcs1(lx - 1,ly, x, y, dpMem));
    }
}