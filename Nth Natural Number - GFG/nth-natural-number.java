//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    long n=ob.nextLong();
		    Solution ab=new Solution();
		    long k=ab.findNth(n);
		    System.out.println(k);
		}
	}
}

    

// } Driver Code Ends


//User function Template for Java

class Solution {
    long findNth(long N)
    {
        //code here
        String ans="";
        int base = 9;
        while(N>0)

        {//NOTE - base conversion, logN factor, and such type of question.!
            long val = (long)N%base;
            
            if(val < 10)
                ans=Long.toString(val)+ans;
                
            else
                ans= (char)(val-10+'A')+ans;
            N=N/base;

        }
        // System.out.println(ans);
        // long a=Long.parseLong(ans);

        return Long.parseLong(ans);
    }
}