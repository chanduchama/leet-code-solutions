package com.leetcode.solutions;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum towSum = new TwoSum();
        int[] array = {1,4,34,5,6};
        int[] indexes = towSum.twoSum(array,35);

        System.out.println(indexes[0]+1);
        System.out.println(indexes[1]+1);
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> integerMap = createMap(nums);

        int[] indexes = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            int difference = target - number;

            if(integerMap.containsKey(difference) && integerMap.get(difference)!=i){
                indexes[0] = i;
                indexes[1] = integerMap.get(difference);
                break;
            }
        }

        return indexes;

    }

    private Map<Integer, Integer> createMap(int[] integers) {
        Map<Integer,Integer> integerMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < integers.length; i++) {
            Integer number = integers[i];
            integerMap.put(number, i);
        }
        return integerMap;
    }

}
