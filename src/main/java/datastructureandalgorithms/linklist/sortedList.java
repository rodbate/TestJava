package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class SortedList {

    private Link first;

    public SortedList(){
        first = null;
    }

    public SortedList insert(int key){
        Link newLink = new Link(key, 0);
        Link previous = null;
        Link current = first;
        while (current != null && key > current.getIData()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            first = newLink;
        } else {
            previous.setNext(newLink);
        }
        newLink.setNext(current);
        return this;
    }

    public int remove(){
        int i = 0;
        if (first != null) {
            i = first.getIData();
            first = first.getNext();
        }
        return i;
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

class SortedListApp{

    public static void main(String[] args) {

        SortedList list = new SortedList();
        list.insert(2).insert(1).insert(11).insert(3).insert(9).display();
        System.out.println(list.remove());
        list.remove();
        list.display();

    }
}
