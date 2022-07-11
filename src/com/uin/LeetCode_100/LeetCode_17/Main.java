package com.uin.LeetCode_100.LeetCode_17;

import java.util.*;

/**
 * LeetCode 17 电话号码的组合
 *
 * @author wanglufei
 * @date 2022/7/11 10:15 AM
 */
public class Main {
    static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        List<String> combinations = new ArrayList<String>();
        String str = "23";
        backtrack(combinations, map, str, 0, new StringBuffer());
        for (String combination : combinations) {
            String[] split = combination.split(",");
            for (String s : split) {
                System.out.print(s + ",");
            }
        }
    }

    /**
     * @param combinations 最终要返回的
     * @param phoneMap     存储电话号码的字母
     * @param str          传进来的
     * @param index        str的索引
     * @param combination  拼接的字符串
     * @author wanglufei
     * @date 2022/7/11 10:50 AM
     */
    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                                 String str, int index, StringBuffer combination) {
        if (index == str.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = str.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, str, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


    public static List<String> solution(String str, Map<Character, String> map) {
        ArrayList<String> bank = new ArrayList<>();
        if (str.equals("1")) {
            return new ArrayList<String>();
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            String s = map.get(c);
            bank.add(s);
        }
        for (int i = 0; i < bank.size(); i++) {

        }
        return bank;
    }
}
