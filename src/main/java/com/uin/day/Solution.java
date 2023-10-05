package com.uin.day;

public class Solution {

  public static void main(String[] args) {
    int[] ints = flipImage(2, new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4});
    for (int anInt : ints) {
      System.out.print(anInt);
    }
  }

  public static int[] flipImage(int width, int[] pixels) {
    // write code here
    // 2,[1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4]
    // [2,2,2,2,1,1,1,1,4,4,4,4,3,3,3,3]
    //1,[1,2,3,4]
    // [1,2,3,4]
    int height = pixels.length / width; // 计算图像的高度
    int[] flippedPixels = new int[pixels.length]; // 创建一个新的数组用于存储翻转后的图像

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        int originalIndex = row * width + col; // 计算像素在原始图像中的索引
        int flippedIndex = (height - 1 - row) * width + col; // 计算像素在翻转后图像中的索引
        flippedPixels[flippedIndex] = pixels[originalIndex]; // 将像素复制到翻转后的位置
      }
    }

    return flippedPixels;
  }
}
