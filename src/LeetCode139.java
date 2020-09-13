import java.util.HashSet;

public class LeetCode139 {
    public static void main(String[] args) {
        //  构造样例输入
        String s = "leetcode";
        HashSet<String> wordDict = new HashSet<>() {
            {
                add("leet");
                add("code");
            }
        };

        //  算法部分
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        System.out.println(result[s.length()]);
    }
}
