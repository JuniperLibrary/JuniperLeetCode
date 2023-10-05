package main.java.com.uin.leetcode_100.dp.leetcode_801;

import java.util.Arrays;

/**
 * 801.使序列递增的最小交换次数
 * 我们有两个长度相等且不为空的整形数组nums1和nums2。再一次操作中，我们可以交换nums[i]h和nums2[i]
 * 的元素。
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增所需操作的最小次数 。
 * <p>
 * 数组arr严格递增 且arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minSwap(int[] nums1, int[] nums2) {
        //表示上一位交换和不交换的时候的最小次数
        int ans1 = 0, ans2 = 1, inf = (int) 2e5;

        for (int i = 1; i < nums1.length; i++) {
            boolean a = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1], b = nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1];
            int ans3 = Math.min(a ? ans1 : inf, b ? ans2 : inf), ans4 = Math.min(b ? ans1 : inf, a ? ans2 : inf) + 1;
            ans1 = ans3;
            ans2 = ans4;
        }
        return Math.min(ans1, ans2);
    }

    public int dpHelper(int[] nums1, int[] nums2){
        int len = nums1.length;
        int[][] dp =new int[2][len];
        for(int inner[] : dp){
            Arrays.fill(inner,Integer.MAX_VALUE);
        }

        dp[0][0]=0;
        dp[1][0]=1;

        for(int i =1;i<nums1.length;i++){
            if(nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]){
                dp[0][i]=Math.min(dp[0][i],dp[0][i-1]);
                dp[1][i]=Math.min(dp[1][i],dp[1][i-1]+1);
            }
            if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                dp[0][i]=Math.min(dp[0][i],dp[1][i-1]);
                dp[1][i]=Math.min(dp[1][i],dp[0][i-1]+1);
            }
        }
        return Math.min(dp[0][len-1],dp[1][len-1]);
    }
}
