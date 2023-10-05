package com.uin.leetcode_100.array.Double_index.LeetCode_31;

/**
 * LeetCode 31 下一个排列
 *
 * @author wanglufei
 * @date 2022/7/11 10:02 AM
 */
public class NextArr {
    public static void main(String[] args) {
        int nums[] = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] solution = solution(nums);
        for (int i : solution) {
            System.out.print(i + ",");
        }
    }

    public static int[] solution(int nums[]) {
        int i = nums.length - 2;
        //nums[i]=3 nums[i+1]=1
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // nums[3]>nums[4] 4>7  false
        // 跳出循环 i=3 nums[3]=4
        if (i >= 0) {
            //j = 8
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //此时 nums[3]=4 >= nums[6]=5 false
            //二者 发生交换
            //{1,5,8,5,7,6,4,3,1}
            swap(nums, i, j);
            //.....
            //最后的数组{1,5,7,8,6,5,4,3,1} nums[i]=nums[3]=8
        }
        reverse(nums, i + 1);
        return nums;
    }

    //我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
    public static void reverse(int[] nums, int start) {
        //nums[4]=6    nums[8]=1
        int left = start, right = nums.length - 1;
        while (left < right) {//4<8
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
