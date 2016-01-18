package classload;


public class SuperClass {

    static {
        System.out.println("SuperClass init....");
    }

    public static int value;

    public static final int constant = 1;
}
