package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class LinkStackApp {

    public static void main(String[] args) {

        LinkStack linkStack = new LinkStack();
        linkStack.push(1).push(2).push(3).push(4).display();
        System.out.println(linkStack.pop());
        linkStack.display();

    }
}
