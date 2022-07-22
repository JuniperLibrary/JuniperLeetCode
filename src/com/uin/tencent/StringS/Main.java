package com.uin.tencent.StringS;

/**
 * 小红的二进制删数字
 *
 * @author wanglufei
 * @date 2022/7/21 5:52 下午
 */
public class Main {
    public static void main(String[] args) {
        String s = "1010";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        //创建数组 将字符串s右边等于1的个数
        int len = s.length();
        int[] rightOneCount = new int[len];
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            rightOneCount[i] = count;
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        int index = 0;
        int minCount = len;
        while (index < len) {
            if (s.charAt(index) != '1') {
                index++;
            } else {//找到左端的1 开始更新最小操作数
                minCount = Math.min(minCount, index + rightOneCount[index]);
            }
            index++;
        }
        return minCount;
    }
}
