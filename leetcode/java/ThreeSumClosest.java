// https://leetcode.com/problems/3sum-closest/

import java.util.*;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = 0;

        int sum = 0;
        int bIndex = 0;
        int cIndex = nums.length - 1;

        for (int outerIdx = 0; outerIdx < nums.length; outerIdx++) {

            bIndex = outerIdx + 1;
            cIndex = nums.length - 1;

            if (outerIdx > 0 && nums[outerIdx] == nums[outerIdx - 1]) {
                continue;
            }

            while (bIndex < cIndex) {

                sum = nums[outerIdx] + nums[bIndex] + nums[cIndex];

                if (sum == target) {
                    return sum;
                }

                if (outerIdx == 0 && bIndex == 1 && cIndex == nums.length - 1) {
                    closest = sum;

                } else {
                    if (Math.abs(target - sum) < Math.abs(target - closest)) {
                        closest = sum;
                    }
                }

                if (nums[bIndex] == nums[cIndex]) {
                    break;
                }

                if (sum < target) {
                    bIndex++;
                } else {
                    cIndex--;
                }
            }
        }

        return closest;

    }
}
