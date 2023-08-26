//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
        public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> uniqueElem = new HashMap<>();
        int start = 0, end = 0;
        int maxWindowSize = -1;
        while (end < s.length()) {
            //Step1 - consider the [end]
            char c = s.charAt(end);
            uniqueElem.put(c, uniqueElem.getOrDefault(c, 0)+1);

            //Step2 - when the limiting condition is reached & while it isn't resolved
            while (uniqueElem.size() > k) {
                char cStart = s.charAt(start);
                uniqueElem.put(cStart, uniqueElem.get(cStart)-1);
                if (uniqueElem.get(cStart) == 0)
                    uniqueElem.remove(cStart);
                start++;
            }

            //Step3 - Store the Max length of window
            if (uniqueElem.size() == k)
                maxWindowSize = Math.max(maxWindowSize, end-start+1);

            //Step4 Update end
            end++;
        }

        return maxWindowSize;
    }
}