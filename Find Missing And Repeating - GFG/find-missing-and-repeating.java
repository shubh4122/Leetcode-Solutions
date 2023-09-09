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
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int N) {
        // code here
        long n = arr.length;
        long sumNaturalNums = n *(n+1)/2;
        long sumOfSquaresNaturalNums = n*(n+1)*(2*n+1)/6;

        long sumArr = 0, sumOfSqArr = 0;
        for (int val : arr) {
            sumArr += val;
            sumOfSqArr += (long) val *val;
        }

        long X = sumNaturalNums - sumArr;
        long Y = sumOfSquaresNaturalNums - sumOfSqArr;
        Y = Y/X;

        long B = (X + Y)/2;//Do basic maths to find this.
        long A = Y - B;

        return new int[]{(int)A, (int)B};
    }
}