package main.java.com.uin.leetcode_100.math.leetcode_2180;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 * <p>
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4
 * 输出：2
 * 解释：
 * 只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
 * 示例 2：
 * <p>
 * 输入：num = 30
 * 输出：14
 * 解释：
 * 只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是：
 * 2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-integers-with-even-digit-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(countEven(4));
    }
    public static int countEven(int num) {
        // 1 2 3 4
        // 1 2 3 4
        /**
         *
         */
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            // 正整数的各位数字之和 是其 所有位上的对应数字相加的结果
            int x = i, sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
