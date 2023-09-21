//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        //bs on answers -> ans b/w min and max of matrix.
        int s = Integer.MAX_VALUE, e = 0;//s is min of all, e is max of all
        for (int i = 0; i < R; i++) {
            s = Math.min(s, matrix[i][0]);
            e = Math.max(e, matrix[i][C-1]);
        }

        //from this s and e, do a BS on Answers - basically find
        //count of numbers which are less than equal to curr num [mid]
        //if this count <= required,
        //Note: the point of number of elem <= median must be just greater than req
        int required = R*C/2;//Median must have at-least these many elem towards left and right each

        while (s <= e) {
            int median = s + (e-s)/2;//this is mid. I just named it differently
            int smallerElemCount = countSmallerElem(matrix, median);

            if (smallerElemCount <= required)
                s = median+1;
            else
                e = median-1;
        }
        return s;//imp note why this is the answer
    }

    private int countSmallerElem(int[][] matrix, int median) {
        //here we need to find the upper bound of the number - median
        //that is the number JUST GREATER than median.
        //all nums lesser than it would be <= median
        //do this for each row and keep count/.
        int count = 0;
        for (int i = 0; i < matrix.length; i++)
            count += upperBound(matrix[i], median);

        return count;
    }

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