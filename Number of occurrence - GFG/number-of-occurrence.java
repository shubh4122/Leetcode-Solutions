//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int s=bsl(arr, n, x);
        int e = bsr(arr, n, x);
        
        //it might be that x is not present in the arr
        if(s == -1 || e == -1)
            return 0;
        
        return e-s+1;
    }
    
    int bsr(int[] a, int n, int x) {
        int s = 0, e = n-1, r = -1;
        
        while(s <= e) {
            int mid = s+(e-s)/2;
            
            if(a[mid] <= x) {
                if(a[mid]==x)
                    r = mid;
                s = mid + 1;
            }
            
            else
                e = mid-1;
        }
        return r;
    }
    
    
    int bsl(int[] a, int n, int x) {
        int s = 0, e = n-1, l = -1;
        
        while(s <= e) {
            int mid = s+(e-s)/2;
            
            if(a[mid] >= x) {
                if(a[mid]==x)
                    l = mid;
                e = mid - 1;
            }
            
            else
                s = mid +1;
        }
        return l;
    }
}