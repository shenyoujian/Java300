package com.ljs.testio;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;


/**
 * @Author ljs
 * @Description 操作目录
 * mkdir 创建目录 必须确保 父目录存在，如果不存在创建失败
 * mkdirs 创建目录，如果父目录不存在一同创建
 * list 返回该文件夹下的所有文件和目录的String数组
 * listFiles 返回该文件下的文件和目录的File数组
 * listFiles(FileFilter filter) 返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
 * static listRoots 根路径
 * @Date 2018/10/14 15:59
 **/
public class Demo04 {

    public static void main(String[] args) {
        //test01();
        test02();
    }

    static void test01() {
        String name = "e:/test";
        String name2 = "e:/test/parent/child";
        File file = new File(name2);
        if (!file.exists()) {
//            boolean flag = file.mkdir();
            boolean flag = file.mkdirs();
            System.out.println(flag ? "成功" : "失败");
        }

    }

    static void test02() {
        String path = "e:/test/parent/child";
        File file = new File(path);
        String[] subName = file.list();  //child下的文件和目录
        if (file.isDirectory()) {
            System.out.println("======子目录|文件名===");
            for (String s : subName) {
                System.out.println(s);
            }
        }

        File[] subFile = file.listFiles();
        if(file.isDirectory()){
            System.out.println("=====子目录|文件File对象====");
            for(File file1:subFile){
                System.out.println(file1);
            }
        }


        System.out.println("=====子文件.java对象====");
        //命令模式,钩子
        File[] files = file.listFiles(new FilenameFilter() {

            /**
             * 参数的意思就是要查询dir文件夹下的名字有name的文件和目录，这里的dir代表file
             **/
            @Override
            public boolean accept(File dir, String name) {
                //return name.endsWith(".java");
                // 如果没有设置为文件它会把目录带.java也查询
                return new File(dir,name).isFile()&&name.endsWith(".java");
            }
        });


        for(File file1:files){
            System.out.println(file1);
        }


    }
}
