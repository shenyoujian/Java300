package com.ljs.testio;

import java.io.File;
import java.io.IOException;

/**
 * @Author ljs
 * @Description File常用方法
 * 1、文件名
 * getName() 文件名
 * getPath 绝对路径创建的file返回绝对路径，相对路径创建的返回相对路径
 * getAbsolutePath 绝对路径名
 * getParent 父目录，如果是相对路径创建的返回null
 * 2、判断信息
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute()：消除平台差异，ie以盘符开头，其他以/开头
 * 3、长度 字节数  不能读取文件夹的长度
 * length()
 * 4、创建、删除
 * createNewFile() 不存在创建新文件,存在返回false
 * delete() 删除文件
 * static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
 * staticcreateTempFile(前缀3个字节长，后缀默认.temp,目录)
 * deleteOnExit() 退出虚拟机删除,常用于删除临时文件
 * @Date 2018/10/14 15:17
 **/
public class Demo03 {

    public static void main(String[] args) {
       // test01();
        //test02();
        try {
            test03();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建文件失败");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void test01(){
        //绝对路径创建
        String name = "e:/a.txt";
        //相对路径创建
        String name2 = "a.txt";
        File file = new File(name2);
        System.out.println(file.getName());
        System.out.println(file.getPath());//如果是绝对路径，返回完整路径，否则相对路径
        System.out.println(file.getAbsolutePath());//返回绝对路径
        System.out.println(file.getParent());//返回上一级目录，如果是相对，返回null
    }

    static void test02(){
        //绝对路径创建,存在
        String name = "e:/a.txt";
        //相对路径创建,不存在
        String name2 = "a.txt";
        File file = new File(name);
        System.out.println(file.exists());
        System.out.println(file.canWrite());
        System.out.println(file.canRead());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isAbsolute());
        System.out.println(file.length());
    }

    static void test03() throws IOException, InterruptedException {
        String name = "e:/b.txt";
        File file = new File(name);
        if(!file.exists()){
            boolean flag = file.createNewFile();
            System.out.println(flag?"成功":"失败");
        }

        Thread.sleep(4000);
        //删除文件

        if(file.exists()){
            boolean flag = file.delete();
            System.out.println(flag?"成功":"失败");
        }

    }
}
