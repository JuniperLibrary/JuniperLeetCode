package main.java.com.uin.leetcode_100.array.leetcode_287;

/**
 * @author wanglufei
 */
public class Main {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow==fast){
                break;
            }
        }
        fast=0;
        while (true){
            slow=nums[slow];
            fast=nums[fast];
            if (slow==fast){
                break;
            }
        }
        return slow;
    }
}
