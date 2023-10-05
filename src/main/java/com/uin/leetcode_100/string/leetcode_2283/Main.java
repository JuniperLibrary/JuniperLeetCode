package main.java.com.uin.leetcode_100.string.leetcode_2283;

import java.util.HashMap;

/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 * 给你一个下标从 0开始长度为 n的字符串num，它只包含数字。
 * <p>
 * 如果对于 每个0 <= i < n的下标i，都满足数位i在 num中出现了num[i]次，那么请你返回true，否则返回false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "1210"
 * 输出：true
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * "1210" 满足题目要求条件，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：num = "030"
 * 输出：false
 * 解释：
 * num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了一次。
 * num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
 * num[2] = '0' 。数字 2 在 num 中出现了 0 次。
 * 下标 0 和 1 都违反了题目要求，所以返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == num.length
 * 1 <= n <= 10
 * num只包含数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        digitCount("1210");
    }

    public static boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i) - '0';
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != map.getOrDefault(i, 0)) {
                return false;
            }
        }
        return true;
    }
}
