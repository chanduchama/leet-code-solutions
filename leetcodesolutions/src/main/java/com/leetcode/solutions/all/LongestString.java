package com.leetcode.solutions.all;

import java.util.HashSet;
import java.util.Set;

/***
 * Leet code problem statement 3
 * Logic: Need to use sliding window in the array logic
 */
public class LongestString {

    public int lengthOfLongestSubstring(String s) {
        System.out.println("input string is: " + s);

        int max = 0;
        int start = 0;
        int end = 0;
        int stringLength = s.length();
        Set<Character> hashSet = new HashSet<Character>();

        while(start < stringLength && end < stringLength) {

            Character character = s.charAt(end);
            if(!hashSet.contains(character)) {
                hashSet.add(character);
                end++;
                max = Math.max(max, end-start);
            } else {
                hashSet.remove(s.charAt(start++));
            }

        }

        return max;
    }

    public static void main(String[] args) {
        LongestString longestString = new LongestString();
        int length = longestString.lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }

}
