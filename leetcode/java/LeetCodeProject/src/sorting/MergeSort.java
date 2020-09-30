package sorting;

public class MergeSort {

    public int[] mergeSortNums(int[] nums) {

        // return split(nums, 0, nums.length - 1);
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public int[] merge(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length + nums2.length];

        int nums1Idx = 0;
        int nums2Idx = 0;
        int resultIdx = 0;

        while (nums1Idx < nums1.length && nums2Idx < nums2.length) {

            if (nums1[nums1Idx] <= nums2[nums2Idx]) {
                result[resultIdx++] = nums1[nums1Idx++];
            } else {
                result[resultIdx++] = nums2[nums2Idx++];
            }

        }

        while (nums1Idx < nums1.length) {
            result[resultIdx++] = nums1[nums1Idx++];
        }

        while (nums2Idx < nums2.length) {
            result[resultIdx++] = nums2[nums2Idx++];
        }

        return result;
    }

    public int[] split(int[] nums, int start, int end) {

        if (start == end) {
            return new int[] { nums[start] };
        }

        int mid = (start + end) / 2;
        int[] leftSide = split(nums, start, mid);
        int[] rightSide = split(nums, mid + 1, end);

        return merge(leftSide, rightSide);

    }

    public void sort(int[] nums, int left, int right) {

        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        mergeEff(nums, left, mid, right);
    }

    public void mergeEff(int[] nums, int left, int mid, int right) {

        int leftLen = mid - left + 1;
        int rightLen = right - mid;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = nums[left + i];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = nums[mid + 1 + i];
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int resultIdx = left;

        while (leftIdx < leftLen && rightIdx < rightLen) {

            if (leftArr[leftIdx] <= rightArr[rightIdx]) {
                nums[resultIdx++] = leftArr[leftIdx++];
            } else {
                nums[resultIdx++] = rightArr[rightIdx++];
            }
        }

        while (leftIdx < leftLen) {
            nums[resultIdx++] = leftArr[leftIdx++];
        }

        while (rightIdx < rightLen) {
            nums[resultIdx++] = rightArr[rightIdx++];
        }

    }
}
