package main.java.com.uin.leetcode_100.slidingwindow.leetcode_1652;

/**
 * 1652. 拆炸弹
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及一个密钥k。
 * <p>
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 * <p>
 * 如果k > 0，将第i个数字用 接下来k个数字之和替换。
 * 如果k < 0，将第i个数字用 之前k个数字之和替换。
 * 如果k == 0，将第i个数字用0替换。
 * 由于code是循环的，code[n-1]下一个元素是code[0]，且code[0]前一个元素是code[n-1]。
 * <p>
 * 给你 循环数组code和整数密钥k，请你返回解密后的结果来拆除炸弹！
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/defuse-the-bomb
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    /**
     * 前缀和
     *
     * @param code
     * @param k
     * @return int[]
     * @author wanglufei
     * @date 2022/9/24 12:54 AM
     */
    public int[] decrypt(int[] code, int k) {
        int ans[] = new int[code.length];
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                for (int j = 1; j <= k; j++) {
                    ans[i] += code[(i + j) % code.length];
                }
            }
        } else if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                for (int j = k; j < 0; j++) {
                    ans[i] += code[(i + j + code.length) % code.length];
                }
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     *
     * @param code
     * @param k
     * @return int[]
     * @author wanglufei
     * @date 2022/9/24 12:54 AM
     */
    public int[] helper(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        int[] newCode = new int[n * 2];
        /**
         * src - 源数组。
         * srcPos – 源数组中的起始位置。
         * dest - 目标数组。
         * destPos – 目标数据中的起始位置。
         * length – 要复制的数组元素的数量
         */
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }
        return res;
    }
}
