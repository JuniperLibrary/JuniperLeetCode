package com.dingchuan;

public class LC1702 {

  public String maximumBinaryString(String binary) {
    int i = binary.indexOf('0');
    if (i < 0) {
      return binary;
    }
    char[] charArray = binary.toCharArray();
    int j = 0;
    for (i++;i<charArray.length;i++){
      j += charArray[i] - '0';
    }
    return "1".repeat(charArray.length-1-j)+"0"+"1".repeat(j);
  }

  public static void main(String[] args) {
    System.out.println(new LC1702().maximumBinaryString("000110"));
  }
}
