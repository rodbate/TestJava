package datastructureandalgorithms.linklist.doublylink;

/**
 * Created by rod bate on 2016/1/21.
 */
public class DoublyLink {

    private Link first;
    private Link last;

    public DoublyLink(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public DoublyLink insertFirst(int data){
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            newLink.setNext(first);
            first.setPrevious(newLink);
            first = newLink;
        }
        return this;
    }

    public DoublyLink insertLast(int data){
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
            last = newLink;
        }
        return this;
    }

    public DoublyLink insertAfter(int key, int data){
        Link newLink = new Link(data);
        Link current = first;
        while (current != null && current.getData() != key) {
            current = current.getNext();
        }
        if (current != null) {
            if (current == last) {
                current.setNext(newLink);
                newLink.setPrevious(current);
                last = newLink;
            } else {
                newLink.setNext(current.getNext());
                current.getNext().setPrevious(newLink);
                newLink.setPrevious(current);
                current.setNext(newLink);
            }
        }
        return this;
    }

    public DoublyLink deleteFirst(){
        if (first.getNext() != null) {
            first.getNext().setPrevious(null);
            first = first.getNext();
        } else {
            first = null;
            last = null;
        }
        return this;
    }

    public DoublyLink deleteLast(){
        if (last.getPrevious() != null) {
            last.getPrevious().setNext(null);
            last = last.getPrevious();
        } else {
            first = null;
            last = null;
        }
        return this;
    }

    public DoublyLink deleteKey(int key){
        Link current = first;
        while (current != null && current.getData() != key) {
            current = current.getNext();
        }
        if (current != null) {
            /*if (current == first && current.getNext() != null) {
                first.getNext().setPrevious(null);
                first = first.getNext();
            } else if (current == first && current.getNext() == null) {
                first = null;
                last = null;
            } else if (current == last && current.getPrevious() != null) {
                last.getPrevious().setNext(null);
                last = last.getPrevious();
            } else if (current == last && current.getPrevious() == null) {
                first = null;
                last = null;
            }*/

            if (current == first) return deleteFirst();
            if (current == last) return deleteLast();
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
        return this;
    }

    public void displayForward(){
        Link current = first;
        while (current != null) {
            current.display();
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward(){
        Link current = last;
        while (current != null){
            current.display();
            current = current.getPrevious();
        }
        System.out.println();
    }

}


class DoublyLinkApp{

    public static void main(String[] args) {

        DoublyLink link = new DoublyLink();

        link.insertLast(1).insertLast(2).insertLast(3).displayForward();
        link.displayBackward();

        link.insertFirst(0).displayForward();
        link.insertAfter(3,9).displayBackward();

        link.deleteFirst().displayForward();
        link.deleteLast().displayForward();

        link.insertAfter(5,8).displayForward();

        link.deleteKey(2).displayBackward();

        /*int[] a = {1, 2, 3};
        int i;
        System.out.println(a[i = 1] + " I :" + i);*/
    }
}