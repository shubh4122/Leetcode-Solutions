//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    
    
    //Question type 2 - Both Positive and Negative elements.
    //PREFIX SUM + HASHING
    public static int lenOfLongSubarr(int[] arr, int n, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();//elem : index
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i]+arr[i-1];//prefix sum
            map.put(arr[i], i);
        }

        int maxWindowSize = 0;
        //Check if the prefix sum already contains the targetSum.
        //If yes, our window will be from [0] to [idx of targetSum in prefix Sum arr]
        //For cases like: Target = 16, [1 4 3 3 5 5]
        if (map.containsKey(targetSum))
            maxWindowSize = map.get(targetSum)+1;
        //Here s -> start is not the start of window.
        //This is the end of prefix Window
        for(int s = 0; s < arr.length; s++){
            if (map.containsKey(targetSum + arr[s])) {
                int e = map.get(targetSum+arr[s]);
                if (e >= s)
                    maxWindowSize = Math.max(maxWindowSize, e-s);
            }
        }
        return maxWindowSize;
    }

    
}


