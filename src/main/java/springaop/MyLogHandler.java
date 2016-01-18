package springaop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyLogHandler implements InvocationHandler{

    //动态代理的目标对象 ，在这里就是UserServiceImpl
    private Object targetObject;


    /**
     *
     * @param targetObject 动态代理的目标对象
     * @return 动态代理对象
     */
    public Object createProxy(Object targetObject){

        this.targetObject = targetObject;

        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        try {
            beforeLog();
            object = method.invoke(targetObject, args);
            afterLog();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    private void beforeLog(){
        System.out.println("print log before the method executes......");
    }

    private void afterLog(){
        System.out.println("print log after the method executes......");
    }
}
