package indi.lean.acm.dp;

public class Problem121 {

    public static int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];

        profit[0] = 0;
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                profit[i] = profit[i - 1] + (prices[i] - max);
                max = prices[i];
            } else {
                profit[i] = profit[i - 1];
            }
        }

        return profit[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        System.out.println(maxProfit(price));
    }
}
