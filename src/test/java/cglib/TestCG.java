package cglib;


import net.sf.cglib.beans.*;
import net.sf.cglib.proxy.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class TestCG {

    @Test
    public void testFixedValue() throws Exception {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CGlibSample.class);

        /*enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib!";
            }
        });*/

        //java lambda expression 与上面的代码段效果一样
        enhancer.setCallback((FixedValue)() -> {
            return "Hello cglib!";
        });

        CGlibSample proxy = (CGlibSample)enhancer.create();
        System.out.println(proxy.getClass());

        Assert.assertEquals("Hello cglib!",proxy.test("hello!"));

        Assert.assertEquals("Hello cglib!",proxy.toString());

        Assert.assertFalse("hello!".equals(proxy.test("hello!")));
    }

    @Test
    public void testInvocationHandler(){

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CGlibSample.class);

        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                /**
                 * method.getDeclaringClass() != Object.class  表示该方法不能是Object类中定义的方法，如：toString()。
                 * method.getReturnType() == String.class  表示方法的返回类型只能为String类型
                 */
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "Hello cglib!";
                } else {
                    //return method.invoke(o,objects);
                    return "do not know what to do";
                }
            }
        });

        CGlibSample proxy = (CGlibSample) enhancer.create();

        Assert.assertTrue("Hello cglib!".equals(proxy.test("hello!")));

        Assert.assertTrue("do not know what to do".equals(proxy.toString()));

    }


    @Test
    public void testMethodInterceptor(){

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CGlibSample.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "Hello cglib!";
                } else {
                    return proxy.invokeSuper(obj,args);
                }
            }
        });

        CGlibSample proxy = (CGlibSample) enhancer.create();

        Assert.assertTrue("Hello cglib!".equals(proxy.test("hello!")));

        Assert.assertFalse("do not know what to do".equals(proxy.toString()));
    }


    @Test
    public void testCallbackFilter() {

        Enhancer enhancer = new Enhancer();

        CallbackHelper callbackHelper = new CallbackHelper(CGlibSample.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "Hello cglib!";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };

        enhancer.setSuperclass(CGlibSample.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());

        CGlibSample proxy = (CGlibSample) enhancer.create();

        Assert.assertTrue("Hello cglib!".equals(proxy.test("hello!")));
        System.out.println(proxy.hashCode());
        Assert.assertFalse("do not know what to do".equals(proxy.toString()));
    }


    @Test(expected = java.lang.IllegalStateException.class)
    public void testImmutableBean(){

        SampleBean sampleBean = new SampleBean();

        sampleBean.setValue("Hello cglib");

        SampleBean immutableBean = (SampleBean) ImmutableBean.create(sampleBean);

        Assert.assertTrue("Hello cglib".equals(immutableBean.getValue()));

        sampleBean.setValue("Hello cglib again");
        Assert.assertTrue("Hello cglib again".equals(immutableBean.getValue()));

        immutableBean.setValue("Hello World!");//throw Exception java.lang.IllegalStateException: Bean is immutable
    }


    @Test
    public void testBeanGenerator() throws Exception{

        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("value",String.class);

        Object bean = beanGenerator.create();
        //获取bean的setter方法
        Method setter = bean.getClass().getMethod("setValue",String.class);
        setter.invoke(bean,"Hello cglib");

        //获取bean的getter方法
        Method getter = bean.getClass().getMethod("getValue");

        Assert.assertTrue("Hello cglib".equals(getter.invoke(bean)));


    }


    @Test
    public void testBeanCopier(){

        BeanCopier copier = BeanCopier.create(SampleBean.class,OtherSampleBean.class,false);

        SampleBean sampleBean = new SampleBean();
        sampleBean.setValue("sample bean");

        OtherSampleBean otherSampleBean = new OtherSampleBean();
        copier.copy(sampleBean,otherSampleBean,null);

        Assert.assertTrue("sample bean".equals(otherSampleBean.getValue()));
    }


    @Test
    public void testBulkBean(){

        BulkBean bulkBean = BulkBean.create(SampleBean.class,
                new String[]{"getValue"},
                new String[]{"setValue"},
                new Class[]{String.class});

        SampleBean bean = new SampleBean();
        bean.setValue("sample bean");

        Assert.assertTrue(bulkBean.getPropertyValues(bean).length == 1);

        Assert.assertTrue("sample bean".equals(bulkBean.getPropertyValues(bean)[0]));

        bulkBean.setPropertyValues(bean,new Object[]{"bulk bean"});

        Assert.assertTrue("bulk bean".equals(bean.getValue()));
    }

    @Test
    public void testBeanMap(){

        SampleBean bean = new SampleBean();

        BeanMap map = BeanMap.create(bean);
        bean.setValue("bean mao");

        Assert.assertTrue("bean mao".equals(map.get("value")));

    }
}
