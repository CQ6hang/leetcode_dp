public class LeetCode188 {
    public static void main(String[] args) {
        int[] prices = new int[]{2, 4, 1};
        int k = 2;

        int days = prices.length;
        if (days == 0 || k == 0) {
            System.out.println(0);
        }
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; ++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 0; i < days; ++i) {
            for (int j = k; j > 0; --j) {
                dp[j - 1][1] = Math.max(dp[j - 1][0] - prices[i], dp[j - 1][1]);
                dp[j][0] = Math.max(dp[j - 1][1] + prices[i], dp[j][0]);
            }
        }
        System.out.println(dp[k][0]);
    }
}
