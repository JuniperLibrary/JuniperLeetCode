package main.java.com.uin.leetcode_100.bfs.leetcode_854;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 854.相似度为 K 的字符串
 * 对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。
 * 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
 * <p>
 * 输入：s1 = "abc", s2 = "bca"
 * 输出：2
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(kSimilarity(s1, s2));
    }

    /**
     * 1、首先BFS过程中存下每一种中间状态，因为第一次搜到肯定是到达的最小步数，重复搜索直接跳过；
     * 2、进行字符串之间的状态转移的时候，如果某一位已经和最终状态相同了，那么这位就不要动它，因为动了只会使得步数增加，不是最优解；
     * 3、同样的，每次交换，至少要是使得中间状态的某一位变成最终状态的字符，否则这一步就白交换了，得到的也一定不是最小次数；
     * 4、每一步只考虑交换一位，并且要寻找所有的这一位后边可以交的位置拓展出一些新的中间状态
     */
    public static int kSimilarity(String s1, String s2) {
        int n = s1.length();
        char c[] = s2.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(s1);
        map.put(s1, 0);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            char c1[] = s.toCharArray();
            int a = map.get(s);
            for (int j = 0; j < n; j++) {
                if (c1[j] != c[j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (c1[k] == c[j] && c1[k] != c[k]) {
                            exchange(c1, j, k);
                            String t = new String(c1);
                            if (t.equals(s2)) {
                                return 1 + a;
                            }
                            if (!map.containsKey(t)) {
                                list.add(t);
                                map.put(t, a + 1);
                            }
                            exchange(c1, j, k);
                        }
                    }
                    break;
                }
            }
        }
        return 0;
    }

    static void exchange(char c[], int x, int y) {
        char ch = c[x];
        c[x] = c[y];
        c[y] = ch;
    }
}
