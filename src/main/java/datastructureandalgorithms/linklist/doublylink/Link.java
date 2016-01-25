package datastructureandalgorithms.linklist.doublylink;

/**
 * Created by rod bate on 2016/1/21.
 */

public class Link {

    private int data;
    private Link previous;
    private Link next;

    public Link(int d){
        data = d;
        previous = null;
        next = null;
    }

    public void display(){
        System.out.print(data + " ");
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link previous) {
        this.previous = previous;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
