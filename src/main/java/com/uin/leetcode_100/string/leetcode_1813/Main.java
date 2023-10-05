package main.java.com.uin.leetcode_100.string.leetcode_1813;

/**
 * 1813. 句子相似性 III
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World"，"HELLO"，"hello world hello world"都是句子。每个单词都 只包含大写和小写英文字母。
 * <p>
 * 如果两个句子sentence1 和sentence2，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的。比方说，sentence1 = "Hello my name is Jane" 且sentence2 = "Hello Jane"，我们可以往 sentence2中"Hello" 和"Jane"之间插入"my name is"得到 sentence1。
 * <p>
 * 给你两个句子sentence1 和sentence2，如果sentence1 和sentence2 是相似的，请你返回true，否则返回false。
 * 示例 1：
 * <p>
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 * 示例 2：
 * <p>
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 * 示例 3：
 * <p>
 * 输入：sentence1 = "Eating right now", sentence2 = "Eating"
 * 输出：true
 * 解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
 * 示例 4：
 * <p>
 * 输入：sentence1 = "Luky", sentence2 = "Lucccky"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1和sentence2都只包含大小写英文字母和空格。
 * sentence1和sentence2中的单词都只由单个空格隔开。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sentence-similarity-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        areSentencesSimilar("My name is Haley","My Haley");
    }
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        // 句子是由 一些单词和他们之间的空格组成，且句子的开头和结尾没有多余的。
        // 每个单词只包含大写和小写字母

        // 两个句子，可以通过其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，就是相似的
        if (sentence1.equals(sentence2)) {
            return true;
        }

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        // 双指针
        int i = 0, j = 0;
        while (i < s1.length && i < s2.length && s1[i].equals(s2[i])) {
            i++;
        }

        while (j < s1.length - i && j < s2.length - i && s1[s1.length - j - 1].equals(s2[s2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(s1.length, s2.length);
    }
}
