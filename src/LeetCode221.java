import java.util.Arrays;
import java.util.stream.Stream;

public class LeetCode221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        int w = matrix.length;
        int l = matrix[0].length;
        if (w == 0 || l == 0) {
            System.out.println(0);
        }
        int max_len = 0;
        int[][] dp = new int[w + 1][l + 1];
        for (int i = 1; i <= w; ++i) {
            for (int j = 1; j <= l; ++j) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    max_len = Math.max(max_len, dp[i][j]);
                }
            }
        }
        System.out.println(max_len * max_len);
    }
}
