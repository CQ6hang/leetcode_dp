public class LeetCode213 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2};

        int len = nums.length;
        if (len == 0) {
            System.out.println(0);
        }
        // 偷第一间房间
        int[][] dp = new int[len + 1][2];
        // 不偷第一间房间
        int[][] dp2 = new int[len + 1][2];
        dp[2][0] = nums[0];
        dp[2][1] = 0;
        dp2[2][0] = 0;
        dp2[2][1] = nums[1];
        for (int i = 3; i <= len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
            dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
            dp2[i][1] = dp2[i - 1][0] + nums[i - 1];
        }
        System.out.println(Math.max(dp[len][0], Math.max(dp2[len][0], dp2[len][1])));
    }
}
