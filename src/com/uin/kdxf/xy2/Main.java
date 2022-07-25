package com.uin.kdxf.xy2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<Long> nums = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" ");
            for (String s : split) {
                nums.add((long) Integer.parseInt(s));
            }
        }
    }

    public static Long solution(int N, List<Long> nums) {
        if (nums == null || nums.size() == 0) return 0L;
        int index = 0;
        Long[] a = new Long[2];
        Long[] b = new Long[2];
        Long[] c = new Long[2];
        for (int i = index; i < nums.size(); i++) {
            long start = nums.get(index);
            long end = 0L;
            for (int j = index; j < nums.size() - index; j++) {
                end = nums.get(index);
            }
            for (int i1 = 0; i1 < a.length; i1++) {
                a[i1] = start;
                a[i1++] = end;
            }
        }

        return 0l;
    }

    public static boolean gouGu(Long[] a, Long[] b, Long[] c) {
//        long a_len = Math.
        return true;
    }

}
