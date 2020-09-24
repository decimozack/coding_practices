// https://leetcode.com/problems/4sum/
package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        if (nums.length < 4 || nums[0] * 4 > target || target > nums[nums.length - 1] * 4) {
            return result;
        }

        int aIdx = 0, bIdx = 1, cIdx = nums.length - 2, dIdx = nums.length - 1, sum = 0;

        for (int i = 0; i < nums.length - 3; i++) {

            aIdx = i;
            if (i > 0 && nums[aIdx] == nums[aIdx - 1]) {
                continue;
            }

            for (int d = nums.length - 1; d > i + 2; d--) {
                dIdx = d;

                if (d < nums.length - 1 && nums[dIdx] == nums[dIdx + 1]) {
                    continue;

                }

                bIdx = aIdx + 1;
                cIdx = dIdx - 1;

                while (bIdx < cIdx) {

                    sum = nums[aIdx] + nums[bIdx] + nums[cIdx] + nums[dIdx];

                    if (sum == target) {
                        List<Integer> inResult = new ArrayList<Integer>();

                        inResult.add(nums[aIdx]);
                        inResult.add(nums[bIdx]);
                        inResult.add(nums[cIdx]);
                        inResult.add(nums[dIdx]);

                        result.add(inResult);

                        while (bIdx < cIdx) {

                            if (nums[bIdx] == nums[bIdx + 1]) {
                                bIdx++;
                            } else {
                                break;
                            }
                        }

                        while (bIdx < cIdx) {

                            if (nums[cIdx] == nums[cIdx - 1]) {
                                cIdx--;
                            } else {
                                break;
                            }
                        }

                        if (nums[bIdx] == nums[cIdx]) {
                            break;
                        }

                    }

                    if (sum > target) {
                        cIdx--;
                    } else {
                        bIdx++;
                    }
                }
            }

        }

        // HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);
        // result.clear();
        // result.addAll(set);
        return result;
    }

}

