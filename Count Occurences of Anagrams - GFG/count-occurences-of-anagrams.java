//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String p, String s) {
        // code here
        int st = 0, e = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        //store freq of characters in P
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        // List<Integer> ans = new ArrayList<>();
        int ans = 0;
        int countDistinctLetters = map.size();//We keep track of total distinct elem in map
        while (e < s.length()) {
            //step1
            if (map.containsKey(s.charAt(e))) {
                map.put(s.charAt(e), map.get(s.charAt(e)) - 1);
                if (map.get(s.charAt(e)) == 0)
                    countDistinctLetters--;
            }

            //Step2
            if (e - st + 1 == p.length()) {
                //2.1
                if (countDistinctLetters == 0)
                    ans++;
                //2.2
                if (map.containsKey(s.charAt(st))) {
                    map.put(s.charAt(st), map.get(s.charAt(st)) + 1);
                    if (map.get(s.charAt(st)) == 1)
                        countDistinctLetters++;
                }
                //2.3
                st++;
            }
            //Step3
            e++;
        }
        return ans;
    }
}