package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/20.
 */

public class InToPostApp {

    public static void main(String[] args) {

        String str = "(1+2)*3+2*6-1";
        InToPost inToPost = new InToPost(str);
        System.out.println(inToPost.doTrans());

        ParsePost parsePost = new ParsePost(inToPost.doTrans());
        System.out.println(parsePost.calculate());

    }
}
