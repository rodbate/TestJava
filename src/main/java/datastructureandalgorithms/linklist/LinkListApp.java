package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class LinkListApp {

    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.insertFirst(1,22).insertFirst(2,23).insertFirst(4,33).insertFirst(5,332);

        linkList.display();
        //linkList.deleteFirst();
        //linkList.display();

        /*linkList.find(5).display();

        linkList.delete(1).display();
        System.out.println();
        linkList.display();*/

        //linkList.insertAfter(5, new Link(6, 100)).display();
        linkList.insertBefore(1, new Link(6, 100)).display();

    }
}
