package test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import sorting.MergeSort;
import sorting.QuickSort;

public class TestSorting {

    private MergeSort mergeSort = new MergeSort();
    private QuickSort quickSort = new QuickSort();

    @Test
    public void testMergeSort() {

        int[] givenArr = new int[] { 5, 4, 3, 2, 1 };
        int[] result = mergeSort.mergeSortNums(givenArr);
        int[] expected = new int[] { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, result);

        givenArr = new int[] { -10, 100, 20, -20, 1, 0 };
        result = mergeSort.mergeSortNums(givenArr);
        expected = new int[] { -20, -10, 0, 1, 20, 100 };
        assertArrayEquals(expected, result);

        givenArr = new int[] { 12, 11, 13, 5, 6, 7 };
        result = mergeSort.mergeSortNums(givenArr);
        expected = new int[] { 5, 6, 7, 11, 12, 13 };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort() {

        int[] givenArr = new int[] { 5, 4, 3, 2, 1 };
        int[] result = quickSort.quickSortNum(givenArr);

        int[] expected = new int[] { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, result);

        givenArr = new int[] { -10, 100, 20, -20, 1, 0 };
        result = quickSort.quickSortNum(givenArr);
        expected = new int[] { -20, -10, 0, 1, 20, 100 };
        assertArrayEquals(expected, result);

        givenArr = new int[] { 12, 11, 13, 5, 6, 7 };
        result = quickSort.quickSortNum(givenArr);
        expected = new int[] { 5, 6, 7, 11, 12, 13 };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort2() {
        int[] input = new int[] { 6, 1, 7, 9, 3, 8, 2, 5, 4, 0 };

        int[] actuals = quickSort.quickSortNum(input);
        Arrays.sort(input);
        int[] expecteds = input;
        assertArrayEquals(expecteds, actuals);

    }
}
