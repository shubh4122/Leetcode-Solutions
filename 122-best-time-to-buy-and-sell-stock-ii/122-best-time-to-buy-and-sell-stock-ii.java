class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = -1;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i-1] < prices[i] && buy == -1) {
                buy = prices[i-1];
            }
            if(prices[i-1] > prices[i] && buy != -1){
                profit += prices[i-1] - buy;
                buy = -1;
            }
        }
        if(buy != -1){
            profit += prices[prices.length-1] - buy;
        }
        return profit;
    }
}