//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    ArrayList<String> ans;
    StringBuilder p;
    boolean[] vis;
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ans = new ArrayList<>();
        p = new StringBuilder();
        vis = new boolean[S.length()+1];
        make(S);
        
        Collections.sort(ans);
        
        return ans;
    }
    
    
	public void make(String s)
    {
        //Your code here
        if(p.length() == s.length()){
            ans.add(p.toString());
            return;
        }
        
        for(int i= 0; i<s.length(); i++){
            if(vis[i]) continue;
            
            vis[i]=true;
            p.append(s.charAt(i));
            make(s);
            p.deleteCharAt(p.length()-1);
            vis[i] = false;
        }
    }   
}
