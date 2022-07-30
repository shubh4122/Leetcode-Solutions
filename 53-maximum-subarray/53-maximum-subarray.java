class Solution {
    public int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }
        
        return maxSum;
    }
}