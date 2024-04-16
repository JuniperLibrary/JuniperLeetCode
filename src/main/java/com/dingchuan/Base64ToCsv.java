package com.dingchuan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class Base64ToCsv {

//  public static void main(String[] args) {
//    // 假设你有一个包含Base64数据的数组
//    String[] base64DataArray = {
//        "YmFzZTY0IGVuY29kaW5n",
//        "aW1hZ2Ugc3RyaW5n",
//        "dGV4dCBtZXNzYWdl"
//    };
//
//    // 假设你想将其导出到名为data.csv的CSV文件中
//    String csvFilePath = "data.csv";
//
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
//      // 写入标题行，如果有的话
//      writer.write("Base64 Data\n");
//
//      // 写入Base64数据
//      for (String base64Data : base64DataArray) {
//        writer.write(base64Data + "\n");
//      }
//
//      System.out.println("CSV文件已创建: " + csvFilePath);
//    } catch (IOException e) {
//      System.err.println("无法创建CSV文件: " + e.getMessage());
//    }
//  }

  public static void main(String[] args) {
    // 假设你有一个包含byte[]数组的数组
    byte[][] byteArrayArray = {
        "Hello".getBytes(),
        "World".getBytes(),
        "Base64".getBytes()
    };

    // 假设你想将其导出到名为data.csv的CSV文件中
    String csvFilePath = "data.csv";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
      // 写入标题行，如果有的话
      writer.write("Base64 Data\n");

      // 写入Base64数据
      for (byte[] byteArray : byteArrayArray) {
        String base64Data = Base64.getEncoder().encodeToString(byteArray);
        writer.write(base64Data + "\n");
      }

      System.out.println("CSV文件已创建: " + csvFilePath);
    } catch (IOException e) {
      System.err.println("无法创建CSV文件: " + e.getMessage());
    }
  }

}
