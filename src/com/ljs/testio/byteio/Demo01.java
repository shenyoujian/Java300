package com.ljs.testio.byteio;

import java.io.*;

/**
 * @Author ljs
 * @Description
 * 文件的读取
 * 1、建立联系 File对象
 * 2、选择流  文件输入流 InputStream FileInputStream
 * 3、操作  : byte[] car =new byte[1024];  +read+读取大小
 *  输出
 * 4、释放资源 :关闭
 * @Date 2018/10/15 13:14
 **/
public class Demo01 {

    public static void main(String[] args) {
        //1、建立联系
        File file = new File("e:/a.txt");
        InputStream is = null;
        try {
            //2、选择流
            is = new FileInputStream(file);
            //3、操作，不断读取，缓冲数组
            //先定义一个缓存数组，每次read之后会把读到的暂时保存在这个缓冲数组中
            byte[] car = new byte[1024];
            int len = 0;   //再定义一个实际读取的字节，因为不可能刚好每次都是读取1024个字节
            //循环读取
            while((len=is.read(car))!=-1){
                //第一次读1024字节，当全部读完之后，再读就会是-1
                //读到的是字节，需要转换字符串输出
                //因为这里就循环一次所以可以用String
                //循环多次就不能用String会覆盖，因为String是不可变的
                //可以使用Stringbuffer
                String info = new String(car,0,len);
                System.out.println(info);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件失败");
        }finally {
            try{
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭资源失败");
            }
        }
    }
}
