//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        //IV, IX. XL, XC. CD, CM
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ans = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            ans+= map.get(c);
            
            if(i+1 < str.length()) {
                char ch = str.charAt(i+1);
                if(map.get(c) < map.get(ch)){
                    ans += map.get(ch)-map.get(c)*2;
                    i++;
                }
            }
        }
        return ans;
    }
}