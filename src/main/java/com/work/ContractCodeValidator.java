package com.work;

public class ContractCodeValidator {

  /**
   * 校验合约代码是否合法（仅允许字母和数字）
   *
   * @param contractCode 合约代码
   * @return true-合法，false-非法
   */
  public static boolean isValidContractCode(String contractCode) {
    if (contractCode == null || contractCode.isEmpty()) {
      return false; // 空值视为非法
    }

    // 正则匹配：仅允许字母和数字
    return contractCode.matches("^[a-zA-Z0-9]*$");
  }

  /**
   * 带详细错误信息的校验
   *
   * @param contractCode 合约代码
   * @return 错误信息（如果合法则返回 null）
   */
  public static String validateContractCode(String contractCode) {
    if (contractCode == null) {
      return "合约代码不能为空";
    }
    if (contractCode.isEmpty()) {
      return "合约代码不能为空字符串";
    }
    if (!contractCode.matches("^[a-zA-Z0-9]*$")) {
      return "合约代码不能包含特殊字符";
    }
    return null;
  }

  public static void main(String[] args) {
    // 合法合约代码
    System.out.println("999001 是否合法: " + ContractCodeValidator.isValidContractCode("999001")); // true
    System.out.println("lsSHCH 是否合法: " + ContractCodeValidator.isValidContractCode("lsSHCH")); // true
    System.out.println("HK0000814878 是否合法: " + ContractCodeValidator.isValidContractCode("HK0000814878")); // true
    System.out.println("ls6Y 是否合法: " + ContractCodeValidator.isValidContractCode("ls6Y")); // true

    // 非法合约代码（包含特殊字符）
    System.out.println("99_9001 是否合法: " + ContractCodeValidator.isValidContractCode("99_9001")); // false（含下划线）
    System.out.println("lsS-HCH 是否合法: " + ContractCodeValidator.isValidContractCode("lsS-HCH")); // false（含连字符）
    System.out.println("HK@0000814878 是否合法: " + ContractCodeValidator.isValidContractCode("HK@0000814878")); // false（含@）

    // 带错误信息的校验
    System.out.println("HK@0000814878 校验结果: " + ContractCodeValidator.validateContractCode("HK@0000814878")); // "合约代码不能包含特殊字符"
    System.out.println("空字符串校验结果: " + ContractCodeValidator.validateContractCode("")); // "合约代码不能为空字符串"
    System.out.println("null 校验结果: " + ContractCodeValidator.validateContractCode(null)); // "合约代码不能为空"
    System.out.println("HK0000814878 校验结果: " + ContractCodeValidator.validateContractCode("HK0000814878"));
  }
}
