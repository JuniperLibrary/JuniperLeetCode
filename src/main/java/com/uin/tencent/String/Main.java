package main.java.com.uin.tencent.String;

/**
 * 小红的二进制删数字
 * <p>
 * 小红拿到了一个二进制字符串 s，她可以删掉其中的一些字符，使得最终该字符串为一个2的幂（即可以表示为  形式的数）。
 * 小红想知道，自己最少删几个字符可以达成？请你编写一个函数返回这个答案。
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
