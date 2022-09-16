# Java中的三种移位运算符
- `<<` :左移运算符，num<<1 ,相当于num*2
- `>>` ：右移运算符，num>>1 ,相当于num/2
- `>>>` ：无符号右移，忽略符号位，空位都以0补齐

```java
public class Test {
    public static void main(String[] args) {
        int number = 10;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}
```
```text
运行结果：
1010
10100
1010
```
```text
43210      位数
--------
 1010      十进制：10     原始数         number
10100      十进制：20     左移一位       number = number << 1;
 1010      十进制：10     右移一位       number = number >> 1;
```
