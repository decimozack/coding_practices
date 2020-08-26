# https://leetcode.com/problems/regular-expression-matching/

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        # if pattern is empty but str is not, the str does not match the pattern
        if not p:
            return not s
        
        # first we check if str is empty. if it is empty and there is a pattern, 
        # the char does not match
        char_match = bool(s) and p[0] in (s[0], '.')
        
        # we check if the next character is a * if it is, we will skip the curr char and the * char and see
        # if the following pattern matches the curr char. if they do, it is possible the (curr_char *) pattern will 
        # have zero matches. Or if the next pattern does not match the curr char, we will see if the next char matches the
        # (curr_char *)
        if len(p) > 1 and p[1] == '*':
            return (self.isMatch(s, p[2:]) or (char_match and self.isMatch(s[1:], p)))
        else: 
            # this is for normal scenario without *. 
            # For the normal scenario we just compare pattern 
            # and str char by char
            return char_match and self.isMatch(s[1:], p[1:])
