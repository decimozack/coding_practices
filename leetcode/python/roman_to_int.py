# https://leetcode.com/problems/roman-to-integer/

class Solution:
    def romanToInt(self, s: str) -> int:
        
        result = 0    
        idx = 0
        s_len = len(s)
        
        roman_dict = {
            'M': 1000,
            'CM': 900,
            'D': 500,
            'CD': 400,
            'C': 100,
            'XC': 90,
            'L': 50,
            'XL': 40,
            'X': 10,
            'IX': 9,
            'V': 5,
            'IV': 4,
            'I': 1
        }
        
        while idx < s_len:
            
            result += roman_dict.get(s[idx: idx + 2], roman_dict[s[idx]])
            
            if roman_dict.get(s[idx: idx + 2], None):
                idx += 2
            else:
                idx += 1
        return result
