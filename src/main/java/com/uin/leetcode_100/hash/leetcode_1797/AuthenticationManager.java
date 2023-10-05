package com.uin.leetcode_100.hash.leetcode_1797;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticationManager {
    // 1797. 设计一个验证系统
    // 包含验证码的功能
    // 每一次验证，用户都会收到一个新的验证码，这个验证码在currentTime时刻之后timeToLive秒过期
    // 如果验证码被更新了，那么它会在新的currentTime（可能与之前的currentTime不同）时刻延长至timeToLive秒。

    // 这一题要考虑利用currentTime严格单调增的性质。因为每一次的时间都肯定比上一次调用的时间大，所以直接调用顺序表存储记录就可以保证有序性，不必使用优先队列等数据结构
    // 懒更新
    // 即对于一个tokenId，不是在它过期的那一时刻进行删除操作，而是把这一操作延迟到统计未过期的验证码时再操作。
    // 统计为过期的验证码时，鼻案例记录列表中已过期的记录，如果当前记录的tokenId在map中所存的最后一次更新时间和当前记录的时间相同，则说明这一个tokenId已经过时，应该从map删除

    private int timeToLive;
    // 存储tokenId的最后一次更新的时间
    private final Map<String, Integer> map = new HashMap<>();
    List<String> idList = new ArrayList<>();
    List<Integer> timeList = new ArrayList<>();
    // 表示上一次查询未过时验证码时，第一个未过时的验证码在列表中的索引
    int start = 0;

    /**
     * 构造函数
     */
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    // 给定tokenId和当前时间，生成一个新的验证码
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
        idList.add(tokenId);
        timeList.add(currentTime);
    }

    // 给定tokenId且未过期的验证码在currentTime更新。
    // 如果给定的tokenId不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            // 若该tokenId存在且过时，则更新map并给列表添加记录
            if (map.get(tokenId) > currentTime - timeToLive) {
                map.put(tokenId, currentTime);
                idList.add(tokenId);
                timeList.add(currentTime);
            }
        }
    }

    // 请返回在给定当前时间 未过期的验证码数目
    public int countUnexpiredTokens(int currentTime) {
        int n = idList.size();
        int i = start;
        for (; i < n; i++) {
            String id = idList.get(i);
            Integer time = timeList.get(i);
            // 遇到没超时的记录就停止遍历
            if (time > currentTime - timeToLive) {
                break;
            }
            // 如果这一tokenId的最后一次更新时间和该次记录的时间相同，则说明这一tokenId已经过时
            if (map.get(id).equals(time)) {
                map.remove(id);
            }
        }
        // 因为下次时间肯定不早于这次的时间，所以下一次查询从start开始即可
        start = i;
        return map.size();
    }
}
