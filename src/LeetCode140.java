import java.util.ArrayList;
import java.util.HashSet;

public class LeetCode140 {
    public static void main(String[] args) {
        //  构造输入样例
        String s = "catsanddog";
        HashSet<String> wordDict = new HashSet<>() {
            {
                add("cat");
                add("cats");
                add("and");
                add("sand");
                add("dog");
            }
        };

        //  算法部分
        int len = s.length();
        boolean[] result = new boolean[len + 1];
        ArrayList<ArrayList<String>> sentences = new ArrayList<>();

        result[0] = true;
        sentences.add(new ArrayList<>() {
            {
                add("");
            }
        });

        for (int i = 1; i <= len; ++i) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    //  记录符合条件的句子
                    for (String str : sentences.get(j)) {
                        if (j != 0) {
                            temp.add(str + " " + s.substring(j, i));
                        } else {
                            temp.add(str + s.substring(j, i));
                        }
                    }
                }
            }
            sentences.add(temp);
        }
        if (result[len]) {
            System.out.println(sentences.get(len).toString());
        } else {
            System.out.println("[]");
        }
    }
}
