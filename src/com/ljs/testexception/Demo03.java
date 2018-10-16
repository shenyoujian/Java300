package com.ljs.testexception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

/**
 * @Author ljs
 * @Description throws测试
 * @Date 2018/10/11 18:12
 **/
public class Demo03 {
    public static void main(String[] args) {
        //main也可以往上抛抛给jre，但是最好不要这么做。
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //把异常对象抛给调用它的
    static void readFile() throws IOException {
        Reader reader = null;
        //读取文件
        reader = new FileReader("E://a.txt");
        char c = (char) reader.read();
        System.out.println("bbb");

    }
}


//父类抛出checked异常
class A {
    public void method() throws IOException { };
}

class B extends A {
    public void method() throws IOException { };
}

class C extends A {
    public void method() throws FileNotFoundException { };
}

//class D extends A {
//    public void method() throws Exception { };
//}

class E extends A {
    public void method() throws FileNotFoundException,IOException { };
}

//运行时异常也可以
class F extends A {
    public void method() throws ArithmeticException,IOException { };
}

//class G extends A {
//    public void method() throws ParseException,IOException { };
//}


//父类抛出unchecked异常
class H {
    public void method() throws ArithmeticException { };
}

class I extends H{
    public void method() throws NullPointerException,RuntimeException { };
}
