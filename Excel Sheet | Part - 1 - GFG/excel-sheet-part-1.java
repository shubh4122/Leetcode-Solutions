//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine());
    
	    while(t > 0){
	        int n = Integer.parseInt(br.readLine());
	        Solution T = new Solution();
	        
	        System.out.println(T.excelColumn(n));
	        
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String excelColumn(int n){
        
        //  Your code here
        if(n <= 26)
            return String.valueOf((char)('A'+n-1));
            
        StringBuilder ans = new StringBuilder();
        while(n > 0) {
            int val = n%26;
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