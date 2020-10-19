package leetcode;

import java.util.Stack;
import java.util.ArrayList;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();

        generateCombination(result, n - 1, n, "", '(');

        return result;
    }

    public void generateCombination(List<String> result, int left, int right, String currStr, char currChar) {

        currStr = currStr + currChar;

        // left stands for the left brackets and right stands for the right brackets
        // if we used more right brackets, this means that it will be an invalid
        // bracket.
        // this is because the left bracket should always be used first before the right
        // bracket.
        // thus at any point of the time, left <= right will always be true for valid
        // parentheses.
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(currStr);
            return;

        } else if (left == 0 && right != 0) {
            generateCombination(result, left, right - 1, currStr, ')');
            return;
        } else if (left != 0 && right == 0) {
            return;
        } else {
            generateCombination(result, left - 1, right, currStr, '(');
            generateCombination(result, left, right - 1, currStr, ')');
        }
    }

    public boolean validParenthesis(String brackets) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < brackets.length(); i++) {

            char curr = brackets.charAt(i);
            if (curr == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (curr == '(') {
                stack.push('(');
            } else {
                return false;
            }
        }

        return true;
    }

    // the following is the more efficient method using StringBuilder.
    public List<String> generateParenthesisEff(int n) {

        List<String> result = new ArrayList<String>();
        StringBuilder build = new StringBuilder(n * 2);
        generateCombinationEff(result, n - 1, n, build, '(');

        return result;
    }

    public void generateCombinationEff(List<String> result, int left, int right, StringBuilder str, char currChar) {

        str.append(currChar);

        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(str.toString());
            return;

        } else if (left == 0 && right != 0) {
            generateCombinationEff(result, left, right - 1, str, ')');
            str.deleteCharAt(str.length() - 1);
            return;
        } else {
            generateCombinationEff(result, left - 1, right, str, '(');
            str.deleteCharAt(str.length() - 1);

            generateCombinationEff(result, left, right - 1, str, ')');
            str.deleteCharAt(str.length() - 1);

        }
    }
}