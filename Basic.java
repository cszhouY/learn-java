/*
 * @Author: Zhou Yee
 * @Email: zhou.yee@foxmail.com
 * @Date: Created in 20/9/2022
 * @Description: java基础语法，主要介绍与c/c++不同之处
 * Copyright (c) 2022 Zhou Yee
 */
import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.*;

public class Basic {
    public static void data(){
//        java中大部分数据类型及大小与64位机器的C相同
//        java提供了byte数据类型
        long a = 0xFFFFFFFF;
        int b = (int) a;
        System.out.printf("%x\n", b);
//        java中字符采用unicode编码，char为2字节
        char c = (char) a;
        System.out.printf("%x\n", (int)c);
//        byte为1字节
        byte d = (byte) a;
        System.out.printf("%x\n", d);
    }
    public static void io(){
//        输入输出测试
//        使用Scanner的输入输出模块
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inout your name:");
        String name = scanner.nextLine();
        System.out.print("Input your age:");
        int age = scanner.nextInt();
        System.out.printf("Hi, %s, your are %d\n", name, age);
    }
    public static void judge(){
//        条件分支与判断测试
//        java默认的浮点类型为double，直接使用float会报错
        double f1 = 0.1;
//        float f1 = 0.1f;  // 如果使用float，加上f或F指明是float类型
        double f2 = 1 - 9.0 / 10;
//        浮点数的比较不能直接使用==，要利用差值小于某个临界来判断
//        因为浮点数在计算机中存储是不精确的，详见IEEE标准
        if(Math.abs(f1-f2) < 0.000001){ //不能用if(f1 == f2)
            System.out.println("f1 == f2");
        }
        else {
            System.out.println("f1 != f2");
        }
//        对于引用类型，==比较是否引用同一个对象
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "HELLO".toLowerCase();
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
//        判断引用变量的内容是否相等使用equals()方法，使用该方法的对象不能为null
        System.out.println(str1.equals(str3));
    }
    public static void switchTest(){
//        测试switch
//        switch case结构与c语言相同，后面可以接字符串
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        switch (fruit){
            case "apple":
                System.out.println("It is a apple");
                break;
            case "banana":
                System.out.println("It is a banana");
                break;
            case "pear":
                System.out.println("It is a pear");
                break;
            default:
                System.out.println("I don't know what it is");
                break;
        }
//        有一种省略break的编写形式
        switch (fruit){
            case "apple" -> System.out.println("It is a apple");
            case "banana"-> System.out.println("It is a banana");
            case "pear" -> {
                System.out.println("It is a pear");
                System.out.println("good choice!");
            }
            default -> System.out.println("I don't like it");
        }
//        switch语句还可以作为赋值语句的右值
//        如果需要复杂的语句，可以使用yeild返回值
        int opt = switch (fruit){
            case "apple" -> 1;
            case "banane" -> 2;
            case "pear" ->3;
            default -> {
                int code = fruit.hashCode();
                yield code;
            }
        };
        System.out.println("opt=" + opt);
    }
    public static void loop(){
//        测试循环
//        while、do while、for循环与C相同，提供for each
        int[] ns = {1, 4, 9, 16, 25};
        int sum = 0;
//        变量n此时直接对应到数组的每个元素
        for(int n : ns){
            sum += n;
        }
        System.out.println(sum);
    }
    public static void array(){
//        测试数组
//        一维数组的定义在前面的函数中已经体现
//        有以下三种方式
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[5];
        int[] arr3 = new int[] {1,2,3,4,5};
//        二维数组中的数组长度可以不一致
        int[][] arr2d = {
                {1,2,3},
                {1,2,8,6},
                {0}
        };
//        for each遍历二维数组
        for(int[] arr : arr2d){
            for(int n : arr){
                System.out.printf("%d,", n);
            }
        }
    }
    public static void arraySort(){
//        测试数组排序
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = scanner.nextInt();
        }
//        升序
        Arrays.sort(ns);
//        输出数组，中文可能会乱码，需要在设置中将文本编辑的编码改为GBK
        System.out.println("升序：" + Arrays.toString(ns));
//        降序，不能使用基本数据类型，int为Interger，float为Float
        Integer arr[] = new Integer[] {1, 2, 3, 4, 5};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("降序：" + Arrays.toString(arr));
    }
    public static void main(String[] args){
//        data();
//        io();
//        judge();
//        switchTest();
//        loop();
//        array();
//        arraySort();
    }
}
