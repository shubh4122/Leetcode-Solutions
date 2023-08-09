class Solution {
    public int search(int[] nums, int target) {
        //Modified BS
        
        int s = 0, e = nums.length-1;
        while(s <= e) {
            int mid = s +(e-s)/2;
            
            if(nums[mid] == target)
                return mid;
            
            //1st find out which side does mid lie -> sorted array side or uneven arr side
            if(nums[mid] <= nums[e]) {
                //check if t lies between SORTED arr from mid to end. -> this part will for sure be sorted
                if(nums[mid] <= target && target <= nums[e])
                    s = mid +1;
                else
                    e = mid - 1;
            }
            else{
                if(nums[s]<= target && target <= nums[mid])
                    e = mid - 1;
                
                else
                    s = mid+1;
            }
        }
        return -1;
    }
}