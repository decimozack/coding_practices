# https://leetcode.com/problems/container-with-most-water/

from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        
        def find_max_area(height: List[int], left_idx: int, right_idx: int) -> int:
            
            if right_idx - left_idx == 0:
                return -1
            
            curr_area = min(height[left_idx], height[right_idx]) * (right_idx - left_idx)
            
            inner_area = -1
            
            if height[left_idx] <= height[right_idx]:
                inner_area = find_max_area(height, left_idx + 1, right_idx)
            else:
                inner_area = find_max_area(height, left_idx, right_idx - 1)
                
            return max(curr_area, inner_area)
    
        return find_max_area(height, 0, len(height) - 1)
