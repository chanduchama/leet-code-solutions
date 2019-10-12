package com.leetcode.solutions.all;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * problem statement 6
 */
public class ZigZag {

    public String convert(String s, int numRows) {
        String[] matrix;
        matrix = new String[numRows];
        initiateMatrix(matrix, numRows, s.length());
        int charIndex = 0;
        int row = 0;
        int col = 0;
        boolean isDown = true;
        while(charIndex < s.length()) {
            char character = s.charAt(charIndex++);
            if(isDown==true) {
                char[] stringArray = matrix[row].toCharArray();
                stringArray[col] = character;
                matrix[row] = new String(stringArray);
                if(row < numRows-1) {
                    row++;
                } else {
                    isDown = false;
                }
            } else if(isDown == false) {
                if(row != 0) {
                    --row;
                }
                char[] stringArray = matrix[row].toCharArray();
                stringArray[++col] = character;
                matrix[row] = new String(stringArray);
                if(row == 0) {
                    isDown = true;
                    if(numRows > 1) {
                        row++;
                    } else {
                        col++;
                    }
                }
            }
        }
        printMatrix(matrix, numRows);
        return getString(matrix, numRows, s.length());
    }

    private void initiateMatrix(String[] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < columns; j++) {
                stringBuilder.append("*");
            }
            matrix[i] = stringBuilder.toString();
        }
    }

    private void printMatrix(String[] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i]);
            System.out.println("");
        }
    }

    private String getString(String[] matrix, int rows, int columns) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i].charAt(j) != '*') {
                    builder.append(matrix[i].charAt(j));
                }
            }
        }
        String finalString = builder.toString();
        return finalString;
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING", 3));
    }
}
