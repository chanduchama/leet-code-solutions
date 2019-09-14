package com.leetcode.solutions.all;

public class LongestPalindrome {

    /**
     * The logic to solve the longest palindrome
     * 1. first letter is equal to the last letter
     * AND
     * 2. inner word is also a palindrom
     */
    public String longestPalindrome(String word){
        int stringLength = word.length();

        int leftIndex = 0;
        int rightIndex = 0;

        boolean[][] palindromeMatrix = new boolean[stringLength][stringLength];

        for (int j = 1; j < stringLength; j++) {
            for (int i = 0; i < j; i++) {

                boolean isInnerWordPalindrome = palindromeMatrix[i+1][j-1] || j-i <= 2;
                if( word.charAt(i) == word.charAt(j) && isInnerWordPalindrome ) {
                    palindromeMatrix[i][j] = true;

                    if(j-i > rightIndex-leftIndex) {
                        leftIndex = i;
                        rightIndex = j;
                    }
                }

            }
        }

        return word.substring(leftIndex, rightIndex+1);
    }

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        String subString = palindrome.longestPalindrome("kdmalayalamdf");
        System.out.println(subString + " " + subString.length());
    }

}
