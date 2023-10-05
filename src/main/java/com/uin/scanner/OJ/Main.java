package main.java.com.uin.scanner.OJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            ArrayList<String> list = new ArrayList<>();
            String[] split = sc.nextLine().split(" ");
            for (String s : split) {
                list.add(s);
            }
            Collections.sort(list);
            int a = 0;
            for (String s : list) {
                if (a != 0) {
                    System.out.print(",");
                }
                a++;
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
