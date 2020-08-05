#!/usr/bin/python3
#https://leetcode.com/problems/median-of-two-sorted-arrays/
from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
 
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)

        total = len(nums1) + len(nums2)
        is_even = total % 2 == 0
        number_elems = int((total + 1) / 2)
        
        small_list = nums1
        big_list = nums2
        
        start = 0
        end = len(nums1)

        while start <= end:

            small_list_elems = (end + start) // 2
            big_list_elems = number_elems - small_list_elems

            sml = small_list[small_list_elems - 1] if small_list_elems - 1 >= 0 else None
            sml_1 = small_list[small_list_elems] if small_list_elems < len(small_list) else None
            bl = big_list[big_list_elems - 1] if big_list_elems - 1 >= 0  else None
            bl_1 = big_list[big_list_elems] if big_list_elems < len(big_list) else None
            
            if sml is not None and bl is not None and sml >= bl:

                # case 1.2 and 1.3
                if bl_1 is None or sml <= bl_1:
                    if is_even:
                        return (sml + bl_1) / 2 if sml_1 is None or (bl_1 is not None and bl_1 <= sml_1) else (sml + sml_1) / 2
                    else:
                        return sml
                else:
                # case 1.3
                    end = small_list_elems - 1
                    continue
            # in the case were all elements are select from the small list
            elif sml is not None and bl is None:
                if sml > bl_1:
                    end = small_list_elems - 1
                    continue

                if is_even:
                    return (sml + bl_1) / 2 if sml_1 is None or bl_1 <= sml_1 else (sml + sml_1) / 2
                else:
                    return sml
            elif bl is not None and sml is not None and sml <= bl:
                # case 2.2 and 2.3
                if sml_1 is None or bl <= sml_1: 
                    if is_even:
                        return (sml_1 + bl) / 2 if bl_1 is None or (sml_1 is not None and sml_1 <= bl_1) else (bl + bl_1) / 2
                    else:
                        return bl
                # case 2.1
                else:
                    start = small_list_elems + 1
            elif bl is not None and sml is None:
                if sml_1 is None or bl > sml_1:
                    start = small_list_elems + 1
                
                if sml_1 is None or bl <= sml_1:
                    if is_even:
                        return (sml_1 + bl) / 2 if bl_1 is None or (sml_1 is not None and sml_1 <= bl_1) else (bl + bl_1) / 2
                    else:
                        return bl
        return 0
            
