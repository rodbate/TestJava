package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class FirstLastList {

    private Link first;
    private Link last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public FirstLastList insertLast(int i, double d){
        Link newLink = new Link(i, d);
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            last.setNext(newLink);
            last = newLink;
        }
        return this;
    }

    public Link removeFirst(){
        Link link = first;
        if (first.getNext() == null) {
            first = last = null;
        } else {
            first = first.getNext();
        }
        return link;
    }

    public void display(){
        Link current = first;
        while (current != null) {
            current.display();
            current = current.getNext();
        }
        System.out.println();
    }
}
