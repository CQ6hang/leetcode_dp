public class LeetCode714 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;

        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        int days = prices.length;
        for (int i = 1; i < days; ++i) {
            int temp = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
            dp[0] = temp;
        }
        System.out.println(dp[1]);
    }
}
