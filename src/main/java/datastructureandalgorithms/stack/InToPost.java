package datastructureandalgorithms.stack;

/**
 * Created by rod bate on 2016/1/20.
 */
public class InToPost {

    private StackChar stack;
    private int stackSize;
    private String input;
    private String output = "";

    public InToPost(String in){
        input = in;
        stackSize = input.length();
        stack = new StackChar(stackSize);
    }

    public String doTrans(){
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            switch (c) {
                case '+':
                case '-':
                    gotOperator(c, 1);
                    break;
                case '/':
                case '*':
                    gotOperator(c, 2);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    gotParen();
                    break;
                default:
                    output = output + c;
                    break;
            }
        }

        while (!stack.isEmpty()) {
            output = output + stack.pop();
        }

        return output;
    }

    private void gotParen() {
        char ch;
        while (!stack.isEmpty()) {
            ch = stack.pop();
            if (ch == '(') {
                break;
            } else {
                output = output + ch;
            }
        }
    }

    private void gotOperator(char c, int prec1) {
        char onTop;
        int prec2;
        while(!stack.isEmpty()){
            onTop = stack.pop();
            if (onTop == '(') {
                stack.push(onTop);
                break;
            } else {
                if (onTop == '+' || onTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    stack.push(onTop);
                    break;
                } else {
                    output = output + onTop;
                }
            }
        }
        stack.push(c);
    }
}
