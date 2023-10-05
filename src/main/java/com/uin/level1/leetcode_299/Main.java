package com.uin.level1.leetcode_299;

/**
 * 299. 猜数字游戏
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * <p>
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字secret 和朋友猜测的数字guess ，请你返回对朋友这次猜测的提示。
 * <p>
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B表示奶牛。
 * <p>
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 * ————————————————————————————————————————————
 * 输入：secret = "1807", guess = "7810"
 * 输出："1A3B"
 */
public class Main {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] sntG = new int[10];

        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                bulls++;
            } else {
                cntS[s[i] - '0']++;
                sntG[g[i] - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(cntS[i], sntG[i]);
        }

        return Integer.toString(bulls)+'A'+Integer.toString(cows)+'B';
    }
}
