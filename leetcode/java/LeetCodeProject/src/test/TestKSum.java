package test;

import java.util.List;

import org.junit.Test;

import app.KSum;

import static org.junit.Assert.assertEquals;

import java.util.*;

public class TestKSum {

    private KSum kSum = new KSum();

    @Test
    public void testTwoSum() {

        int[] nums = { -2, -1, 0, 0, 1, 2 };
        int target = 0;

        List<List<Integer>> result = kSum.twoSum(nums, target, 0);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();

        List<Integer> inExpected = new ArrayList<Integer>();
        inExpected.add(-2);
        inExpected.add(2);
        expected.add(inExpected);

        inExpected = new ArrayList<Integer>();
        inExpected.add(-1);
        inExpected.add(1);
        expected.add(inExpected);

        inExpected = new ArrayList<Integer>();
        inExpected.add(0);
        inExpected.add(0);
        expected.add(inExpected);

        assertEquals(expected, result);
    }

}
