//package com;
//
//import java.text.SimpleDateFormat;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//public class main {
//
//  public static void main(String[] args) {
////    可以使用Java中的Date类和Calendar类来比较时间是否是历史时间。
////
////    比较方法如下：
////
////    使用Date类的before()方法，将当前时间作为参数，判断待比较时间是否在当前时间之前。
////    Date date = new Date();
////    Date targetDate = new Date(2021, 8, 10);
////    if(targetDate.before(date)){
////      //是历史时间
////    }
////    使用Calendar类的compareTo()方法，将当前时间作为参数，判断待比较时间是否在当前时间之前。
////    Calendar calendar = Calendar.getInstance();
////    Calendar targetCalendar = Calendar.getInstance();
////    targetCalendar.set(2021, 8, 10);
////    if(targetCalendar.compareTo(calendar) < 0){
////      //是历史时间
////    }
////    注意，上面的示例中，月份是从0开始计数的，因此9表示的是10月份。另外，Date类已经被标记为过时，建议使用更加新的时间处理类如LocalDateTime、ZonedDateTime等。
//
//    String value = "{'default':['120','30']}";
//    Integer halfLifeType;
//    try{
//      halfLifeType = Integer.parseInt(value);
//    }catch (Exception e){
//      halfLifeType=0;
//    }
//    System.out.println(halfLifeType);
//  }
//
//  static class SystemTime{
//    private static long milliseconds = 0L;
//
//    public SystemTime() {
//    }
//
//    public static Instant nowInstant() {
//      Instant now = Instant.now();
//      return milliseconds == 0L ? now : Instant.ofEpochMilli(now.toEpochMilli() + milliseconds);
//    }
//
//    public static Date now() {
//      Date now = new Date();
//      return milliseconds == 0L ? now : new Date(now.getTime() + milliseconds);
//    }
//
//    public static long currentTimeMillis() {
//      return nowInstant().toEpochMilli();
//    }
//
//    public static void set(Date date) {
//      milliseconds = date.getTime() - now().getTime();
//    }
//
//    public static void setShift(long n, TimeUnit timeUnit) {
//      switch (timeUnit) {
//        case DAYS:
//          milliseconds = n * 24L * 3600L * 1000L;
//          break;
//        case HOURS:
//          milliseconds = n * 3600L * 1000L;
//      }
//
//    }
//
//    public static long getShift() {
//      return milliseconds;
//    }
//  }
//}
