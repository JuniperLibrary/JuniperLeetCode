package com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * 2678. 老人的数目
 *
 * @author lin.liu
 */
@Slf4j
public class LeetCode2678 {

  public static void main(String[] args) {
    String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
    String[] details1 = {"1313579440F2036", "2921522980M5644"};
    String[] details2 = {"5612624052M0130", "5378802576M6424", "5447619845F0171", "2941701174O9078"};
    log.info("老人的数目:{}", countSeniors(details));
    log.info("老人的数目:{}", countSeniors(details1));
    log.info("老人的数目:{}", countSeniors(details2));
  }

  public static int countSeniors(String[] details) {
    int ans = 0;
    for (String detail : details) {
      int anInt = Integer.parseInt(detail.substring(11, 13));
      if (anInt > 60) {
        ans += 1;
      }
    }
    return ans;
  }
}
