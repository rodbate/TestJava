package datastructureandalgorithms.queue;

/**
 * Created by rod bate on 2016/1/20.
 */
public class DeQueue {

    private int[] value;
    private int left;
    private int right;
    private int nItems;
    private int maxSize;

    public DeQueue(int size){
        maxSize = size;
        value = new int[maxSize];
        nItems = 0;
        left = 0;
        right = -1;
    }

    public DeQueue insertLeft(int key){
        if (nItems > 0) {
            left = maxSize - 1;
        }
        value[left] = key;
        nItems++;
        return this;
    }

    public DeQueue insertRight(int key){
        if (right == maxSize - 1) {
            right = -1;
        }
        value[++right] = key;
        nItems++;
        return this;
    }

    public int removeLeft(){
        int key;
       if (right == left) {
            key = value[right];
            right = 0;
            left = -1;
        } else {
           key = value[right--];
       }
        nItems--;
        return key;
    }

    public int removeRight(){
        int key;
        if (right > left) {
            key = value[left++];
        } else if (right == left) {
            key = value[left];
            right = 0;
            left = -1;
        } else {
            if (left == maxSize - 1) {
                key = value[left];
                left = -1;
            } else {
                key = value[left++];
            }
        }
        nItems--;
        return key;
    }

    public boolean isFull(){
        return maxSize == nItems;
    }

    public boolean isEmpty(){
        return nItems == 0;
    }
}
