package dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by rodbate on 2015/12/30.
 */
public class TestProxy {

    public static void main(String[] args) {

        MyHandler handler = new MyHandler();

        MyInterface instance = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),new Class[]{MyInterface.class},handler);

        System.out.println(instance.say("success........."));
    }
}
