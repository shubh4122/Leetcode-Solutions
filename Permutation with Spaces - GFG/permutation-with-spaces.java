//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        return helperPermutation(S, "");
    }
    
    ArrayList<String> helperPermutation(String ip, String op) {
        ArrayList<String> a = new ArrayList<>();

        if (op.isEmpty()) {
            op += ip.charAt(0);
            ip = ip.substring(1);
        }
        
        //now if ip had just 1 char, it'll return, else move down to recursive calls
        if (ip.isEmpty()) {
            a.add(op);
            return a;
        }

        
//            Char with space
        a.addAll(helperPermutation(ip.substring(1), op+" "+ip.charAt(0)));
//            Char without space
        a.addAll(helperPermutation(ip.substring(1), op+ip.charAt(0)));
        

        return a;
    }
    
}