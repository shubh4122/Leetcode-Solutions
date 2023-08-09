class Solution {
    public int mySqrt(int x) {
        int s = 0, e = x;
        
        while(s <= e) {
            int mid = s+(e-s)/2;
            
            if((long)mid*mid <= x) 
                s = mid+1;
            
            else //>x
                e = mid - 1;
        }
        
        return e;//coz at the end, e will always point to the Max number which is the integer part of sqrt(x)
    }
}