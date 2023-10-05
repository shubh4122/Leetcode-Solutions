//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    long substrCount (String S, int K) {
        return countAtMostKElems(S, K) - countAtMostKElems(S, K-1);
    }

    long countAtMostKElems(String s, int k) {
        int[] freq = new int[26];

        int st = 0, e = 0, uniqueElemCount = 0;
        long countSubstring = 0;
        while (e < s.length()) {
            char c = s.charAt(e);
            if (freq[c-'a'] == 0)
                uniqueElemCount++;
            freq[c-'a']++;

            while (uniqueElemCount > k) {
                char cs = s.charAt(st);
                freq[cs-'a']--;
                if (freq[cs -'a'] == 0)
                    uniqueElemCount--;

                st++;
            }

            countSubstring += e - st + 1;//vv imp
            e++;
        }

        return countSubstring;
    }
}