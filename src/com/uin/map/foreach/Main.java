package com.uin.map.foreach;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);

        /**
         * 第一种：普遍使用，二次取值
         */
        System.out.println("通过Map.keySet遍历key和value：");
        for (String s : map.keySet()) {
            System.out.println(s + "===" + map.get(s));
        }
        /**
         * 第二种
         */
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        /**
         * 推荐，尤其是容量大时
         */
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        /**
         * 第四种
         */
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (Integer v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}
