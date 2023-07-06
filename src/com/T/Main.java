package com.T;

public class Main {

  private static int a = 0;

  // ok ,fat
  // 0,6
  // 0,12
  public static void main(String[] args) {
    Person person = new Person(7, "jack");
    int b = 0;
    Integer c = 0;
    String str = new String("Uin");
    System.out.println("修改前a的值" + a);
    changeA(a);
    System.out.println("修改后a的值" + a);

    System.out.println("----------------------");

    System.out.println("修改前name的值" + person);
    changeName(person);
    System.out.println("修改后name的值" + person);

    System.out.println("----------------------");
    System.out.println("修改前name的值" + person);
    changeName1(person);
    System.out.println("修改后name的值" + person);

    System.out.println("----------------------");

    System.out.println("修改前num的值" + b);
    changeValue(b);
    System.out.println("修改后num的值" + b);

    System.out.println("----------------------");

    System.out.println("修改前Integer的值" + c);
    changeIntegerValue(c);
    System.out.println("修改后Integer的值" + c);

    System.out.println("----------------------");

    System.out.println("修改前str的值" + str);
    changeStringValue(str);
    System.out.println("修改后str的值" + str);

    System.out.println("----------------------");

    System.out.println("修改前str的值" + str);
    changeStringValue1(str);
    System.out.println("修改后str的值" + str);
  }

  public static void changeA(int a) {
    // a = 1;
    Main.a = 1;
  }

  public static void changeName(Person person) {
    person = new Person(8, "Tom");
  }

  public static void changeName1(Person person) {
    person.setName("Ros");
  }

  public static void changeValue(Integer b) {
    b = 7;
  }

  public static void changeIntegerValue(Integer c) {
    c = 9;
  }

  public static void changeStringValue(String str) {
    str = "Lisi";
  }

  public static void changeStringValue1(String str) {
    str = new String("Lisi");
  }
}

class Person {

  private int age;
  private String name;

  public Person() {

  }

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" +
        "age=" + age +
        ", name='" + name + '\'' +
        '}';
  }
}