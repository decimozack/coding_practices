package sorting;

public class BubbleSort {

    public void bubbleSort(int[] nums) {

        int end = nums.length;

        while (end > 0) {

            for (int i = 0; i < end - 1; i++) {

                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }

            end--;

        }
    }
}
