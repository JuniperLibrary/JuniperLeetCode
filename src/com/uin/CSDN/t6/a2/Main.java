package com.uin.CSDN.t6.a2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 鬼画符门
 * 鬼画符门，每年都会统计自己宗门鬼画符消耗的数量，往年一直是大师兄管理，
 * 但是这次鬼艺接手了， 你能帮鬼艺写一个 程序统计每年消耗数量最多的鬼画符吗？
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("red");
        list.add("green");
        list.add("green");
        list.add("hen");
        System.out.println(helper(list));
    }

    public static String helper(ArrayList<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);

            if (map.get(s) > 0) {
                return s;
            }
        }
        return "";
    }
}
