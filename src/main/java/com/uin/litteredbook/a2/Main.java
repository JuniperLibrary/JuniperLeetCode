package com.uin.litteredbook.a2;

import java.util.*;

/**
 * 字符串倒序
 * 薯队长带着小红薯参加密室逃脱团建游戏，首先遇到了反转游戏，小红薯们根据游戏提示收集了多个单词线索，
 * 并将单词按要求加一个空格组 成了句子，最终要求把句子按单词反转解密。
 * 说明：收集的时候单词前后可能会有多个空格，反转后单词不能有多个空格，具体见输入输出样例。
 * <p>
 * 输入一个字符串。包含空格和可见字符。长度<=100000。
 * 输出一个字符串，表示反转后结果。
 * <p>
 * the	sky	is
 * blue!
 * blue! is sky the
 */
public class Main {
    /**
     * public static void Main(String[] args) {
     * Scanner in = new Scanner(System.in);
     * while (in.hasNext()) {
     * String s = in.nextLine();
     * Stack<Character> stack = new Stack<>();
     * String result = "";
     * <p>
     * //先处理头部和尾部
     * int n = s.length();
     * boolean last = false;
     * if (s.charAt(0) == ' ') {
     * result += ' ';
     * }
     * if (n - 1 != 0 && s.charAt(n - 1) == ' ') {
     * last = true;
     * }
     * s = s.trim();
     * <p>
     * boolean flag = false;
     * for (int i = 0; i < s.length(); i++) {
     * if (s.charAt(i) != ' ') {
     * stack.push(s.charAt(i));
     * if (flag == true) {
     * flag = false;
     * } else if (s.charAt(i) == ' ' && flag == false) {
     * flag = true;
     * while (!stack.isEmpty()) {
     * result += stack.pop();
     * }
     * result +=" ";
     * } else {
     * continue;
     * }
     * <p>
     * }
     * }
     * while (!stack.isEmpty()) {
     * result += stack.pop();
     * }
     * if (last == true) {
     * result += " ";
     * }
     * System.out.println(result);
     * }
     * }
     */

//    public static void Main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        /**
//         * "\\s" 表示按照空格、换行、回车等进行切割
//         * "\\s+" 中的"+"表示一个或多个的意思
//         */
//        List<String> list = Arrays.asList(str.split("\\s+"));
//        Collections.reverse(list);
//        String res = String.join("", list);
//        System.out.println(res);
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();
        while (in.hasNext()) {
            stack.push(in.next());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
