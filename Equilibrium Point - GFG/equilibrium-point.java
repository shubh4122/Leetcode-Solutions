//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

//8
// 8 8 3 7 8 2 7 2
    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        int s = -1, e = n;
        long s1 = 0, s2 = 0;
        while(s+1 < e) {
            if(s1 < s2 || (s1==s2 && s+2 != e)){
                s++;
                s1 += arr[s];
            }
            if(s2 < s1 || (s1==s2 && s+2 != e)){
                e--;
                s2 += arr[e];
            }
            
            if(s1 == s2 && s+2 == e) 
                return s+2;//index of eqb
                
        }
        return -1;
    }
}
