package com.double_weekend.weenkend_95.leetcode_2526;

/**
 * 2526. 找到数据流中的连续整数
 * 给你一个整数数据流，请你实现一个数据结构，检查数据流中最后k个整数是否 等于 给定值value。
 * <p>
 * 请你实现DataStream类：
 * <p>
 * DataStream(int value, int k)用两个整数 value和 k初始化一个空的整数数据流。
 * boolean consec(int num)将num添加到整数数据流。如果后 k个整数都等于value，返回true，否则返回false。如果少于k个整数，条件不满足，所以也返回false。
 * <p>
 * 输入：
 * ["DataStream", "consec", "consec", "consec", "consec"]
 * [[4, 3], [4], [4], [4], [3]]
 * 输出：
 * [null, false, false, true, false]
 * <p>
 * 解释：
 * DataStream dataStream = new DataStream(4, 3); // value = 4, k = 3
 * dataStream.consec(4); // 数据流中只有 1 个整数，所以返回 False 。
 * dataStream.consec(4); // 数据流中只有 2 个整数
 * // 由于 2 小于 k ，返回 False 。
 * dataStream.consec(4); // 数据流最后 3 个整数都等于 value， 所以返回 True 。
 * dataStream.consec(3); // 最后 k 个整数分别是 [4,4,3] 。
 * // 由于 3 不等于 value ，返回 False 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-consecutive-integers-from-a-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DataStream {
    int target = 0, k = 0, count = 0;

    public DataStream(int value, int k) {
        this.target = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if (num == target) {
            count++;
        } else {
            count = 0;
        }

        if (count >= k) {
            return true;
        }
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */


