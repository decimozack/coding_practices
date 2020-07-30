#!/usr/bin/python3
#https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        if len(nums1) == 0 and len(nums2) == 0:
            return 0

        if len(nums1) == 1 and len(nums2) == 1:
            return (nums1[0] + nums2[0]) / 2

        
        total = len(nums1) + len(nums2)

        is_even = total % 2 == 0
        
        if total % 2 == 0:
            number_elems = int(total / 2)
        else:
            number_elems = int((total + 1) / 2)
        
        small_list = nums1
        big_list = nums2
        
        if len(nums1) > len(nums2):
            small_list = nums2
            big_list = nums1
        
        max_num = min_num = 0
       
       # setting the max number of elements we need from small list
        if len(small_list) >= number_elems:
            max_num = number_elems
        else:
            max_num = len(small_list)
        
        # setting the min number of elements we need from the small list
        if len(big_list) - number_elems >= 0:
            min_num = 0
        else:
            min_num = number_elems - len(big_list)
        
       
        start = min_num
        end = max_num

        while start <= end:
           
            if start == 0 and end == 1:
                small_list_elems = 1
            else :
                small_list_elems = (end + start) // 2
            big_list_elems = number_elems - small_list_elems

            sml = small_list[small_list_elems - 1] if small_list_elems - 1 >= 0 else None
            sml_1 = small_list[small_list_elems] if small_list_elems < len(small_list) else None
            bl = big_list[big_list_elems - 1] if big_list_elems - 1 >= 0  else None
            bl_1 = big_list[big_list_elems] if big_list_elems < len(big_list) else None

            
            if sml and bl and sml >= bl:
                # case 1.2 and 1.3
                if bl_1 is None or sml <= bl_1:
                    if is_even:
                        return (sml + bl_1) / 2 if bl_1 else (sml + sml_1) / 2
                    else:
                        return sml
                else:
                # case 1.3
                    end = small_list_elems - 1
                    continue
            # in the case were all elements are select from the small list
            elif sml and bl is None:
                if is_even:
                    return (sml + sml_1) / 2
                else:
                    return sml
            elif bl and sml and sml < bl:
                # case 2.2 and 2.3
                if sml_1 is None or bl <= sml_1: 
                    if is_even:
                        return (sml_1 + bl) / 2 if sml_1 else (bl + bl_1) / 2
                    else:
                        return bl
                # case 2.1
                else:
                    start = small_list_elems + 1

        return 0
            
