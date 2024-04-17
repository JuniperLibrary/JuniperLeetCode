package com.dingchuan;

import com.google.common.primitives.Bytes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class Base64ToCsv {

  public static void main(String[] args) {
    // 假设你有一个包含Base64数据的数组
//    String[] base64DataArray = {
//        "YmFzZTY0IGVuY29kaW5n",
//        "aW1hZ2Ugc3RyaW5n",
//        "dGV4dCBtZXNzYWdl"
//    };

    String context = "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";
    byte[] encode = java.util.Base64.getEncoder().encode(context.getBytes());
    List<Byte> list = Bytes.asList(encode);
    String[] base64DataArray = list.stream().map(String::valueOf).toArray(String[]::new);

    // 假设你想将其导出到名为data.csv的CSV文件中
    String csvFilePath = "data.csv";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
//      // 写入标题行，如果有的话
//      writer.write("Base64 Data\n");

      // 写入Base64数据
      for (String base64Data : base64DataArray) {
        writer.write(base64Data + "\n");
      }

      System.out.println("CSV文件已创建: " + csvFilePath);
    } catch (IOException e) {
      System.err.println("无法创建CSV文件: " + e.getMessage());
    }
  }

//  public static void main(String[] args) {
//    // 假设你有一个包含byte[]数组的数组
//    byte[][] byteArrayArray = {
//        "Hello".getBytes(),
//        "World".getBytes(),
//        "Base64".getBytes()
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
//      for (byte[] byteArray : byteArrayArray) {
//        String base64Data = Base64.getEncoder().encodeToString(byteArray);
//        writer.write(base64Data + "\n");
//      }
//
//      System.out.println("CSV文件已创建: " + csvFilePath);
//    } catch (IOException e) {
//      System.err.println("无法创建CSV文件: " + e.getMessage());
//    }
//  }

}
