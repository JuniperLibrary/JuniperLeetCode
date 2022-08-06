package com.uin.nwxy.hashmap;

import java.util.HashMap;

/**
 * 在不使用算术运算符或比较运算符的情况，检查两个数字相等
 *
 * @author wanglufei
 */
public class Main {
    public boolean isequal(int a, int b) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        hashMap.put(a, true);
        return hashMap.containsKey(b);
    }
}
