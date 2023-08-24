//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //HANDLE NEGATIVE STRINGS - only if 1 is negative only then ans is negative
        boolean negative = s1.charAt(0)=='-' ^ s2.charAt(0)=='-';
        if(s1.charAt(0)=='-')
            s1 = s1.substring(1);
        if(s2.charAt(0)=='-')
            s2 = s2.substring(1);
        
        int cut = -1;
        for(int i = 0; i<s1.length(); i++) {
            if(s1.charAt(i)=='0')
                cut = i;
            else 
                break;
        }
        s1 = s1.substring(cut+1);
        
        cut = -1;
        for(int i = 0; i<s2.length(); i++) {
            if(s2.charAt(i)=='0')
                cut = i;
            else 
                break;
        }
        s2 = s2.substring(cut+1);
        
        // System.out.println(s1);
        
        StringBuilder ans = new StringBuilder();
        int l1 = s1.length();
        int l2 = s2.length();
        ArrayList<Integer> levels = new ArrayList<>();
        
        for(int i = l2-1; i >= 0; i--){
            int d1 = s2.charAt(i)-'0';
            int carry = 0;
            
            //enter 0's at the end.
            for(int z = 0; z  < l2-i-1; z++){
                levels.add(0);
            }
            
            
            for(int j = l1-1; j >= 0; j--){
                int d2 = s1.charAt(j)-'0';
                // System.out.println(d1 +" "+ d2);
                int pdt = d1*d2 + carry;
                levels.add(pdt%10);
                carry = pdt/10;
            }
            if(carry != 0)
                levels.add(carry);
                
            if(i == l2-1){
                for(int t = 0; t < levels.size(); t++){
                    ans.append(levels.get(t));
                }   
            }
            else{
                int carry1 = 0;
                for(int l = 0; l < levels.size(); l++){
                    int n1 = 0, n2 = levels.get(l);
                    if(l < ans.length())
                        n1 = ans.charAt(l)-'0';
                        
                    int sum = n1+n2 + carry1;
                    if(l < ans.length())
                        ans.setCharAt(l, (char)(sum%10 + 48));
                    else
                        ans.append(sum%10);
                    carry1 = sum/10;
                }
                if(carry1!=0)
                    ans.append(carry1);
            }
            levels.clear();
        }
        
        // System.out.println(levels);
        
        if(negative)
            ans.append('-');
        // System.out.println(ans.reverse());
        return ans.reverse().toString();
    }
}