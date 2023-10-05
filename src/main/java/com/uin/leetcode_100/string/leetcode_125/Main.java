package main.java.com.uin.leetcode_100.string.leetcode_125;

/**
 * 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class Main {
    /**
     * 遍历
     *
     * @param s
     * @return boolean
     * @author wanglufei
     * @date 2022/9/6 9:57 AM
     */
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isJavaLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        StringBuffer reverse = new StringBuffer(sb).reverse();
        return sb.toString().equals(reverse);
    }

    /**
     * 双指针
     *
     * @param s
     * @return boolean
     * @author wanglufei
     * @date 2022/9/6 10:05 AM
     */
    public boolean helper(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //字符是字母还是数字
            if (Character.isJavaLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int n = sb.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean solve(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= '0' && temp <= '9') {
                sb.append(temp);
            } else if (temp >= 'a' && temp <= 'z') {
                sb.append(temp);
            } else if (temp >= 'A' && temp <= 'Z') {
                sb.append((char) (temp + 32));
            }
        }

        int left = 0, right = s.length() - 1;

        while (left <= right) {
            if (sb.charAt(left) == sb.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
