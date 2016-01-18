package classload;


public class SubClass extends SuperClass{

    static {
        //i = 1;     ok
        //int b = i;   <clinit>()方法 为static代码块和静态变量服务。
        System.out.println("SubClass init.....");
    }

    public static int i =1;
}
