package com.ljs.testexception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @Author ljs
 * @Description 测试trycatchfinally和return
 * @Date 2018/10/11 16:44
 **/
public class Demo02 {

    public static void main(String[] args) {
        String re = readFile();
        System.out.println(re);
    }


    static String readFile() {
        Reader reader = null;
        //读取文件
        try {
            System.out.println("aaa");
            reader = new FileReader("E://a.txt");
            char c = (char) reader.read();
            System.out.println("bbb");
            return "try";
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("catching");
            return "catching";
        } finally {
            System.out.println("finally");
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "finally";
        }
    }
}


