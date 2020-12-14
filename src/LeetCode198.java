public class LeetCode198 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};

        int len = nums.length;
        if (len == 0) {
            System.out.println(0);
        }
        int[][] dp = new int[len + 1][2];
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        for (int i = 2; i <= len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        System.out.println(Math.max(dp[len][0], dp[len][1]));
    }
}
