// https://leetcode.com/problems/3sum/
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        int sum = 0;
        int bIndex = 0;
        int cIndex = nums.length - 1;
        int target = 0;
        
        for (int outerIdx = 0; outerIdx < nums.length; outerIdx++) {

            bIndex = outerIdx + 1;
            cIndex = nums.length - 1;

            if (outerIdx > 0 && nums[outerIdx] == nums[outerIdx - 1]) {
                continue;
            }

            while (bIndex < cIndex) {

                sum = nums[outerIdx] + nums[bIndex] + nums[cIndex];

                if (sum == target) {
                    ArrayList<Integer> currResult = new ArrayList<Integer>();
                    currResult.add(nums[outerIdx]);
                    currResult.add(nums[bIndex]);
                    currResult.add(nums[cIndex]);
                    results.add(currResult);
                    while(bIndex < cIndex) {
                        if (nums[bIndex] == nums[bIndex + 1]) {
                            bIndex++;
                        } else {
                            break;
                        }
                    }
                
                    while(bIndex < cIndex) {
                        if (nums[cIndex] == nums[cIndex - 1]) {
                                cIndex--;
                            } else {
                                break;
                            }
                        }
                    }

                if (nums[bIndex] == nums[cIndex]) {
                    break;
                }
                

                
                
                if (sum - nums[outerIdx] <= (nums[outerIdx] * -1)) {
                    bIndex++;
                } else {
                    cIndex--;
                }
            }
        }


        return results;
        
    }
}
