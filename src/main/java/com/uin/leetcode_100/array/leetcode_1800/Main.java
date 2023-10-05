package main.java.com.uin.leetcode_100.array.leetcode_1800;

/**
 * 1800. 最大升序子数组和
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        int ans =0 ,sum =0,n =nums.length;

        for(int i =0;i<n;i++){
            if(i==0 || nums[i]>nums[i-1]){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
