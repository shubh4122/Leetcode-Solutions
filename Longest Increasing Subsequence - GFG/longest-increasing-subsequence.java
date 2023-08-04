//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int nums[])
    {
        //intuition in notes.
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) < num)
                temp.add(num);
            else {
                //binary search. - coz the array is sorted by default!
                int insertAt = binarySearch(temp, num);
                temp.set(insertAt, num);
            }
        }
        return temp.size();
    }
    
    private static int binarySearch(ArrayList<Integer> temp, int num) {
        int s = 0, e = temp.size()-1;

        while (s <= e){
            int mid = s + (e-s)/2;

            if (temp.get(mid) == num)
                return mid;

            else if (temp.get(mid) < num)
                s = mid + 1;

            else
                e = mid - 1;
        }
        return e+1;
    }
} 