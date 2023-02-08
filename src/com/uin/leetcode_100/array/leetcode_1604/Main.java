package com.uin.leetcode_100.array.leetcode_1604;

import java.util.*;

/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告。
 * 给你字符串数组keyName和keyTime ，其中[keyName[i], keyTime[i]]对应一个人的名字和他在某一天 内使用员工卡的时间。
 * 使用时间的格式是 24小时制，形如"HH:MM"，比方说"23:51" 和"09:49"。
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序排序后返回。
 * 请注意"10:00" - "11:00"视为一个小时时间范围内，而"23:51" - "00:10"不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * 输出：["daniel"]
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * 示例 2：
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * 输出：["bob"]
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 * 示例 3：
 * <p>
 * 输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * 输出：["clare","leslie"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= keyName.length, keyTime.length <= 105
 * keyName.length == keyTime.length
 * keyTime 格式为"HH:MM"。
 * 保证[keyName[i], keyTime[i]]形成的二元对互不相同。
 * 1 <= keyName[i].length <= 10
 * keyName[i]只包含小写英文字母。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static List<String> alertNamesTest(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        // 1604. 警告一小时内使用相同员工卡大于等于三次的人
        // 每当一个员工使用一次他员工卡，安保系统会记录下员工的名字和使用时间。
        // 如果一个员工在一个小时之内食用员工卡的次数大于等于3次，系统会自动发出一个警告。
        // 其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
        // 请你返回去重后收到系统警告的员工名字，将它们按字典序升序排序后返回。
        Map<String, List<Integer>> map = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String[] tt = keyTime[i].split(":");
            // 10*60 + 0 = 600;
            // 10*60 + 40 = 640
            // 11*60 + 0 = 660;
            int val = Integer.parseInt(tt[0]) * 60 + Integer.parseInt(tt[1]);
            List<Integer> times = map.getOrDefault(keyName[i], new ArrayList<>());
            times.add(val);
            // 如果不存在相同的名字，就插入
            map.putIfAbsent(keyName[i], times);
        }

        // {"lisi",{[600],[640],[660]}}
        List<String> ans = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> time = map.get(name);
            // 3
            int size = time.size();
            if (size < 3) {
                continue;
            }

            for (int i = 0; i < size - 2; i++) {
                if (time.get(i + 2) - time.get(i) <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        // 创建一个 HashMap
//        HashMap<Integer, String> sites = new HashMap<>();
//
//        // 往 HashMap 添加一些元素
//        sites.put(1, "Google");
//        sites.put(2, "Runoob");
//        sites.put(3, "Taobao");
//        System.out.println("sites HashMap: " + sites);
//
//
//        // HashMap 不存在该key，直接插入
//        sites.putIfAbsent(4, "Weibo");
//
//        // HashMap 中存在 Key，就不插入
//        sites.putIfAbsent(2, "Wiki");
//        System.out.println("Updated Languages: " + sites);
        alertNamesTest(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"});
    }
}
