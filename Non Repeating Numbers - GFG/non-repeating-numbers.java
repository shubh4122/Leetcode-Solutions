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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public int[] singleNumber(int[] nums){
        /*
            Steps:
            1. Find XOR of all the array elements
            2. Find the RightMost SET BIT in XOR(say, iTH bit)
                Why? - This bit is the first position where the 2 numbers will differ in BITS.
            3. Finding the two numbers - by dividing them in 2 different groups:
                a. First group will be the ones which have the iTH bit set.
                    > One of the elem will for sure lie here, as its iTH bit is set.
                    > Take XOR of all elements lying in Group1. Here we get FIRST NUMBER. All others will be duplicates
                b. 2nd Group is of those elems, whose iTH bit is UNSET.
                    > 2nd elem for sure lies here.
                    > Take XOR of this group also, and get the SECOND NUMBER.
            4. store numbers and return
         */

//Step 1
        int xor = 0;
        for (int n : nums)
            xor ^= n;

//Step 2
        int rightMostSetBit = xor & (-xor); //NOTE
        
//Step 3
        int group1Xor = 0, group2Xor = 0;
        for (int n: nums) {
    //Step 3.a
            if ((n & rightMostSetBit) != 0)
                group1Xor ^= n;
    //Step 3.b  
            else
                group2Xor ^= n;
        }
        
//Step 4
        int num1 = Math.min(group1Xor, group2Xor);
        int num2 = Math.max(group1Xor, group2Xor);
        
        return new int[]{num1, num2};
    }
}