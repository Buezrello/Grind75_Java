package grind75.besttimebuysellstock;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
 *
 * @author Igor Gindin
 * @since 23/01/2023
 */
public class BestTimeBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        int[] prices3 = {1, 2};
        int[] prices4 = {2,4,1};

        final BestTimeBuyAndSellStock bestTimeBuyAndSellStock = new BestTimeBuyAndSellStock();

        System.out.println(bestTimeBuyAndSellStock.maxProfit(prices1));
        System.out.println(bestTimeBuyAndSellStock.maxProfit(prices2));
        System.out.println(bestTimeBuyAndSellStock.maxProfit(prices3));
        System.out.println(bestTimeBuyAndSellStock.maxProfit(prices4));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int newProfit = price - minPrice;
            if (newProfit > maxProfit) {
                maxProfit = newProfit;
            }
        }

        return maxProfit;
    }

}
