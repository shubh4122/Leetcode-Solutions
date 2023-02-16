//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSum(arr, 0, 0, ans);
        return ans;
    }
    
    public static void subsetSum(ArrayList<Integer> ip, int index, int opSum, ArrayList<Integer> ans) {
        //Ip/Op method. - Recursive tree
        //BC
        if (index == ip.size()) {//that pointer reached end. input list finished
            ans.add(opSum);
            return;
        }

        //not take
        subsetSum(ip, index + 1, opSum, ans);

        //take
        subsetSum(ip, index + 1, opSum + ip.get(index), ans);
    }

}