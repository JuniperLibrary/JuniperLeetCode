package com.work;

import java.math.*;
import java.text.*;
import java.util.*;

public class DateDataFusion {
  public static class IndicatorHistoryDataResponseVO {
    private Date date;
    private BigDecimal data;

    public IndicatorHistoryDataResponseVO(Date date, BigDecimal data) {
      this.date = date;
      this.data = data;
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public BigDecimal getData() {
      return data;
    }

    public void setData(BigDecimal data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "{" +
          "\"date\": \"" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "\"" +
          ", \"data\": " + (data == null ? "null" : data) +
          '}';
    }
  }
  public static List<IndicatorHistoryDataResponseVO> generateDateDataList(Date beginTime, Date endTime, List<IndicatorHistoryDataResponseVO> responseVOList) {
    List<IndicatorHistoryDataResponseVO> result = new ArrayList<>();

    // 将 responseVOList 转换为一个日期 -> 数据的映射，以便快速查找
    Map<String, BigDecimal> dataMap = new HashMap<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for (IndicatorHistoryDataResponseVO vo : responseVOList) {
      dataMap.put(sdf.format(vo.getDate()), vo.getData());
    }

    // 从 beginTime 到 endTime 遍历每一天
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(beginTime);

    while (!calendar.getTime().after(endTime)) {
      Date currentDate = calendar.getTime();
      String dateStr = sdf.format(currentDate);

      BigDecimal data = dataMap.getOrDefault(dateStr, null);
      result.add(new IndicatorHistoryDataResponseVO(currentDate, data));

      calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    return result;
  }

  public static void main(String[] args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // 输入的日期范围
    Date beginTime = sdf.parse("2025-01-20");
    Date endTime = sdf.parse("2025-02-18");

    // 输入的 responseVOList 数据
    List<IndicatorHistoryDataResponseVO> responseVOList = new ArrayList<>();
    responseVOList.add(new IndicatorHistoryDataResponseVO(sdf.parse("2025-01-20"), new BigDecimal("10.3902")));
    responseVOList.add(new IndicatorHistoryDataResponseVO(sdf.parse("2025-02-18"), new BigDecimal("6.3868")));

    // 生成日期范围内的结果
    List<IndicatorHistoryDataResponseVO> result = generateDateDataList(beginTime, endTime, responseVOList);

    // 打印结果
    for (IndicatorHistoryDataResponseVO vo : result) {
      System.out.println(vo);
    }
  }
}
