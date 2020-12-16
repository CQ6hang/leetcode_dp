public class LeetCode264 {
    public static void main(String[] args) {
        int n = 10;

        int[] ugly_nums = new int[n];
        ugly_nums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ) {
            int min_value = Math.min(2 * ugly_nums[p2], Math.min(3 * ugly_nums[p3], 5 * ugly_nums[p5]));
            if (min_value != ugly_nums[i - 1]) {
                ugly_nums[i] = min_value;
                ++i;
            }
            if (2 * ugly_nums[p2] <= Math.min(3 * ugly_nums[p3], 5 * ugly_nums[p5])) {
                ++p2;
            } else if (3 * ugly_nums[p3] <= 5 * ugly_nums[p5]) {
                ++p3;
            } else {
                ++p5;
            }
        }
        System.out.println(ugly_nums[n - 1]);
    }
}
