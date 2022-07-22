package com;

import java.util.*;

public class test {
    public static void main(String[] args) {
        List<String> pathList = Arrays.asList(
                "/etc/hosts",
                "/etc/kubernetes/ssl/certs",
                "/root"
        );
        System.out.println("bank:" + pathListToMap(pathList));
    }

    private static Map<String, Map> pathListToMap(List<String> data) {
        //套娃
        int nums = 0;
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String[] strings = data.get(i).split("/");
            List<String> list1 = new ArrayList<>();
            for (int j = 0; j < strings.length; j++) {
                list1.add(strings[j]);
            }
            list1.remove(0);
            if (list1.size() > nums) {
                nums = list1.size();
            }
            lists.add(list1);
        }
        System.out.println(lists);

        Map<String, Map> map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            Map<String, Map> map1 = new HashMap<>();
            map1 = map;
            Map<String, Map> map2 = map1;
            for (int j = 0; j < lists.get(i).size(); j++) {
                Map<String, Map> map3 = new HashMap<>();
                if (!map1.containsKey(lists.get(i).get(j))) {
                    map1.put(lists.get(i).get(j), map3);
                }
                map1 = map1.get(lists.get(i).get(j));
            }
            map = map2;
        }
        return map;
    }
}
