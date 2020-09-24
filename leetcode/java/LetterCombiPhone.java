// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
package app;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombiPhone {

    private Map<String, String> keyboard;
    private List<String> output;

    public LetterCombiPhone() {
        keyboard = new HashMap<String, String>();
        keyboard.put("2", "abc");
        keyboard.put("3", "def");
        keyboard.put("4", "ghi");
        keyboard.put("5", "jkl");
        keyboard.put("6", "mno");
        keyboard.put("7", "pqrs");
        keyboard.put("8", "tuv");
        keyboard.put("9", "wxyz");

        output = new ArrayList<String>();
    }

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        dfs("", digits, 0);

        return output;
    }

    public void dfs(String combination, String digits, int digitIdx) {

        if (digits.length() == digitIdx) {
            output.add(combination);
            return;
        }

        char currDigit = digits.charAt(digitIdx);

        String key = keyboard.get(String.valueOf(currDigit));

        for (int i = 0; i < key.length(); i++) {

            dfs(combination + key.charAt(i), digits, digitIdx + 1);
        }
    }
}
