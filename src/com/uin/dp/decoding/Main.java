package com.uin.dp.decoding;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * A:1
 * B:2
 * ....
 *
 * @author wanglufei
 * @return : 请计算并返回 解码 方法的 总数 。
 * @date 2022/6/4 5:38 PM
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 12可能的解码的情况：
         * 1：A
         * 2：B
         * 或者
         * 12 ：L
         */
        String s = "12305";

        int solution = solution(s.toCharArray(), s.length(), 0);
        System.out.println(solution);
    }

    //我们把它看做遍历一颗二叉树，index表示访问字符的位置
    //左边拿一个 右边拿两个
    //拿到之后和26比较
    //如果遇到05这种情况，就找不到对应的解码，0只能和前面的拆

    public static int solution(char[] chars, int length, int index) {
        //递归的终止条件，到叶子节点。
        if (index >= length) {
            return 1;
        }
        //单个0是不能构成字符的，要跳过，但两个数字的比如10，20是可以构成字符的，
        // 两个数字的在上一步就已经截取了。
        if (chars[index] == '0') {
            return 0;
        }
        //上面类似于二叉树遍历终止条件的判断，下面类似于遍历二叉树的两个分支
        //截取一个数字的分支(类似于二叉树的左分支)
        int res = solution(chars, length, index + 1);

        //截取两个数字的分支(类似于二叉树的右分支)，截取两个数字
        //必须要小于等于26，所以这个需要判断一下
        if (index < length - 1 && (chars[index] == '1' || (chars[index] == '2' && chars[index + 1] <= '6'))) {
            res += solution(chars, length, index + 2);
        }
        return res;
    }
}
