#!/usr/bin/python3
# https://leetcode.com/problems/two-sum

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        orig_dict = {}
        for i in range(0, len(nums)):
            
            curr_num = nums[i]    
            if target - curr_num in orig_dict:
                return [orig_dict[target - curr_num], i]
            else:
                orig_dict[curr_num] = i

