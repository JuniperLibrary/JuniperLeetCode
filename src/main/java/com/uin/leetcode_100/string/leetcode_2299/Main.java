package main.java.com.uin.leetcode_100.string.leetcode_2299;

import java.util.HashSet;
import java.util.Set;

/**
 * 2299. 强密码检验器 II
 * 如果一个密码满足以下所有条件，我们称它是一个 强密码：
 *
 * 它有至少 8个字符。
 * 至少包含 一个小写英文字母。
 * 至少包含 一个大写英文字母。
 * 至少包含 一个数字。
 * 至少包含 一个特殊字符。特殊字符为："!@#$%^&*()-+"中的一个。
 * 它 不包含2个连续相同的字符（比方说"aab"不符合该条件，但是"aba"符合该条件）。
 * 给你一个字符串password，如果它是一个强密码，返回true，否则返回false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：password = "IloveLe3tcode!"
 * 输出：true
 * 解释：密码满足所有的要求，所以我们返回 true 。
 * 示例 2：
 *
 * 输入：password = "Me+You--IsMyDream"
 * 输出：false
 * 解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
 * 示例 3：
 *
 * 输入：password = "1aB!"
 * 输出：false
 * 解释：密码不符合长度要求。所以我们返回 false 。
 *
 *
 * 提示：
 *
 * 1 <= password.length <= 100
 * password包含字母，数字和"!@#$%^&*()-+"这些特殊字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/strong-password-checker-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public boolean strongPasswordCheckerII(String password) {

        //它有至少 8个字符。
        if (password.length() < 8) {
            return false;
        }

        Set<Character> specials = new HashSet<Character>() {{
            add('!');
            add('@');
            add('#');
            add('$');
            add('%');
            add('^');
            add('&');
            add('*');
            add('(');
            add(')');
            add('-');
            add('+');
        }};

        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        for (int i = 0; i < n; ++i) {
            //它 不包含2个连续相同的字符（比方说"aab"不符合该条件，但是"aba"符合该条件）。
            if (i != n - 1 && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }

            char ch = password.charAt(i);
            //至少包含 一个小写英文字母。
            if (Character.isLowerCase(ch)) {
                hasLower = true;
                // 至少包含 一个大写英文字母。
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
                //至少包含 一个数字。
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
                //至少包含 一个特殊字符。特殊字符为："!@#$%^&*()-+"中的一个。
            } else if (specials.contains(ch)) {
                hasSpecial = true;
            }
        }

        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}
