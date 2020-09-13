import java.util.Arrays;

public class LeetCode121 {
    public static void main(String[] args) {
        //  构造样例输入
        int[] price = new int[]{7, 1, 5, 3, 6, 4};

        //  算法部分
        int[] result = new int[price.length];
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            int[] temp = Arrays.copyOfRange(price, 0, i);
            Arrays.sort(temp);
            result[i] = Math.max(price[i] - temp[0], 0);
        }
        Arrays.sort(result);
        System.out.println(result[result.length - 1]);
    }
}

