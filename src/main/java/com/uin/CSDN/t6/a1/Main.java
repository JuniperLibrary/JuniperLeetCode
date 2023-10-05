package com.uin.CSDN.t6.a1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * X国最近开始严管枪火。 像是“ak”,“m4a1”,“skr”。都是明令禁止的。
 * 现在小Q查获了一批违禁物品其中部分是枪支。 小Q想知道自己需要按照私藏枪火来关押多少人。 （只有以上三种枪被视为违法）
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("wewe");
        list.add("ak");
        list.add("we");

        System.out.println(helper(list));
    }

    public static int helper(ArrayList<String> list) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("ak", 0);
        map.put("m416", 0);
        map.put("skr", 0);
        int count = 0;
        for (String s : list) {
            if (map.containsKey(s)) {
                count++;
            }
        }
        return count;
    }
}
