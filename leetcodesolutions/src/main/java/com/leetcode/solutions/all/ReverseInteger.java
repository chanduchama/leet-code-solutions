package com.leetcode.solutions.all;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leet code problem 7
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        int reverse = 0;
        Queue<Integer> queue = new LinkedList<Integer>();

        boolean kontinue = true;
        while(kontinue){
            queue.add(x%10);
            x = x/10;
            if(x == 0) {
                kontinue = false;
            }
        }

        reverse = queue.remove();
        while(!queue.isEmpty()) {
            int max = Integer.MAX_VALUE/10;
            int min = Integer.MIN_VALUE/10;
            if (reverse > Integer.MAX_VALUE/10 || reverse < Integer.MIN_VALUE/10) {
                return 0;
            }

            reverse = reverse * 10;
            reverse += queue.remove();
        }
        return reverse;
    }

    public static void main(String[] args) {
        ReverseInteger reverse = new ReverseInteger();
        System.out.println(reverse.reverse(1463847412));
    }
}
