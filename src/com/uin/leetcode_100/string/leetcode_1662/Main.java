package com.uin.leetcode_100.string.leetcode_1662;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 1662. 检查两个字符串数组是否相等
 */
public class Main {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }

    private Object join(String[] word1) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : word1) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
