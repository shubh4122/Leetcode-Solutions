//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    
    static int longestSubsequence(int size, int a[]) {
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            int idx = bs(l, l.size(), a[i]);
            if(idx == -1)
                l.add(a[i]);
            else
                l.set(idx, a[i]);
        }
        return l.size();
    }
    
    static int bs(ArrayList<Integer> l, int size, int key) {
        int s = 0, e = size-1;
        int ans = -1;
        
        while(s<= e) {
            int mid = s+(e-s)/2;
            if(l.get(mid) >= key){
                ans = mid;
                e = mid - 1;
            }
            else
                s = mid+1;
                
        }
        return ans;
    }
    
    
    //DP will not work due to constraints.!
    // static int[] a; 
    // static int[][] dp;
    // static int longestSubsequence(int size, int ar[])
    // {
    //     a = ar;
    //     dp = new int[size+1][size+1];
    //     for(int[] row : dp)
    //         Arrays.fill(row, -1);
            
    //     return lis(0, -1);
    // }
    
    // //coordinate change
    // static int lis(int i, int lisTopIdx) {
    //     if(i == a.length)
    //         return 0;
            
    //     if(dp[lisTopIdx+1][i]!=-1)
    //         return dp[lisTopIdx+1][i];
            
    //     if(lisTopIdx == -1 || a[lisTopIdx] < a[i]) {
    //         //T or NT
    //         int take = 1+lis(i+1, i);
    //         int notTake = lis(i+1, lisTopIdx);
            
    //         return dp[lisTopIdx+1][i] = Math.max(take, notTake);
    //     }
    //     else{
    //         return dp[lisTopIdx+1][i] = lis(i+1, lisTopIdx);
    //     }
    // }
} 