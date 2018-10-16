package com.ljs.testio;

import java.io.File;

/**
 * @Author ljs
 * @Description
 * 相对路径与绝对路径构建File对象
 * 1、相对路径
 * File(String parent, String child)
   File(File parent, String child)
2、绝对路径
  File(String name);
 * @Date 2018/10/14 14:34
 **/
public class Demo02 {

    public static void main(String[] args) {
        String parentPath = "e:/abc";
        String name = "a.txt";
        //1、相对路径构建File
        File file = new File(new File(parentPath), name);
        file = new File(parentPath,name);
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        //2、绝对路径构建File
        file = new File("e:/abc/a.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        //没有盘符: 以 user.dir构建
        file =new File("test.txt");
        file =new File(".");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());

    }
}
