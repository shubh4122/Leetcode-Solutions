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
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int k, l;
        for (int i = 0; i < nums.length; i++) {
            //skip duplicates here also
            if (i > 0 && nums[i] == nums[i-1])  continue;

            for (int j = i+1; j < nums.length; j++) {
                //skip duplicates here also
                if (j > i+1 && nums[j] == nums[j-1])   continue;

                k = j+1;
                l = nums.length-1;
                while (k < l){
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];

                    if (sum == target) {
                        ans.add(new ArrayList<>());
                        ans.get(ans.size()-1).add(nums[i]);
                        ans.get(ans.size()-1).add(nums[j]);
                        ans.get(ans.size()-1).add(nums[k]);
                        ans.get(ans.size()-1).add(nums[l]);
                        

                        k++;
                        l--;
                        //skip the duplicates
                        while (k < l && nums[k]==nums[k-1])     k++;
                        while (k < l && nums[l]==nums[l+1])     l--;

                    }
                    else if (sum > target)  l--;
                    else                    k++;
                }
            }
        }
        return ans;
    }
}