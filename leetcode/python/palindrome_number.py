# https://leetcode.com/problems/palindrome-number/

class Solution:
    def isPalindrome(self, x: int) -> bool:
        
        if x < 0:
            return False
        
        stack = []
        
        in_x = x
        
        while in_x > 0:
            
            rem = in_x % 10
            in_x = in_x // 10
            stack.append(rem)
        
        in_x = x
        
        while in_x > 0:
            
            rem = in_x % 10
            in_x = in_x // 10
            
            if stack.pop() != rem:
                return False
        
        return True
    
    
