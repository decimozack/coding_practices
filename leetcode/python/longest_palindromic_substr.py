#!/usr/bin/python3
# https://leetcode.com/problems/longest-palindromic-substring/
class Solution:

    def longestPalindrome(self, s: str) -> str:

        lg_str = ''
        lg_count = 0
        str_len = len(s)
        
        for idx, char in enumerate(s):
            
            # check for odd palindrome
            curr_str = self.odd_palindrome(s, idx, str_len)
            
            if len(curr_str) > lg_count:
                lg_str = curr_str
                lg_count = len(curr_str)
            # check of even palindrome
            curr_str = self.even_palindrome(s, idx, str_len)
            
            if len(curr_str) > lg_count:
                lg_str = curr_str
                lg_count = len(curr_str)
        
        return lg_str
    
    def odd_palindrome(self, s: str, idx: int, str_len: int) -> str:
        
        is_palin = True
        start = end = idx
        count = 1
        while is_palin:
            if idx - count >= 0 and idx + count < str_len:
                if s[idx - count] == s[idx + count]:
                    start = idx - count
                    end = idx + count
                    count = count + 1
                else:
                    is_palin = False
            else:
                is_palin = False
        
        return s[start:end + 1]
            
    def even_palindrome(self, s: str, idx: int, str_len: int) -> str:
        
        is_palin = True
        start = end = idx
        count = 1
        
        if idx - 1 >= 0 and s[idx - 1] != s[idx]:
            return ''
        else:
            start = idx - 1
            end = idx
                
        while is_palin:
            
            if idx - count - 1 >= 0 and idx + count < str_len:
                
                if s[idx - count - 1] == s[idx + count]:
                    start = idx - count - 1
                    end = idx + count
                    count = count + 1
                    
                else:
                    is_palin = False
            else:
                is_palin = False
        
        return s[start:end + 1]
