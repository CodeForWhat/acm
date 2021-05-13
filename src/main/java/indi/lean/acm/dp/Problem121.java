package indi.lean.acm.dp;

public class Problem121 {

    public static int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }

            maxProfit = Math.max(maxProfit, price - min);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        System.out.println(maxProfit(price));
    }
}
