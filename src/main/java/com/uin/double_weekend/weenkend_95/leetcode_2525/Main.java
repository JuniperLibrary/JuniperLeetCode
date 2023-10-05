package com.uin.double_weekend.weenkend_95.leetcode_2525;

/**
 * 2525. 根据规则将箱子分类
 */
public class Main {
    public String categorizeBox(int length, int width, int height, int mass) {
        // mass 质量
        // 返回箱子类别的字符串

        int mod = 10000;
        int v = 1000000000;

        // Bulky
        // - 至少有一个维度 >= 10000
        // - 体积 >= 1000000000

        // Heavy
        // - mass >= 100

        // Both
        // - Heavy && Bulky

        // Neither
        // - !Bulky && !Heavy

        // Heavy
        // - Heavy && !Bulky

        boolean B = false;
        boolean H = false;
        if (length >= 10000 || width >= 10000 || height >= 10000 || (long) length * width * height >= (int) (1e9)) {
            B = true;
        }
        if (mass >= 100) {
            H = true;
        }
        if (B == true && H == true) {
            return "Both";
        } else if (B == false && H == false) {
            return "Neither";
        } else if (B == true && H == false) {
            return "Bulky";
        }
        return "Heavy";
    }
}
