package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class LinkStack {

    private LinkList linkList;

    public LinkStack(){
        linkList = new LinkList();
    }

    public LinkStack push(int key){
        linkList.insertFirst(key,0);
        return this;
    }

    public int pop(){
        return linkList.deleteFirst().getIData();
    }

    public void display(){
        linkList.display();
    }
}
