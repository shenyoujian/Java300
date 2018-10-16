package com.ljs.testexception;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Author ljs
 * @Description 自定义异常
 * @Date 2018/10/11 18:45
 **/
public class Demo05 {
    public static void main(String[] args) {
        try {
            test();
        } catch (MyExecption myExecption) {
            myExecption.printStackTrace();
        }
    }

    static void test() throws MyExecption{

    }
}



class MyExecption extends Exception{
    public MyExecption(){};

    public MyExecption(String message){
        super(message);
    }
}
