package com.uin.leetcode_100.string.leetcode_1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1807. 替换字符串中的括号内容
 * <p>
 * 给你一个字符串s，它包含一些括号对，每个括号中包含一个 非空的键。
 * <p>
 * 比方说，字符串"(name)is(age)yearsold"中，有两个括号对，分别包含键"name" 和"age"。
 * 你知道许多键对应的值，这些关系由二维字符串数组knowledge表示，其中knowledge[i] = [keyi, valuei]，
 * 表示键keyi对应的值为valuei。
 * <p>
 * 你需要替换 所有的括号对。当你替换一个括号对，且它包含的键为keyi时，你需要：
 * <p>
 * 将keyi和括号用对应的值valuei替换。
 * 如果从 knowledge中无法得知某个键对应的值，你需要将keyi和括号用问号"?"替换（不需要引号）。
 * knowledge中每个键最多只会出现一次。s中不会有嵌套的括号。
 * <p>
 * 请你返回替换 所有括号对后的结果字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public String evaluate(String s, List<List<String>> knowledge) {
        // 给你一个字符串 括号对 非空的键
        // (name)is(age)yearsold
        // [["name","bob"],["age","two"]]

        HashMap<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            StringBuilder ans = new StringBuilder();
            // 在字符串中找到key
            // key的特点 开头是左括号 结尾是右括号 只要中间的字符
            if (chars[i] == '(') {
                while (chars[++i] != ')') {
                    ans.append(chars[i]);
                }
                // 移除掉括号 并 字符串替换
                // 不存在就用 ？替换
                sb.append(map.getOrDefault(ans.toString(), "?"));
            } else {
                // 正常append
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public String solution(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<String, String>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }

        // 控制是否append字符
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
