/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int s = 1,  e= n;
        
        while( s <= e) {
            int mid = s + (e-s)/2;
            /*
                Idea: Obviously, starting will be good versions, and end would be bad.
                So, always do  e = mid -1. until you find mid to be a good version. When you do, then do a s = mid +1
            */
            if(isBadVersion(mid)) {
                if(mid == 0 || ! isBadVersion(mid-1))//checking if mid is the first bad version
                    return mid;
                
                e = mid - 1;
            }
            else{//mid is good version
                if(isBadVersion(mid+1))
                    return mid+1;
                s = mid +1;
            }
        }
        return -1;
    }
}