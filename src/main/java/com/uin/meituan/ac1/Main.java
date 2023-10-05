package main.java.com.uin.meituan.ac1;

/**
 * 求数列的和
 *
 * @author wanglufei
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double n = scanner.nextDouble();
            double m = scanner.nextDouble();
            double sum = 0;
            for (int i = 0; i < m; i++) {
                sum += n;
                n = Math.pow(n, 0.5);
            }
            System.out.printf("%.2f", sum);
        }

    }
}
