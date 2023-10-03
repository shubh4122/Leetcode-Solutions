//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        if(n <= 26)
            return String.valueOf((char)('A'+n-1));
            
        StringBuilder ans = new StringBuilder();
        while(n > 0) {
            long val = n%26;
            n = n/26;
            
            if(val!=0)
                ans.append((char)('A'+val-1));
                
            else{
                ans.append('Z');
                n--;
            }
            
        }
        return ans.reverse().toString();
    }
}