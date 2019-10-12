package com.leetcode.solutions.all;

/***
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Leet code problem statement 4
 * Median of two sorted arrays
 */
public class Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeArrays(nums1, nums2);
        int totalLength = mergedArray.length ;
        double median = 0;
        if(totalLength%2 == 0) {
            int firstIndex = totalLength/2;
            int secondIndex = firstIndex+1;
            double sum = mergedArray[firstIndex-1] + mergedArray[secondIndex-1];
            median = sum/2;
        } else {
            int firstIndex = (totalLength/2)+1;
            median = mergedArray[firstIndex-1];
        }
        return median;
    }

    private int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length+array2.length];

        boolean merged = false;
        int index1 = 0;
        int index2 = 0;
        int mergedIndex = 0;
        while (!merged) {
            if(index1 < array1.length && index2 < array2.length) {
                if(array1[index1] <= array2[index2]) {
                    mergedArray[mergedIndex++] = array1[index1++];
                } else {
                    mergedArray[mergedIndex++] = array2[index2++];
                }
            } else if(index1 < array1.length) {
                mergedArray[mergedIndex++] = array1[index1++];
            } else if(index2 < array2.length) {
                mergedArray[mergedIndex++] = array2[index2++];
            } else {
                merged = true;
            }
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        Median median = new Median();
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        double medianValue = median.findMedianSortedArrays(num1, num2);
        System.out.println(medianValue);
    }

}
