package com.uin.kdxf.football;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[5];
        while (sc.hasNextInt()) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
        }
        String[] solution = solution(target, nums);
        for (String b : solution) {
            System.out.print(b + " ");
        }
    }

    /**
     * @param target 排名后的得分（去重）
     * @param nums
     * @return boolean[]
     */
    public static String[] solution(int target, int[] nums) {
        String[] result = new String[2];
        int totalTimes = 10;

        if (target % 3 == 0) {

        }


        //每个小组有5支球队，总场数10场 单循环
        //win+=3 lose+=0 avg+=2(各)
        // 6 5 5 5 4

        for (int i = 0; i < nums.length; i++) {
            //说明赢了两场

        }


        return result;
    }
}
