package com.ljs.testio.byteio;

import java.io.*;

/**
 * @Author ljs
 * @Description
拷贝文件
1、建立联系 两个File对象 源头和目的地
2、选择流
文件输入流：InputStream FileInputStream
文件输出流：OutputStream FileOutputStream
3、操作：拷贝
byte[] bs = new byte[1024];
int len = 0;
while(!=-1){
write + flush
}
4、释放资源，关闭两个流
 * @Date 2018/10/15 14:17
 **/
public class CopyFileDemo {



    static void copyFile(String srcPath,String desPath) throws IOException {
        //1、建立联系
        File src = new File(srcPath);
        File des = new File(desPath);
        //2、选择流
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(des);
        byte[] bytes = new byte[1024];  //缓冲数组
        int len = 0;
        while((len = is.read(bytes))!=-1){
            os.write(bytes);
        }
        os.flush();
    }
}
