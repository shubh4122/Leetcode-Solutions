//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    //M2: Better O(nLogN) Merge Sort solution
    static long inversionCount(long arr[], long n) {
        long[] count = new long[1];
        mergeSortCntInv(arr, (int) n, count);
        return count[0];
    }

    private static void mergeSortCntInv(long[] arr, int n, long[] count) {
        if (n <= 1)//if array len is 1 or less, it doesn't need to be split and merged Or even sorted
            return;
        
        int mid = n/2;
        long[] left, right;
        left = new long[mid];
        right = new long[n-mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i-mid] = arr[i];
        }

        mergeSortCntInv(left, left.length, count);
        mergeSortCntInv(right, right.length, count);

        //merging and counting
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length){
            if (left[i] > right[j]){
                count[0] += left.length - i;
                arr[k++] = right[j++];
            }
            else 
                arr[k++] = left[i++];
        }
        
        while (i < left.length)
            arr[k++] = left[i++];
        
        while (j < right.length)
            arr[k++] = right[j++];
    }

}