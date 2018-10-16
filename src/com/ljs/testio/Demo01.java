package com.ljs.testio;

import java.io.File;

/**
 * @Author ljs
 * @Description
 * File两个常量
 * 1、路径分隔符 ；
 * 2、名称分隔符 window(\) linux(/)
 *
 * @Date 2018/10/11 19:17
 **/
public class Demo01 {

    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        //路径的表示形式
        String path = "e:\\a.txt";
        path = "e:" + File.separator + "a.txt";
        //推荐方式
        path = "e:/a.txt";


    }
}
