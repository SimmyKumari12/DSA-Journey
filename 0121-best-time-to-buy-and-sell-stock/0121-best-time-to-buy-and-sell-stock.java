class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyPrice = Integer.MAX_VALUE;       
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            } else {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
            
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}