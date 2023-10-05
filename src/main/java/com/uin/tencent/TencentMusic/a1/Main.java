package com.uin.tencent.TencentMusic.a1;

/**
 * 腾讯音乐娱乐集团2022暑期实习生招聘技术类岗位编程--小红的二进制删数字
 * 小红拿到了一个二进制字符串 s，她可以删掉其中的一些字符，使得最终该字符串为一个2的幂（即可以表示为 2^k 形式的数）。小红想知道，自己最少删几个字符可以达成？请你编写一个函数返回这个答案。
 * <p>
 * "1010"
 * 1
 * <p>
 * 删掉第三个字符 '1'，字符串变成"100"，代表的数是 4=2^2
 */
public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return int整型
     */
    public int minCnt(String s) {
        // write code here
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res - 1;
    }
}
