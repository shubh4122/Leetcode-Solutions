//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        ArrayList<String> a = new ArrayList<>();
        powerSet(s, "", a);

        Collections.sort(a);
        return a;
    }
    
    void powerSet(String ip, String op, ArrayList<String> a) {
        if(ip.equals("")){
            if(!op.equals(""))
                a.add(op);
            return;
        }
        
        powerSet(ip.substring(1), op, a);
        powerSet(ip.substring(1), op+ip.charAt(0), a);
    }
}