package fiveyearscodinginterview;

import java.util.Stack;

/**
 * Check if a String of Parentheses, Brackets, and Braces is Valid
 */
public class ValidParentheses {

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            }

            switch (c) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String valid = "(){{}}[]";
        String invalid = "()[}[]";

        System.out.println("ValidParentheses: " + isValid(valid));
        System.out.println("InvalidParentheses: " + isValid(invalid));
    }
}
