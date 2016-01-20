package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class LinkList {

    private Link first;

    public LinkList(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public LinkList insertFirst(int i, double d){
        Link newLink = new Link(i, d);
        newLink.setNext(first);
        first = newLink;
        return this;
    }


    public Link deleteFirst(){
        Link temp = first;
        first = first.getNext();
        return temp;
    }

    public Link find(int key){
        Link current = first;
        while (current.getIData() != key) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current;
    }

    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (current.getIData() != key) {
            if (current.getNext() == null) {
                return null;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (current == first) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
        return current;
    }

    public LinkList insertAfter(int key,Link link){
        Link current = find(key);
        if (current != null) {
            link.setNext(current.getNext());
            current.setNext(link);
        }
        return this;
    }

    public LinkList insertBefore(int key, Link link){
        Link current = first;
        Link previous = first;
        while (current.getIData() != key) {
            if (current.getNext() == null) {
                current = null;
                break;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (current != null){
            if (current == first) {
                first = link;
                link.setNext(current);
            } else {
                previous.setNext(link);
                link.setNext(current);
            }
        }
        return this;
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
