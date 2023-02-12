//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int i)
    {
        // Your code here
        int mask = 1<<(i); // we left shift 1, i-1 times, hence pushing these 0's after 1
        n = n & mask;//extracts the ith bit. rest bits made 0
        n = n >> (i);//right shifted to eliminate all right 0's and get ith bit alone!
        //  int ans = 0;
        // for (int j = 0; j < i; j++) {//i  times
        //     n /= 2;
        // }
        // return n%2 == 1;//returning i'th bit
        return n == 1;
    }
    
}

//{ Driver Code Starts.

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			k = Integer.parseInt(br.readLine()); // Input K
			
			CheckBit obj = new CheckBit();
			
			if(obj.checkKthBit(n, k))
				System.out.println("Yes"); //If true, print Yes
				
			else
				System.out.println("No");	// Else print No
            
            t--;
		}
	}
	
	
}
// } Driver Code Ends