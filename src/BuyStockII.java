
/**
 * 买卖股票的最佳时机 II
 */

 // 贪心法
public class BuyStockII {
    public int maxProfit(int[] prices)
    {
        if (prices==null || prices.length==0) return 0;

        int profit = 0;
        for (int i=1; i<prices.length; i++)
        {
            if (prices[i] > prices[i-1])
            {
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }

    // 动态规划
    public int maxProfit2 (int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1; i < n; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[n-1][0];
    }
}
