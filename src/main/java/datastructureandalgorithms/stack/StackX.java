package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/19.
 */
public class StackX {

    private int[] value;
    private int maxSize;
    private int top;

    public StackX(int size){
        maxSize = size;
        value = new int[maxSize];
        top = -1;
    }

    public void push(int key){
        value[++top] = key;
    }

    public int pop(){
        return value[top--];
    }

    public boolean isFull(){
        return top == maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int peek(){
        return value[top];
    }
}
