package main.java.com.uin.weekendAC.weenkend_327.leetcode_6283;

/**
 * 6283. 正整数和负整数的最大计数
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 *
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public int maximumCount(int[] nums) {
        int pos =0,neg=0;
        for(int num : nums){
            if(num > 0){
                pos++;
            }else if(num <0){
                neg++;
            }
        }
        return Math.max(pos,neg);
    }
}
