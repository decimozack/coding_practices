# https://leetcode.com/problems/zigzag-conversion/
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 0:
            return ''
        elif numRows == 1:
            return s

        list_dict = {}
        curr_row_num = 1
        curr_row_list = []
        row_num_dir = 1

        for idx, char in enumerate(s):
           
            if not (curr_row_num in list_dict):
                list_dict[curr_row_num] = []

            curr_row_list = list_dict[curr_row_num]
            curr_row_list.append(char) 

            if curr_row_num == numRows:
                row_num_dir = -1
            elif curr_row_num == 1:
                row_num_dir = 1

            curr_row_num += row_num_dir

        final_list = []
        for key, value in list_dict.items():
            final_list.extend(value)

        return ''.join(final_list)
