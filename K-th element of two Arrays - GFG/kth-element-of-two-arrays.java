//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    

    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        //BS on both arr. for each mid. find num of elem <= it.
        //if count > k, it is answer.
        long val1 = binarySearch(arr1, arr2, k);
        long val2 = binarySearch(arr2, arr1, k);

        return Math.min(val1, val2);
    }

    private long binarySearch(int[] arr, int[] other, int k) {
        int s = 0, e = arr.length-1;

        while (s <= e) {
            int mid = s + (e-s)/2;
            long smallerEqualElemCount = countSmallerElem(arr, other, arr[mid]);

            if (smallerEqualElemCount < k)
                s = mid+1;
            else
                e = mid-1;
        }
        if (s < arr.length)
            return arr[s];
        return Integer.MAX_VALUE;
    }


    //TC: O(R.logC)
    private long countSmallerElem(int[] a1, int[] a2, int num) {
        long count = 0;
        count += upperBound(a1, num);
        count += upperBound(a2, num);

        return count;
    }

    //TC: O(log C)
    private int upperBound(int[] arr, int num) {
        int s = 0, e = arr.length-1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (arr[mid] <= num){
                s = mid + 1;
            }
            else
                e = mid - 1;
        }
        return s;//s points to the upper bound of number
    }
}