package com.uin.leetcode_100.dp.Leetcode_42;

import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class Main {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //System.out.println(solution(height));
        //System.out.println(solution2(height));
        //System.out.println(solution3(height));
        System.out.println(solution4(height));
    }

    /**
     * 暴力解法
     * 算法：
     * 1.初始化result=0；
     * 2.从左到右遍历 height
     * 2.1.初始化left_max=0,right_max=0
     * 2.2.从height[0]到当前位置寻找最大值left_max=max(left_max,height[j])
     * 2.3.从height[0]到当前位置寻找最大值right_max=max(right_max,height[j])
     * 2.4.result =result+min(left_max,right_max)
     * 3.返回result
     * 时间复杂度：O(n^2) 空间复杂度：O(1)
     *
     * @param height
     * @return int
     * @author wanglufei
     * @date 2022/7/15 8:08 PM
     */
    public static int solution(int[] height) {
        int result = 0;
        //边界条件
        int length = height.length;
        if (length == 0) return 0;

        for (int i = 1; i < length; i++) {
            int left_max = 0;
            int right_max = 0;
            for (int j = i; j < length; j++) right_max = Math.max(right_max, height[j]);
            for (int j = i; j >= 0; j--) left_max = Math.max(left_max, height[j]);
            result += Math.min(left_max, right_max) - height[i];
        }
        return result;
    }

    /**
     * 动态规划
     * <p>
     * 1.提前存储每个位置上所有左边柱子高度的最大值和所有右边柱子高度的最大值(注意是柱子的最大值 )
     *
     * @param height
     * @return int
     * @author wanglufei
     * @date 2022/7/15 11:18 PM
     */
    public static int solution2(int[] height) {
        //初始化常量
        int length = height.length;
        int result = 0;
        if (length < 3) return 0;
        //初始化动态规划数组（类似于备忘录）
        int[] left_max_arr = new int[length];
        int[] right_max_arr = new int[length];
        left_max_arr[0] = height[0];
        right_max_arr[length - 1] = height[length - 1];
        // 计算动态规划数组
        for (int i = 1; i < length; i++) {
            left_max_arr[i] = Math.max(left_max_arr[i - 1], height[i]);
        }
        for (int i = length - 2; i >= 0; i--) {
            right_max_arr[i] = Math.max(right_max_arr[i + 1], height[i]);
        }
        //计算返回result
        for (int i = 0; i < length; i++) {
            result += Math.min(left_max_arr[i], right_max_arr[i]) - height[i];
        }
        return result;
    }

    /**
     * 栈
     * <p>
     * 积水只可能处于低洼处形成，当后面的柱子高度比前面低的时候，是无法存储水的。
     * 所以使用单调递减栈存储可能储水的柱子，当找到一根比前面高的柱子，就可以计算接到的雨水
     * <p>
     * 从左到右遍历数组，遍历到下标i时，如果栈内至少有两个元素，记栈顶元素为top，top的下面一个元素是left，则一定有height[left]>=height[top]
     *
     * @param height
     * @return int
     * @author wanglufei
     * @date 2022/7/15 11:34 PM
     */
    public static int solution3(int[] height) {
        int result = 0;
        int i = 0;
        //使用栈来存储数组的索引下标
        Stack<Integer> stack = new Stack<>();
        while (i < height.length) {
            //查看此堆栈顶部的对象而不将其从堆栈中移除。
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //移除此堆栈顶部的对象并将该对象作为此函数的值返回。
                int top = stack.pop();
                if (!stack.isEmpty()) break;
                //积水宽度为当前元素(积水右界)与现在栈顶元素的距离（积水左界）
                int distance = i - stack.pop() - 1;
                //积水高度为当前元素与现在栈顶元素的高度的较小值减去top的高度
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                result += distance * bounded_height;
            }
            //将i放到栈顶
            stack.push(i++);
        }
        return result;
    }

    /**
     * 双指针
     * <p>
     * 只要left_max_arr[i]>right_max_arr[i]，积水的高度将有right_max_arr决定，
     * 同理如果right_max_arr[i]>left_max_arr[i]。积水的高度将由left_max_arr决定。
     * <p>
     * 所以我们可以认为如果一端有更高的条形状（例如右端），积水的高度依赖当前方向的高度（从左到右）。
     * 当我们发现另一侧（右侧）的条形块的高度不是最高的，我们则开始从相反的方向遍历（从右到左）
     *
     * @param height
     * @return int
     * @author wanglufei
     * @date 2022/7/16 10:53 AM
     */
    public static int solution4(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0, ans = 0;
        while (left < right) {
            //
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    result += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    result += right_max - height[right];
                }
                right--;
            }
        }
        return result;
    }
}
