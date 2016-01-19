package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/19.
 */
public class StringReverse {

    public static String reverse(String str){
        str = str.trim();
        StackChar stackChar = new StackChar(str.length());
        char[] target = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            stackChar.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            target[i] = stackChar.pop();
        }
        return new String(target);
    }
}
