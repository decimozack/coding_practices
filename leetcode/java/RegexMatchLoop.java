// https://leetcode.com/problems/regular-expression-matching/submissions/
// this code is different from RegexMatch.java
// This code checks backwards. if the curr character matches, we will check if the string before this
// character matches with the pattern.
class Solution {
    public boolean isMatch(String s, String p) {
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for(int in = 1; in <= p.length(); in++) {
            if (p.charAt(in - 1) == '*')
                dp[0][in] = dp[0][in - 2];
        }
       for(int out = 1; out <= s.length(); out++) {
           
           for(int in = 1; in <= p.length(); in++) {
               
               boolean charMatch = (s.charAt(out - 1) == p.charAt(in - 1) || p.charAt(in - 1) == '.');
               if (charMatch) {
                   dp[out][in] = dp[out - 1][in - 1];
                   continue;
               } 
               if (p.charAt(in - 1) == '*') {
                  
                  dp[out][in] = dp[out][in - 2]; 
                  if (s.charAt(out - 1) == p.charAt(in - 2) || p.charAt(in - 2) == '.') {
                      dp[out][in] = dp[out][in] || dp[out - 1][in];
                  } 
                  
                  
               }
           }
       }
       
        return dp[s.length()][p.length()];
                   
    }
                   
}
