package main.java.com.uin.tencent.TencentMusic.a4;

import java.util.HashMap;

/**
 * 腾讯音乐娱乐集团2022暑期实习生招聘技术类岗位编程题合集--出现至少k次的小写字母
 * 给定一个由小写字母组成的字符串 s，求有多少小写字母出现了至少 k 次。
 * "aaabcd",2
 * 1
 */
public class Main {
    public int howMany(String S, int k) {
        // write code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for (Character ch : map.keySet()) {
            if (map.get(ch) >= k) {
                ans++;
            }
        }
        return ans;
    }
}
