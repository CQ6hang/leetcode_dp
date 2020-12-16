public class LeetCode309 {
    public static void main(String[] args) {
        int[] prices = new int[]{6, 1, 6, 4, 3, 0, 2};

        int days = prices.length;
        int[][] dp = new int[days][3];
        int max_profit = 0;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < days; ++i) {
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][1];
        }
        System.out.println(Math.max(dp[days - 1][1], dp[days - 1][2]));
    }
}
