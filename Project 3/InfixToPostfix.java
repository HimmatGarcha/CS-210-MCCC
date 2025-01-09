import java.util.Stack;

class InfixToPostfix {
    // Higher returned value aka return higher precedence
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If scanned character is an operand added to output.
            if (Character.isLetterOrDigit(c))
                result += c;

            // If the scanned character is an '(', push to the stack.
            else if (c == '(')
                stack.push(c);

            // If the scanned character is an ')', pop + output from the stack until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; 
                else
                    stack.pop();
            } else { // an operator is encountered
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
        }

        // pop all  operators from the stack
        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }
}
