class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = 0;

        for(int price : prices){
            if(buyPrice > price){
                buyPrice = price;
            }
            profit = price - buyPrice;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}