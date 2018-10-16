package com.ljs.testio.byteio;

import java.io.*;

/**
 * @Author ljs
 * @Description
 * 文件的写出
 * 1、建立联系
 * 2、选择流
 * 3、操作
 * 4、关闭资源
 * @Date 2018/10/15 13:47
 **/
public class Demo02 {
    public static void main(String[] args) {
        //1、建立联系
        File file = new File("e:/b.txt");
        //2、选择流
        OutputStream os = null;
        try{
            //true表示追加，默认false，true的时候会在文件的末尾追加要写入的
            //false的话会覆盖文件之前的
            os = new FileOutputStream(file,true);
            String s = "i feel good";
            //字符串转字节
            byte[] bytes = s.getBytes();
            os.write(bytes);
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件找不到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入文件失败");
        }finally {
            //4、释放资源
            try{
                if(os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭资源失败");
            }
        }
    }
}
