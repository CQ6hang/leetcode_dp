import java.security.interfaces.RSAKey;

public class LeetCode123 {
    public static void main(String[] args) {
        //  构造样例输入
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};

        // 算法部分
        int[][][] result = new int[prices.length][3][2];
        int n = prices.length;
        result[0][0][0] = 0;
        result[0][0][1] = -prices[0];
        result[0][1][0] = 0;
        result[0][1][1] = -prices[0];
        result[0][2][0] = 0;

        for (int i = 1; i < prices.length; ++i) {
            result[i][0][0] = result[i - 1][0][0];
            //  第一次买入卖出
            result[i][0][1] = Math.max(result[i - 1][0][1], result[i - 1][0][0] - prices[i]);
            result[i][1][0] = Math.max(result[i - 1][1][0], result[i - 1][0][1] + prices[i]);
            //  第二次买入卖出
            result[i][1][1] = Math.max(result[i - 1][1][1], result[i - 1][1][0] - prices[i]);
            result[i][2][0] = Math.max(result[i - 1][2][0], result[i - 1][1][1] + prices[i]);
        }

        int a = Math.max(result[n - 1][0][0], result[n - 1][0][1]);
        int b = Math.max(result[n - 1][1][0], result[n - 1][1][1]);
        System.out.println(Math.max(Math.max(a, b), result[n - 1][2][0]));
    }
}
