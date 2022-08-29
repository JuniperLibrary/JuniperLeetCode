package com.uin.tuhu21.b2;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 途虎养车2021秋招Java笔试试卷B-永远有多远
 * XX是途虎养车的一名技术人员，同时也是校招的形象大使，由于忙于直播荒废了项目进度。
 * 他想写一个程序来计算项目进度，请你帮他写一个函数，计算两个日期间，还有多少个工作日可供工作。
 * <p>
 * 2020,9,25,2020,9,28
 * 1
 * 从2020年9月25日00:00 到 2020年9月28日 00:00，只有一个工作日，即2020年9月25日
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/6e0db09b8ea743c9811f85083562da56
 * 来源：牛客网
 * <p>
 * 1. 这里的工作日是指从周一到周五，不考虑法定节假日和换休；
 * 2. 这里假设历法按现行历法，没有更改过；也即是说公元1年1月1日在此假设下是星期一
 * 3. 日期皆是指当天0:00为准，即输入的2020-09-08，是指2020-09-08 00:00。
 * 4. 输入的日期都是在此假设下合法的，所有输入都是正数
 */
public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param y1 int整型 当前日期的年
     * @param m1 int整型 当前日期的月
     * @param d1 int整型 当前日期的日
     * @param y2 int整型 项目截止日期的年
     * @param m2 int整型 项目截止日期的月
     * @param d2 int整型 项目截止日期的日
     * @return int整型
     */
    public int workdays_between(int y1, int m1, int d1, int y2, int m2, int d2) {
        // write code here
        LocalDate start = LocalDate.of(y1, m1, d1);
        LocalDate end = LocalDate.of(y2, m2, d2);
        long days = start.until(end, ChronoUnit.DAYS);
        if (days < 0) {
            return 0;
        }
        DayOfWeek sd = start.getDayOfWeek();
        DayOfWeek ed = end.getDayOfWeek();
        int shas = DayOfWeek.SUNDAY.getValue() - sd.getValue() + 1;
        int ehas = ed.getValue() - DayOfWeek.MONDAY.getValue();
        long allDays = days - shas - ehas;
        long weekdays = allDays - allDays / 7 * 2;
        if (shas > 2) {
            weekdays += shas - 2;
        }
        weekdays += Math.min(5, ehas);
        return (int) weekdays;
    }
}
