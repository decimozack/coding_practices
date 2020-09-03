// https://leetcode.com/problems/regular-expression-matching/
import java.util.HashMap;
/*
Case 
s = "hht"
p = ".*h.*P"
In this case we will see that the checkList is being used
The checkList will only be trigger for false cases
*/
class Solution {
    public boolean isMatch(String s, String p) {
        
        int[][] checkList = new int[s.length() + 1][p.length() + 1]; 
        return isMatchRecur(s, p, 0, 0, checkList);
    }
    
    public boolean isMatchRecur(String s, String p, int sIndex, int pIndex, int[][] checkList) {
        
        if (checkList[sIndex][pIndex] != 0) {
            // sample print to check for use of mnemonic list
            // System.out.println("here with index: sIndex = " + sIndex + " pIndex = " + pIndex);
            return checkList[sIndex][pIndex] == 1;
        }
        boolean answer = false;
        
        if (p.length() <= pIndex) {
            answer = s.length() <= sIndex;
        } else { 
            boolean charMatch = s.length() != sIndex && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');

            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                answer = isMatchRecur(s, p, sIndex, pIndex + 2, checkList) || (charMatch && isMatchRecur(s, p, sIndex + 1, pIndex, checkList));
            } else {
                answer = charMatch && isMatchRecur(s, p, sIndex + 1, pIndex + 1, checkList);
            }
        }
        
        checkList[sIndex][pIndex] = answer ? 1 : -1;
        return checkList[sIndex][pIndex] == 1;
    }
}
