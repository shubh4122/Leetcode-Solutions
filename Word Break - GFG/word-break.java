//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    int[][] dp;
    public int wordBreak(String s, List<String> wordDict) {

        HashSet<String> dict = new HashSet<>(wordDict);
        dp = new int[s.length()+1][s.length()+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return isSubstringInDict(s, dict, 1)? 1:0;
    }

    private boolean isSubstringInDict(String s, HashSet<String> dict, int i) {
        if (s.isEmpty())
            return true;

        if (i==s.length()+1)
            return false;

        //Memoization
        if (dp[s.length()][i]!=-1)
            return dp[s.length()][i]==1;

        if (dict.contains(s.substring(0, i))){
            //T || NT
            boolean take = isSubstringInDict(s.substring(i), dict, 1);
            boolean notTake = isSubstringInDict(s, dict, i+1);

            dp[s.length()][i] = take || notTake ? 1 :0;
        }
        else {
            dp[s.length()][i] = isSubstringInDict(s, dict, i+1) ? 1 :0;
        }

        return dp[s.length()][i]==1;
    }

}