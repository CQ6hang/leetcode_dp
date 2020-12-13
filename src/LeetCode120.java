import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode120 {
    public static void main(String[] args) {
        //  构造样例
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>() {
            {
                add(2);
            }
        });
        triangle.add(new ArrayList<Integer>() {
            {
                add(3);
                add(4);
            }
        });
        triangle.add(new ArrayList<Integer>() {
            {
                add(6);
                add(5);
                add(7);
            }
        });
        triangle.add(new ArrayList<Integer>() {
            {
                add(4);
                add(1);
                add(8);
                add(3);
            }
        });

        //  算法部分
        int rows = triangle.size();
        int[] result = new int[rows];
        result[0] = triangle.get(0).get(0);
        for (int i = 1; i < rows; i++) {
            int[] temp_result = new int[rows];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    temp_result[j] = result[j] + triangle.get(i).get(j);
                } else if (j == i) {
                    temp_result[j] = result[j - 1] + triangle.get(i).get(j);
                } else {
                    temp_result[j] = Math.min(result[j - 1] + triangle.get(i).get(j), result[j] + triangle.get(i).get(j));
                }
            }
            result = temp_result;
        }
        Arrays.sort(result);
        System.out.println(result[0]);
    }
}
