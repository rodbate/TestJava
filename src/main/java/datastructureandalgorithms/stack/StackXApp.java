package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/19.
 */
public class StackXApp {

    public static void main(String[] args) {

        StackX stack = new StackX(5);

        stack.push(1);
        stack.push(3);
        stack.push(2);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
