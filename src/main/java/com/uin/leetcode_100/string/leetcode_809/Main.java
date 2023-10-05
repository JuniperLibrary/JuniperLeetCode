package com.uin.leetcode_100.string.leetcode_809;

/**
 * 809. 情感丰富的文字
 * 题目描述提示帮助提交记录题目讨论社区题解
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * <p>
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * <p>
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
 * <p>
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * 示例：
 * <p>
 * 输入：
 * s = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, words.length <= 100
 * 1 <= words[i].length <= 100
 * s 和所有在 words 中的单词都只由小写字母组成。
 */
public class Main {
    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(helper(s, words));
    }

//    public static int expressiveWords(String s, String[] words) {
//        int n = s.length(), ans = 0;
//        char[] str = s.toCharArray();
//        Map<Character, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < str.length; i++) {
//            map.put(str[i], map.getOrDefault(str[i], 0) + 1);
//        }
//
//        for (String word : words) {
//            if (!word.contains(s)) return ans;
//            char[] c = word.toCharArray();
//            for (int i = 0; i < c.length; i++) {
//                if (map.get(word.charAt(i++)) > 3) {
//                    ans++;
//                } else {
//                    continue;
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * 【条件1】由于“e”和“o”在s中连续出现的次数是3（即：满足>=3），所以要求e和o在word中连续出现的次数不能超过3次
     * 【条件2】由于“h”和“l”在s中连续出现的次数不满足>=3，所以要求h和l在word中连续出现的次数要与s中出现的次数相同
     * 所以，我们在实现的时候，可以通过两个指针p1和p2，分别指向s和word，分别统计连续的相同字符数量c1和c2，
     * 然后再通过上述的两个条件进行判断，即：如果(c1 != c2 && c1 < 3) || (c1 < c2 && c1 >= 3)，则表示该单词不是可扩张的。
     */
    public static int helper(String s, String[] words) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (String word : words) {
            result += stretchyWord(chars, word.toCharArray()) ? 1 : 0;
        }
        return result;
    }

    private static boolean stretchyWord(char[] sc, char[] wc) {
        if (sc.length < wc.length) {
            return false;
        }
        int cp, p1 = 0, p2 = p1;
        while ((cp = p1) < sc.length && p2 < wc.length) {
            int c1 = 0;
            int c2 = 0;
            // 在字符串s中，遍历连续的字符sc[cp]的数量
            while (p1 < sc.length && sc[p1] == sc[cp]) {
                c1++;
                p1++;
            }
            // 在字符串word中，遍历连续的的字符sc[cp]的数量
            while (p2 < wc.length && wc[p2] == sc[cp]) {
                c2++;
                p2++;
            }
            if ((c1 != c2 && c1 < 3) || (c1 < c2 && c1 >= 3)) {
                return false;
            }
        }
        // 只有sc和wc都被遍历完毕，才返回true
        return p1 == sc.length && p2 == wc.length;
    }
}
