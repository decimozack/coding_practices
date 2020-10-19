// https://leetcode.com/problems/4sum/
package app;

import java.util.*;

public class KSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {

        Arrays.sort(nums);
        return kSum(nums, target, 0, 3);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int startIdx, int k) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length < k || nums[startIdx] * k > target || nums[nums.length - 1] * k < target) {
            return result;
        }

        if (k == 2) {
            return twoSum(nums, target, startIdx);
        }

        for (int i = startIdx; i < nums.length - k + 1; i++) {

            if (i == startIdx || nums[i] != nums[i - 1]) {
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    List<Integer> inResult = new ArrayList<Integer>();
                    inResult.add(nums[i]);
                    inResult.addAll(set);
                    result.add(inResult);
                }
            }
        }

        return result;

    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {

        int end = nums.length - 1;
        int sum = 0;

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        while (start < end) {

            sum = nums[start] + nums[end];
            if (sum == target) {
                List<Integer> inResult = new ArrayList<Integer>();
                inResult.add(nums[start]);
                inResult.add(nums[end]);
                result.add(inResult);

                while (start < end) {
                    if (nums[start] == nums[start + 1]) {
                        start++;
                    } else {
                        break;
                    }
                }

                while (start < end) {
                    if (nums[end] == nums[end - 1]) {
                        end--;
                    } else {
                        break;
                    }
                }
            }

            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}
