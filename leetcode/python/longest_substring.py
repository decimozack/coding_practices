#!/usr/bin/python3
# https://leetcode.com/problems/longest-substring-without-repeating-characters/ 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
       
        exist_dict = {}
        start_idx = 0
        long_sub = 0
        
        for idx, ch in enumerate(s):

            if ch in exist_dict:
                
                if exist_dict[ch] >= start_idx:
                    long_sub = max(long_sub, idx - start_idx)
                    start_idx = exist_dict[ch] + 1

            exist_dict[ch] = idx
            
        s_len = len(s)
        if s_len - start_idx > long_sub:
            long_sub = s_len - start_idx

        return long_sub
