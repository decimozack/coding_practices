package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                top = getCounterpart(top);
                if (top != curr) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public char getCounterpart(char input) {

        switch (input) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return ' ';
        }
    }
}
