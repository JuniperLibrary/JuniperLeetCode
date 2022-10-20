package com.uin.leetcode_100.weisolution.leetcode_779;


/**
 * 779. 第K个语法符号
 * 我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）
 * 示例 1:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * @param n
     * @param k
     * @return 返回第 n 行中第 k个字符。（k从索引 1 开始）
     */
    public static int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }

        // << 左移运算符 *
        if (k > (1 << (n - 2))) {
            // ^ 异或运算
            // 1^1=0
            // 1^0=1
            // 0l^0=0
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }
}
