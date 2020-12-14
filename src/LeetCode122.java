public class LeetCode122 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        int days = prices.length;
        int[] dp = new int[]{0, -prices[0]};
        for (int i = 1; i < days; ++i) {
            int temp_0 = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[0] - prices[i], dp[1]);
            dp[0] = temp_0;
        }
        System.out.println(dp[0]);
    }
}
