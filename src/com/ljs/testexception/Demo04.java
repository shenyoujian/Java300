package com.ljs.testexception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author ljs
 * @Description 测试throw
 * @Date 2018/10/11 18:45
 **/
public class Demo04 {
    public static void main(String[] args) {
        //main也可以往上抛抛给jre，但是最好不要这么做。
        File file = new File("e://a.txt");
        if(!file.exists()){
            try {
                //自己new一个异常对象
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
