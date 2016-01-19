package datastructureandalgorithms.queue;

/**
 * Created by rod bate on 2016/1/19.
 */
public class PriorityQueue {

    private int[] value;
    private int maxSize;
    private int nItems;

    public PriorityQueue(int size){
        maxSize = size;
        value = new int[maxSize];
        nItems = 0;
    }

    public PriorityQueue insert(int key){
        if (nItems == 0) {
            value[nItems++] = key;
        } else {
            int i;
            for (i = nItems - 1; i >= 0; i--) {
                if (value[i] < key) {
                    value[i + 1] = value[i];
                } else {
                    break;
                }
            }
            value[i + 1] = key;
            nItems++;
        }
        return this;
    }

    public PriorityQueue remove(){
        nItems--;
        return this;
    }

    public int peekMin(){
        return value[nItems - 1];
    }

    public int peekMax(){
        return value[0];
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
        for (int i = nItems - 1; i >= 0 ; i--) {
            if (i == 0) {
                sb.append(value[i]);
            } else {
                sb.append(value[i] + ", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
