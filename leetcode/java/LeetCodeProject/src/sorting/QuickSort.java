package sorting;

public class QuickSort {

    public int[] quickSortNum(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {

        if (start < 0 || end >= nums.length || start >= end) {
            return;
        }
        int endVal = nums[end];
        int smallIdx = start;

        for (int i = start; i < end; i++) {

            if (nums[i] < endVal) {
                int temp = nums[smallIdx];
                nums[smallIdx] = nums[i];
                nums[i] = temp;
                smallIdx++;
            }
        }

        int temp = nums[smallIdx];
        nums[smallIdx] = endVal;
        nums[end] = temp;

        quickSort(nums, start, smallIdx - 1);
        quickSort(nums, smallIdx + 1, end);

    }

}
