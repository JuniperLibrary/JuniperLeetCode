package com.lc150;

import java.util.ArrayList;
import java.util.List;

public class LC68 {

  public List<String> fullJustify(String[] words, int maxWidth) {
    int pointer = 0;
    int n = words.length;
    int totalLength = 0;
    int totalSize = 0;
    List<String> ans = new ArrayList();
    List<String> tmp = new ArrayList();
    while (pointer < n) {
      totalLength += words[pointer].length();
      totalSize++;
      tmp.add(words[pointer]);
      if (totalLength + totalSize - 1 > maxWidth) {
        tmp.remove(tmp.size() - 1);
        ans.add(line(tmp, maxWidth, totalLength - words[pointer].length(), false));
        totalLength = words[pointer].length();
        totalSize = 1;
        tmp.clear();
        tmp.add(words[pointer]);
      }
      pointer++;
    }
    ans.add(line(tmp, maxWidth, totalLength, true));
    return ans;
  }

  private String line(List<String> list, int maxWidth, int totalLength, boolean isLast) {
    StringBuilder sb = new StringBuilder();
    sb.append(list.get(0));
    if (list.size() == 1) {
      String ap = " ".repeat(maxWidth - totalLength);
      sb.append(ap);
      return sb.toString();
    } else {
      if (!isLast) {
        int singleSpace = (maxWidth - totalLength) / (list.size() - 1);
        boolean isExact = false;
        int ret = 0;

        if (singleSpace * (list.size() - 1) == (maxWidth - totalLength)) {
          isExact = true;
        } else {
          ret = (maxWidth - totalLength) - singleSpace * (list.size() - 1);
        }

        String sp = " ".repeat(singleSpace);
        for (int i = 1; i < list.size(); i++) {
          // space
          if (!isExact && (ret--) > 0) {
            sb.append(" ");
          }
          sb.append(sp);
          // word
          sb.append(list.get(i));
        }
        return sb.toString();
      } else {
        for (int i = 1; i < list.size(); i++) {
          // space
          sb.append(" ");
          // word
          sb.append(list.get(i));
        }
        sb.append(" ".repeat(maxWidth - sb.length()));
        return sb.toString();
      }
    }
  }
}
