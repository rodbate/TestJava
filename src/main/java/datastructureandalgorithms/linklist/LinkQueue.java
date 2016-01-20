package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class LinkQueue {

    private FirstLastList list;

    public LinkQueue () {
        list = new FirstLastList();
    }

    public LinkQueue insert(int key){
        list.insertLast(key, 0);
        return this;
    }

    public int remove(){
        return list.removeFirst().getIData();
    }

    public void display(){
        list.display();
    }
}

class LinkQueueApp{

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.insert(2).insert(12).insert(1).insert(22).display();
        System.out.println(queue.remove());
        queue.display();
    }
}