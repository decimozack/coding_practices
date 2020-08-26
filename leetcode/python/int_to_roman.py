# https://leetcode.com/problems/integer-to-roman/

class Solution:
    def intToRoman(self, num: int) -> str:
        
        digit_arr = []
        
        while num > 0:
            
            digit_arr.append(num % 10)
            num = num // 10
            
        roman_chars = {
            0: ['I', 'V', 'IV', 'IX'],
            1: ['X', 'L', 'XL', 'XC'],
            2: ['C', 'D', 'CD' ,'CM'],
            3: ['M']
        }
        
        def convert_roman(curr_digit: int, tenths: int, roman_chars) -> str:
            
            curr_list = roman_chars[tenths]
            curr_roman = ''
            
            if curr_digit == 4:
                return curr_list[2]
            elif curr_digit == 9:
                return curr_list[3]
            elif curr_digit == 0:
                return ''
            if curr_digit < 4:
                for i in range(curr_digit):
                    curr_roman += curr_list[0]
            elif curr_digit >= 5:
                curr_roman = curr_list[1]
                for i in range(curr_digit - 5):
                    curr_roman += curr_list[0]
            
            return curr_roman
        
        roman_str = ''
        count = 0
        for curr_digit in digit_arr:
            
            roman_str = convert_roman(curr_digit, count, roman_chars) + roman_str
            count += 1
        
        return roman_str
