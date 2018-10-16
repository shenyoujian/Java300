package com.ljs.testexception;

/**
 * @Author ljs
 * @Description 测试异常
 * @Date 2018/10/10 18:34
 **/
public class Demo01 {

    public static void main(String[] args) {
        //unchecked exception
//        System.out.println(1/0);
        //checked exception
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String a = "1234abc";
        Integer i = new Integer(a);
    }
}
