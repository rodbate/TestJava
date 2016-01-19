package datastructureandalgorithms.queue;

/**
 * Created by rod bate on 2016/1/19.
 */
public class Queue {

    private int[] value;
    private int front;
    private int rear;
    private int nItems;
    private int maxSize;

    public Queue(int size){
        maxSize = size;
        value = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }


    public void insert(int key){
        if (rear == maxSize - 1) {
            rear = -1;
        }
        value[++rear] = key;
        nItems ++;
    }

    //remove the rear item in the queue
    public int remove(){
        int item = value[front++];
        if (front == maxSize){
            front = 0;
        }
        nItems--;
        return item;
    }

    public int peekFront(){
        return value[front];
    }

    public int peekRear(){
        return value[rear];
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (rear > front) {
            for (int i = front; i <= rear; i++) {
                if (i == rear) {
                    sb.append(value[i]);
                } else {
                    sb.append(value[i] + ", ");
                }
            }
        } else {
            for (int i = front; i < maxSize; i++) {
                    sb.append(value[i]+", ");
            }
            for (int i = 0; i <=rear ; i++) {
                if (i == rear) {
                    sb.append(value[i]);
                } else {
                    sb.append(value[i] + ", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
