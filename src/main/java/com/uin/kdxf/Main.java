package main.java.com.uin.kdxf;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final long PI = (long) 3.1415927;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<Double> nums = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" ");
            for (String s : split) {
                nums.add((double) Integer.parseInt(s));
            }
        }
        List<Double> item = solution(N, nums);
        for (Double d : item) {
            System.out.print(((int) Math.abs(d))+" ");
        }

    }

    public static List<Double> solution(int N, List<Double> xn) {
        List<Double> yn = new ArrayList<>();

        for (Double item : xn) {
            double hanWin = HanWin(item, N);
            yn.add(item * hanWin);
        }
        return yn;
    }

    public static double HanWin(double item, int N) {
        return 0.5f * (1f - Math.cos(2f * PI * item / N));
    }
}
