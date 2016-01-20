package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/20.
 */
public class ParsePost {

    private StackX stack;
    private String input;

    public ParsePost(String in){
        input = in;
        stack = new StackX(input.length());
    }

    public int calculate(){
        int num1, num2, result = 0;
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                stack.push((c - '0'));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (c) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        result = 0;
                        break;
                }
                stack.push(result);
            }
        }
        return result;
    }
}
