//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        
        //Finding maxSum among all rows
        int maxSum = 0, sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += matrix[i][j];
            }
            maxSum = Math.max(maxSum, sum);
            sum = 0;
        }
        
        //max sum among all cols
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += matrix[j][i];
            }
            maxSum = Math.max(maxSum, sum);
            sum = 0;
        }
        
        //counting no. of ops required for all rows to be equal to max sum
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += matrix[i][j];
            }
            count += maxSum - sum;
            sum = 0;
        }
        
        //counting no. of ops for all cols
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += matrix[j][i];
            }
            count += maxSum - sum;
            sum = 0;
        }
        return count/2;
    }
}
        
