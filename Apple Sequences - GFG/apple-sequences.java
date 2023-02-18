//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String s){
        //code here
        //mark window with 2 pointers, start and end
        int start = 0, end = -1;
        int mCopy = m;
        int maxSubseq = Integer.MIN_VALUE;

        //extra memory used
        ArrayList<Integer> posO = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) != 'O' || mCopy > 0){
                //we can increase window.
                end++;

                if (s.charAt(i) == 'O') {
//                    posO.add(i);
                    mCopy--;//O is entered in window on cost of M
                }

                maxSubseq = Math.max(maxSubseq, end - start + 1);
            }
            else if (s.charAt(start) == 'O' && s.charAt(i) == 'O') {
                //eliminating start O and putting in current O. (MOVING WINDOW)
                start++;
//                posO.add(i);
//                posO.remove(0);
                end++;
            }
            else {
                //Runs when an O comes, when m = 0;
                //this makes window of size m. RESIZING WINDOW
                //removing the first occuring O, by making start next to first O

                do {
                    start++;
                }
                while (s.charAt(start-1) != 'O');
//                start = end - m + 2;
                end++;
            }
        }
        return maxSubseq;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends