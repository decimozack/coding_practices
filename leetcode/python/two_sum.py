class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        back_nums = list(nums)

        nums.sort()

        start = 0
        end = len(nums) - 1

        while start < end:
            sum_start_end = nums[start] + nums[end]
            if sum_start_end == target:
                break

            if sum_start_end > target:
                end -= 1
            elif sum_start_end < target:
                start += 1

        return [back_nums.index(nums[start]), len(back_nums) - 1 - back_nums[::-1].index(nums[end])]
