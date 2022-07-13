package com.uin.LeetCode_100.LeetCode_22;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        List<String> solution = solution(n);
        for (String s : solution) {
            System.out.print(s + ",");
        }
    }

    public static List<String> solution(int n) {
        dfs(n, n, "");
        return result;
    }

    public static void dfs(int left, int right, String str) {

        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0)
            dfs(left - 1, right, str + "(");

        if (left < right)
            dfs(left, right - 1, str + ")");
    }
}
