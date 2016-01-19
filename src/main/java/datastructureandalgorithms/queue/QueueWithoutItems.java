package datastructureandalgorithms.queue;

/**
 * Created by rod bate on 2016/1/19.
 */
public class QueueWithoutItems {

    private int[] value;
    private int maxSize;
    private int front;
    private int rear;

    public QueueWithoutItems(int size){
        maxSize = size;
        value = new int[maxSize];
        front = 0;
        rear = -1;
    }

    public QueueWithoutItems insert(int key){
        if (rear == maxSize -1){
            rear = -1;
        }
        value[++rear] = key;
        return this;
    }

    public QueueWithoutItems remove(){
        front++;
        if (front == maxSize) {
            front = 0;
        }
        return this;
    }

    public int size(){
        int size;
        if (rear >= front) {
            size = rear - front + 1;
        } else {
            size = maxSize - front + rear + 1;
        }
        return size;
    }

    public boolean isFull(){
        return rear - front + 1 == maxSize || front == rear + 1;
    }

    public boolean isEmpty(){
        return rear == front - 1 || front == maxSize + rear + 1;
    }
}
