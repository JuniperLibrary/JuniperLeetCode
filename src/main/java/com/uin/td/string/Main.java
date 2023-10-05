package main.java.com.uin.td.string;
/**
 * 正则表达式匹配
 * 实现函数用来匹配包括'.'和'*'的正则表达式。
 * '.'表示任意一个字符
 * '*'表示他前面的字符可以出现任意次（包含0次）
 * 例如aaa与模式'a.a'可以匹配，但是'aa.a'和'ab*a'不匹配
 * pattern只包含a-z的小写字母，以及字符'.'和'*'
 * aaa
 * a*a
 *
 * @author wanglufei
 * @date 2022/8/11 7:58 PM
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String pattern = in.nextLine();
        System.out.println(helper(str, pattern));
    }

    /**
     * @param str     字符串
     * @param pattern 匹配规则
     * @return boolean 返回结果
     * @author wanglufei
     * @date 2022/8/11 8:05 PM
     */
    public static boolean helper(String str, String pattern) {
        char[] s = pattern.toCharArray();
        char[] patterns = str.toCharArray();

        if (s == null || patterns == null) return false;

        return matchRecur(s, patterns, 0, 0);
    }

    /**
     * 递归
     *
     * @param str
     * @param pattern
     * @param s
     * @param p
     * @return boolean
     * @author wanglufei
     * @date 2022/8/12 2:47 PM
     */
    private static boolean matchRecur(char[] str, char[] pattern, int s, int p) {
        //两个对比指针走到最后，则说明匹配成功
        if (s == str.length && p == pattern.length) {
            return true;
        }
        //模式串比文本先到末尾肯定没匹配成功，要想匹配成功必须是的条件是：模式串的长度>=文本串
        if (p == pattern.length && s < str.length) {
            return false;
        }
		/*现在开始正式分析
		第一个字符不相等的话，就直接返回false。return false;
		第二个字符就要分情况讨论了
			1、当模式中的第二字符不是   * 时，那就大家都往后比呗  ，文本和模式都往后移一步。
			   abc...(文本串)
			   abc...(模式串)
			   代码：(记住，由于模式串的长度>=文本，所以只要考虑文本是否越界就行)
			  if((s<str.length&&str[s]==pattern[p])||(pattern[p]=='.'&&s<str.length)) {
				  return matchRecur(str, pattern, s+1, p+1);
			  }
			2、当模式中第二个字符是 * 时，这个情况就有四种情况要考虑了
		                第一个字符不相等，例子ab和c*ab，一个a一个c，且模式串第二个* 则，直接patten向后跳两个指针：
				    return matchRecur(str, pattern, s, p+2);
			     当第一个字符相等时了？就有三种情况要考虑在内了
			       1、abc和a*bc  模式后移2字符,文本后移1个，相当于*被忽略  matchRecur(str, pattern, s+1, p + 2)
			       2、abc和a*abc 模式后移2字符，相当于x*被忽略；matchRecur(str, pattern, s, p + 2)
			       3、aaaabc和a*abc 字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；matchRecur(str, pattern, s+1, p)
	  */

        //用代码实现上述的逻辑流程

		/*1、当模式中的第二字符不是   * 时，那就大家都往后比呗  ，文本和模式都往后移一步。
		   abc...(文本串)
		   abc...(模式串)
		   代码：(记住，由于模式串的长度>=文本，所以只要考虑文本是否越界就行)
		  if((s<str.length&&str[s]==pattern[p])||(pattern[p]=='.'&&s<str.length)) {
			  return matchRecur(str, pattern, s+1, p+1);
		  } */
        if ((s < str.length && str[s] == pattern[p]) || (s < str.length && pattern[p] == '.')) {
            return matchRecur(str, pattern, s + 1, p + 1);
        }

		/*2、当模式中第二个字符是 * 时，这个情况就有四种情况要考虑了
		（1）例子ab和c*ab
		  第一个字符不相等，一个a一个c，且模式串第二个* 则，直接patten向后跳两个指针：
		    return matchRecur(str, pattern, s, p+2);
	     当第一个字符相等时了？就有三种情况要考虑在内了
	       1、abc和a*bc  模式后移2字符,文本后移1个，相当于*被忽略  matchRecur(str, pattern, s+1, p + 2)
	       2、abc和a*abc 模式后移2字符，相当于x*被忽略；matchRecur(str, pattern, s, p + 2)
	       3、aaaabc和a*abc 字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；matchRecur(str, pattern, s+1, p)*/

        if (p < pattern.length - 1 && pattern[p + 1] == '*') {
            if ((s < str.length && str[s] == pattern[p]) || (s < str.length && pattern[p] == '.')) {
                //下面或最后结果只有有个为真，就行，因为它必走下面三个条件
                return matchRecur(str, pattern, s + 1, p + 2) ||
                        matchRecur(str, pattern, s, p + 2) ||
                        matchRecur(str, pattern, s + 1, p);

            } else {
                return matchRecur(str, pattern, s, p + 2);

            }
        }
        return false;
    }

    /**
     * dp
     *
     * @param s
     * @param p
     * @return boolean
     * @author wanglufei
     * @date 2022/8/12 11:43 AM
     */
    public boolean match(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int m = s.length();
        int n = p.length();

        // dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初期值
        // s为空，p为空，能匹配上
        dp[0][0] = true;
        // p为空，s不为空，必为false(boolean数组默认值为false，无需处理)
        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= cp.length; j++) {
            if (cp[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 填格子
        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                // 文本串和模式串末位字符能匹配上
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') { // 模式串末位是*
                    // 模式串*的前一个字符能够跟文本串的末位匹配上
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]      // *匹配0次的情况
                                || dp[i - 1][j];     // *匹配1次或多次的情况
                    } else { // 模式串*的前一个字符不能够跟文本串的末位匹配
                        dp[i][j] = dp[i][j - 2];     // *只能匹配0次
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pa = p.toCharArray();
        return dp(str, 0, pa, 0);
    }

    private static boolean dp(char[] s, int i, char[] p, int j) {
        int m = s.length;
        int n = p.length;
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p[j + 1] != '*') {
                    return false;
                }
            }
            return true;
        }

        if (s[i] == p[j] || p[j] == '.') {
            if (j < n - 1 && p[j + 1] == '*') {
                return dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                return dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p[j + 1] == '*') {
                return dp(s, i, p, j + 2);
            } else {
                return false;
            }
        }

    }
}
