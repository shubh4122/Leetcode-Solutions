//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int n, int s){
        // code here
        if((float)s/9 > n || (n!=1 && s == 0))
            return "-1";
            
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(s-sum < 9){
                sb.append(s-sum);
                sum += s-sum;
            }
            else{
                sb.append(9);
                sum += 9;
            }
        }
        return sb.toString();
    }
}