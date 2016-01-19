package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/19.
 */
public class BracketChecker {


    public static void check(String str){

        StackChar stackChar = new StackChar(str.length());
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            switch (ch) {
                case '{' :
                case '[' :
                case '(' : stackChar.push(ch); break;
                case ')' :
                    if (stackChar.pop() != '(') System.out.println("missing the left small bracket ("); break;
                case ']' :
                    if (stackChar.pop() != '[') System.out.println("missing the left square bracket ["); break;
                case '}' :
                    if (stackChar.pop() != '{') System.out.println("missing the left  bracket {"); break;
                default : break;
            }
        }

        if (!stackChar.isEmpty()) {
            System.out.println("missing the right bracket");
        }
    }
}
