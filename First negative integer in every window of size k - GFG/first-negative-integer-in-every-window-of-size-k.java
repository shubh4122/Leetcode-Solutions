//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long a[], int n, int k) {
        //Use a queue for keeping track of all negative nums
        Queue<Long> q = new LinkedList<>();
        int s = 0, e = 0;
        long[] ans = new long[n-k+1];//for each window we need to find First negative
        int i = 0;

        while (e < n) {
            //store any negative num encountered
            if (a[e] < 0)
                q.add(a[e]);

            if (e-s+1 == k) {
                ans[i++] = q.isEmpty() ? 0 : q.peek();//update 1st negative for this window
                if (!q.isEmpty() && a[s] == q.peek())//remove this negative from Q, if its present at Start
                    q.remove();
                s++;//move start
            }
            e++;
        }
        return ans;
    }
}