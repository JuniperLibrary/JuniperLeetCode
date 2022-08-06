package com.uin.meituan.ac1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sxh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            List<Integer> lt = new ArrayList<>();
            for(int i=m;i<=n;i++){
                int a = i%10;
                int b = (i-a)/10%10;
                int c = (i-a-10*b)/100%10;
                if(i == a*a*a+b*b*b+c*c*c){
                    lt.add(i);
                }
            }
            if(lt.size() == 0){
                System.out.println("no");
            }else{
                for(int i=0;i<lt.size();i++){
                    System.out.print(lt.get(i));
                    if(i != lt.size()-1){
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}
