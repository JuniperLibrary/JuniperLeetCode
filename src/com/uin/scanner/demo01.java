package com.uin.scanner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        test4();
    }

    /**
     * 测试案例：
     * 5
     * 1 2 3 4 5
     */
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 测试案例： 输入一个不定长度的数组
     * 1 2 3 4 5 . . .
     */
    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String s = scanner.nextLine();
        String[] split = s.split("\\s+");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 测试案例： 输入n*m的数组
     * 3 4
     * 1 2 3 4
     * 2 2 3 4
     * 3 3 3 4
     */
    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        for (int[] num : nums) {
            System.out.printf(Arrays.toString(num));
        }
    }

    /**
     * 测试案例： 输入不定长度的 二维数组 ( 这里在元素输入结束后需要再一个回车结束 )
     * 1 2 3 4
     * 2 2 3 4
     * 3 2 3 4
     * 4 2 3 4
     */
    public static void test4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        List<int[]> nums = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if ("".equals(s)) break;
            String[] split = s.split("\\s+");
            int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            nums.add(ints);
        }
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    /**
     * 测试案例： TODO ???
     * 2      //代表测试数据的组数
     * 3 3 0 0
     * 3 3 3 3
     */
    public static void test5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        int n = scanner.nextInt();

        List<int[]> nums = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if ("".equals(s)) break;
            String[] split = s.split("\\s+");
            int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            nums.add(ints);
        }

//        while (scanner.hasNextLine()) {
//            List<Integer> integers = new ArrayList<>();
//            integers.add(scanner.nextInt());
//            integers.add(scanner.nextInt());
//            integers.add(scanner.nextInt());
//            integers.add(scanner.nextInt());
//            nums.add(new ArrayList(integers));
//        }

        System.out.println(n);
        System.out.println(nums);
    }

}
