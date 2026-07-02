class Solution {
    public int maxProfit(int[] prices) {
        int currMin = Integer.MAX_VALUE;
        int maxP = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            currMin = Math.min(currMin, prices[i]);
            maxP = Math.max(maxP, prices[i] - currMin);
        }
        return maxP;
    }
}