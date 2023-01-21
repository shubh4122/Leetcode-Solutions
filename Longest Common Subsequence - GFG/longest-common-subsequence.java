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
        return lcs1(lx, ly, x, y);
    }
    
    public static int lcs1(int lx, int ly, String x, String y) {
//table
        int[][] dp = new int[lx+1][ly+1];

        //Initialization
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < lx + 1; i++)
            dp[i][0] = 0;

        //Choice Diagram
        for (int i = 1; i < lx + 1; i++) {
            for (int j = 1; j < ly + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else //last char doesn't matches
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        return dp[lx][ly];
    }
}