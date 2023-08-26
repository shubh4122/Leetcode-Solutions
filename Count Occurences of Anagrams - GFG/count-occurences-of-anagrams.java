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
        int st= 0, e = 0;
        HashMap<Character, Integer> mapP = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();

        //store freq of characters in P
        for (int i = 0; i < p.length(); i++) {
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0)+1);
        }

        int countAnagrams = 0;
        while (e < s.length()){
            mapS.put(s.charAt(e), mapS.getOrDefault(s.charAt(e), 0)+1);//1

            if (e-st+1 == p.length()) {//2
                if (checkForAnagrams(mapP, mapS))//2.1
                    countAnagrams++;
                
                mapS.put(s.charAt(st), mapS.get(s.charAt(st))-1);//2.2
                if (mapS.get(s.charAt(st))==0)
                    mapS.remove(s.charAt(st));
                    
                st++;//2.3
            }

            e++;//3
        }
        return countAnagrams;
    }

    private boolean checkForAnagrams(HashMap<Character, Integer> mapP, HashMap<Character, Integer> mapS) {
        if (mapP.size() != mapS.size())
            return false;

        for (Map.Entry<Character, Integer> entry : mapP.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();

            if (mapS.getOrDefault(key, 0) != count)
                return false;
        }
        return true;
    }
}