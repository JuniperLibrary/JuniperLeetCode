package main.java.com.uin.souhu20.a2;

import java.util.concurrent.Semaphore;

/**
 * 搜狐畅游2020校招笔试 - JAVA开发工程师--多线程打印
 * 创建两个线程，其中一个输出1-52，另外一个输出A-Z。输出格式要求：12A 34B 56C 78D ...
 * <p>
 * 输入描述:
 * 1、线程1打印1-52的数字
 * <p>
 * 2、线程2打印26个字母
 * <p>
 * 输出描述:
 * 每打印两个数字后打印一个字母，直到最终所有数字和字母都打印完成
 */
public class Main {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);
        new Thread(new Runnable() {
            // @Override // 可省略
            public void run() { // public不能少，权限修饰符不能变小
                for (int i = 1; i <= 52; i++) {
                    if ((i & 1) == 1) { // 奇数
                        try {
                            semaphore.acquire(); // 初始值为1，只有首次获取不被阻塞
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i);
                    if ((i & 1) == 0) { // 偶数才发打印字母的信号
                        semaphore2.release();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char i = 'A'; i <= 'Z'; i++) {
                    try {
                        semaphore2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(i + " ");
                    semaphore.release();
                }
            }
        }).start();
    }
}
