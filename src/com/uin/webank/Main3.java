package com.uin.webank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {

  private Map<String, String> methods;

  public Main3() {
    this.methods = new HashMap<>();
  }

  public String createMethod(String methodDefinition) {
    String[] parts = methodDefinition.split("\\(");
    if (parts.length < 2) {
      return "Invalid method definition.";
    }

    String methodName = parts[0].trim();
    String methodArgs = parts[1].trim();

    if (methods.containsKey(methodName)) {
      return "Method " + methodName + " is already defined.";
    }

    methods.put(methodName, methodArgs);
    return "ok.";
  }

  public String callMethod(String methodName, String args) {
    if (!methods.containsKey(methodName)) {
      return "Cannot find symbol " + methodName + ".";
    }

    String expectedArgs = methods.get(methodName);
    if (!args.equals(expectedArgs)) {
      return "Method " + methodName + " cannot be applied to given types.";
    }

    return "ok.";
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numOperations = scanner.nextInt();
    scanner.nextLine();
    Main3 manager = new Main3();
    for (int i = 0; i < numOperations; i++) {
      int op = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      String operation = scanner.nextLine();

      if (op == 1) {
        String result = manager.createMethod(operation);
        System.out.println(result);
      } else if (op == 2) {
        String[] parts = operation.split("\\(");
        String methodName = parts[0].trim();
        String args1 = parts[1].trim().replaceAll("\\)", "");
        String result = manager.callMethod(methodName, args1);
        System.out.println(result);
      }
    }
  }
}
