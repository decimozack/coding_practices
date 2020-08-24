# https://leetcode.com/problems/string-to-integer-atoi/

INT_MAX = 2147483647
INT_MIN = -2147483648

class Solution:
    def myAtoi(self, str: str) -> int:
        
        str = str.strip()
        if len(str) == 0 or (self.switch_case(str[0])) is None:
            return 0
            
        sign = 11
        power = 0
        result = 0
        curr_num = 0
        
        for char in str:
            
            curr_num = self.switch_case(char)            
            if curr_num is None or (curr_num in (11, 12) and power != 0):
                break            
            if result > (INT_MAX // 10) or (result == (INT_MAX // 10) and curr_num > (INT_MAX % 10)):           
                if sign == 11:
                    return INT_MAX
                else:
                    return INT_MIN
            
            if curr_num in (11, 12):
                sign = curr_num
            else:            
                result = curr_num + (result * 10)
            power += 1
            
        if sign == 12:
            return result * (-1)
        
        return result
    
    
    def switch_case(self, key) -> int:
        
        switch_cond = {
            '1': 1,
            '2': 2,
            '3': 3,
            '4': 4,
            '5': 5,
            '6': 6,
            '7': 7,
            '8': 8,
            '9': 9,
            '0': 0,
            '+': 11,
            '-': 12, 
        }
        return switch_cond.get(key, None)
            
            
        
        
