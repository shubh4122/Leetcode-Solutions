//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        
        int sum = 0, kadaneSum = 0, maxKsum = 0;;
        //1-> -1. 0 -> 1 ->> KADANE ago
        for(int i = 0; i < n; i++){
            sum += a[i];
            kadaneSum += a[i]==1 ? -1:1;
            maxKsum = Math.max(maxKsum, kadaneSum);
            
            if(kadaneSum < 0)
                kadaneSum = 0;
        }
        
        return sum+maxKsum;
    }
}
