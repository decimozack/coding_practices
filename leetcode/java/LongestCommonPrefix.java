// https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        int index = first.length() - 1;
        int found = -1;
        
        for(int i = 1; i < strs.length; i++) {
          
            while (index >= 0) {
                found = strs[i].indexOf(first.substring(0, index + 1));
                if (found == 0) {
                    break;
                } else {
                    index--;
                }
            }
        }
        
        if (index < 0) {
            return "";
        } else {
            return first.substring(0,index + 1);
        }
    }
}
