import java.util.ArrayList;
import java.util.HashSet;

public class LeetCode140 {
    public static void main(String[] args) {
        //  构造输入样例
        String s = "catsanddog";
        HashSet<String> wordDict = new HashSet<String>() {
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

        int max_word_len = 0;
        for (String word : wordDict) {
            if (word.length() > max_word_len) {
                max_word_len = word.length();
            }
        }

        result[0] = false;
        sentences.add(new ArrayList<String>() {
            {
                add("");
            }
        });

        for (int i = 1; i <= len; ++i) {
            ArrayList<String> temp = new ArrayList<>();
            if (i <= max_word_len && wordDict.contains(s.substring(0, i))) {
                result[i] = true;
                temp.add(s.substring(0, i));
            }
            for (int j = Math.max(i - max_word_len, 0); j < i; ++j) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    //  记录符合条件的句子
                    for (String str : sentences.get(j)) {
                        temp.add(str + " " + s.substring(j, i));
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
