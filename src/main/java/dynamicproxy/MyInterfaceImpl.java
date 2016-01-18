package dynamicproxy;

/**
 * Created by rodbate on 2015/12/30.
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public String say(String str) {
        return str;
    }
}
