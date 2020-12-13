public class LeetCode152 {
    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};

        int len = nums.length;
        int result = nums[0];
        int curr_max = nums[0];
        int curr_min = nums[0];
        for (int i = 1; i < len; ++i) {
//            if (nums[i] < 0) {
                int temp_curr_max = Math.max(Math.max(curr_max * nums[i], curr_min * nums[i]), nums[i]);
                curr_min = Math.min(Math.min(curr_max * nums[i], curr_min * nums[i]), nums[i]);
                curr_max = temp_curr_max;
                result = Math.max(result,curr_max);
//            } else {

//            }
        }
        System.out.println(result);
    }
}
