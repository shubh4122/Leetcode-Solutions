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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int sn, String S){
        // code here
        
        HashMap<String, Integer> map = new HashMap<>();
        return countUsingMAP(S, 0, sn - 1, true, map);
    }
    
    
    
    
    public static int countUsingMAP(String s, int i, int j, boolean isTrue, HashMap<String, Integer> map) {
        //def - func returns num of ways in which a string from i to j, will be (isTrue, i.e. if its true, then true. and if false then false)
        //BC
        if (i > j)
            return 0;// no ways

        if (i == j) {
            if (isTrue)
                return (s.charAt(i) == 'T') ? 1 : 0; //i.e. if the only char is T, then there is 1 way to evaluate it to be true. else 0
            else //isTrue = false
                return (s.charAt(i) == 'F') ? 1 : 0;
        }

        //MEMOIZATION
        if (map.containsKey(i+" "+j+" "+isTrue))
            return map.get(i+" "+j+" "+isTrue);

        //CODE
        int ways = 0;
        for (int k = i+1; k <= j - 1; k+=2) {
            //left expression
            int waysLT = countUsingMAP(s, i, k - 1, true, map);
            int waysLF = countUsingMAP(s, i, k - 1, false, map);
            //right expression
            int waysRT = countUsingMAP(s, k + 1, j, true, map);
            int waysRF = countUsingMAP(s, k + 1, j, false, map);

            //calc ans(ways here) from tempAns(waysXX here)
            if (s.charAt(k) == '&') {
                if (isTrue)//1 way in AND, T&T = T only
                    ways += (waysLT * waysRT);
                else //3 ways. T&F, F&T, F&F = F
                    ways += ((waysLT * waysRF)   +   (waysLF * waysRT)   +   (waysLF * waysRF));
            }

            else if (s.charAt(k) == '|'){
                if (isTrue)//3 ways in OR. T|T, T|F, F|T == T all.
                    ways += ((waysLT * waysRT)   +   (waysLT * waysRF)   +   (waysLF * waysRT));
                else //1 way. F|F = F
                    ways += (waysLF * waysRF);
            }

            else {
                if (isTrue)//2 ways in XOR. T^F, F^T = T
                    ways += ((waysLT * waysRF) + (waysLF * waysRT));
                else //2 ways. T^T, F^F = F
                    ways += ((waysLT * waysRT)   +   (waysLF * waysRF));
            }
        }
        map.put(i+" "+j+" "+isTrue, ways % 1003);// ques asked ans%1003
        return map.get(i+" "+j+" "+isTrue);
    }

}