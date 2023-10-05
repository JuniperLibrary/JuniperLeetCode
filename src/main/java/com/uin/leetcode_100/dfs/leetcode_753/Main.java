package com.uin.leetcode_100.dfs.leetcode_753;

import java.util.HashMap;
import java.util.Map;

/**
 * 753. 破解保险箱
 * 有一个需要密码才能打开的保险箱。密码是n 位数, 密码的每一位是k位序列0, 1, ..., k-1中的一个 。
 * <p>
 * 你可以随意输入密码，保险箱会自动记住最后n位输入，如果匹配，则能够打开保险箱。
 * <p>
 * 举个例子，假设密码是"345"，你可以输入"012345"来打开它，只是你输入了 6个字符.
 * <p>
 * 请返回一个能打开保险箱的最短字符串。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 1, k = 2
 * 输出: "01"
 * 说明: "10"也可以打开保险箱。
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: "00110"
 * 说明: "01100", "10011", "11001" 也能打开保险箱。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n 的范围是[1, 4]。
 * k 的范围是[1, 10]。
 * k^n 最大可能为4096。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cracking-the-safe
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public String crackSafe(int n, int k) {
        // n =2 k =2
        // 密码是 n 位数
        // 密码是 k-1 位序列中的一个

        Map<String, Integer> map = new HashMap<>();
        //路径数量
        int kn = (int) Math.pow(k, n);
        // //结点数量
        int kn_1 = (int) Math.pow(k, n - 1);
        StringBuffer ans = new StringBuffer();
        //初始结点为000...
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        if (ans.length() == 0) {
            for (int i = 0; i < k; i++) {
                ans.append(i);
            }
            return ans.toString();
        }


        //遍历所有的路
        while (kn != 0) {
            String substring = ans.substring(ans.length() - n + 1, ans.length());
            if (!map.containsKey(substring)) {
                map.put(substring, k - 1);
            }
            ans.append(map.get(substring));
            map.put(substring, map.get(substring) - 1);
            kn--;
        }
        return ans.toString();
    }
}
