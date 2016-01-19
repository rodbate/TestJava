package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/19.
 */
public class StackChar {

    private char[] value;
    private int maxSize;
    private int top;


    public StackChar(int size){
        maxSize = size;
        value = new char[maxSize];
        top = -1;
    }

    public void push(char key){
        value[++top] = key;
    }

    public char pop(){
        return value[top--];
    }

    public boolean isFull(){
        return top == maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

}
