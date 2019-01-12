package FirstSection;

import java.util.Scanner;
import java.util.Stack;
/**
 * % java InfixToPostfix
 *  *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  *  [Ctrl-d]
 *  *  2 3 4 + 5 6 * * +
 *  *
 *  *  % java InfixToPostfix | java EvaluatePostfix
 *  *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  *  [Ctrl-d]
 *  *  212
 * */

public class InfixToPostFix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("This is your show time");
            Stack<Character> stack = new Stack<>();
            String line = scanner.nextLine().trim();
            String string = "";
            if (line.equals("break")) break;
            for (int i = 0; i < line.length(); i++) {

                Character character = line.charAt(i);
                if (character == '(')
                    stack.push('(');
                else if (character == ')'){
                    while (!stack.isEmpty()) {
                        if (stack.peek() != '('){
                            string += stack.pop();
                        }else {
                            stack.pop();
                            break;
                        }

                    }
                }else if (character == '+'){
                    stack.push('+');
                }else if (character == '-'){
                    stack.push('-');
                }else if (character == '*'){
                    stack.push('*');
                }else if (character == '/'){
                    stack.push('/');
                }else {
                    string += character;
                }

            }

            System.out.println(string);
        }
    }
}
