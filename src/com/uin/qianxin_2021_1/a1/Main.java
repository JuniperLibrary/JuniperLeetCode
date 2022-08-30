package com.uin.qianxin_2021_1.a1;

import java.util.Arrays;

/**
 * 【2021】奇安信春招Java方向试卷1 - 参会的策略
 * 公司给了老杜去“北京网络安全大会”学习的机会，主办方在国家会议中心一天中安排了几十个分会场在同时举行各种主题会议，会场人声鼎沸。
 * 老杜的策略是：参加尽可能多的会议，于是老杜拿到了当天所有会议的日程表，表上是每个会议的开始结束时间段[starttime,endtime]，假设时间都为整数，请问老杜这天最多能参加几个会议？
 * 输入例子1:
 * [[8,9],[9,10],[9,12],[14,16],[15,16]]
 * 输出例子1:
 * 3
 */
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{8, 9}, {9, 10}, {9, 12}, {14, 16}, {15, 16}};
        System.out.println(helper(nums));
    }

    //50%
    public static int AttendMeetings(int[][] times) {
        // write code here
        if (times.length < 2) {
            return times.length;
        }

        int ans = 1, t = times[0][1];
        for (int i = 1; i < times.length; i++) {
            if (times[i][0] >= t) {
                t = times[i][1];
                ans++;
            }
        }
        return ans;
    }

    //贪心--先按照会议的结束时间排序，然后遍历会议数组，每次选择能参加的会议。
    public static int helper(int[][] times) {
        Arrays.sort(times, (a, b) -> a[1] - b[1]);
        int count = 0, end = 0;
        for (int i = 0; i < times.length; i++) {
            if (end <= times[i][0]) {
                count++;
                end = times[i][1];
            }
        }
        return count;
    }
}
